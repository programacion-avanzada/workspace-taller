package demo_ball_real_time_with_gravity;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound2Channels {
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

	public void setVolume(float leftVolume, float rightVolume) {
		if (leftVolume < 0f || leftVolume > 1f)
			throw new IllegalArgumentException("Volume not valid: " + leftVolume);
		if (rightVolume < 0f || rightVolume > 1f)
			throw new IllegalArgumentException("Volume not valid: " + rightVolume);
		FloatControl gainControl = (FloatControl) leftClip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(Math.max(-80f, 20f * (float) Math.log10(leftVolume)));
		gainControl = (FloatControl) rightClip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(Math.max(-80f, 20f * (float) Math.log10(rightVolume)));
	}
}
