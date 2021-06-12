package demo_ball_real_time_with_gravity;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound2Channels {
	float volume = 1f;
	double balance = 0.0;

	Clip leftClip;
	Clip rightClip;

	public Sound2Channels(String left, String right) throws Exception {
		AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(left));
		leftClip = AudioSystem.getClip();
		leftClip.open(audioIn);
		audioIn = AudioSystem.getAudioInputStream(new File(right));
		rightClip = AudioSystem.getClip();
		rightClip.open(audioIn);
	}

	public void play() {
		leftClip.stop();
		leftClip.flush();
		leftClip.setMicrosecondPosition(0);
		rightClip.stop();
		rightClip.flush();
		rightClip.setMicrosecondPosition(0);

		synchronized (this) {
			leftClip.start();
			rightClip.start();
		}
	}

	private void setGainControl() {
		double rightBalance = (balance + 1) / 2;
		double leftBalance = 1 - rightBalance;
		FloatControl gainControl = (FloatControl) leftClip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(Math.max(-80f, 20f * (float) Math.log10(leftBalance * volume)));
		gainControl = (FloatControl) rightClip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(Math.max(-80f, 20f * (float) Math.log10(rightBalance * volume)));
	}

	public void setBalance(double balance) {
		if (balance < -1.0 || balance > 1.0)
			throw new IllegalArgumentException("Balance " + balance + "must be between -1.0 and 1.0");
		this.balance = balance;
		setGainControl();
	}

	public void setVolume(float volume) {
		if (volume < 0f || volume > 1f)
			throw new IllegalArgumentException("Volume " + volume + "must be between 0f and 1f");
		this.volume = volume;
		setGainControl();
	}
}
