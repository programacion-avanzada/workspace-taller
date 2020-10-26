package demo_ball_real_time_with_gravity;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class Sound {
	Clip clip;

	public Sound(String path) throws Exception {
		AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File(path));
		clip = AudioSystem.getClip();
		clip.open(audioIn);
	}

	public void play() {
		clip.stop();
		clip.flush();
		clip.setMicrosecondPosition(0);
		clip.start();
	}

	public void setVolume(float volume) {
		if (volume < 0f || volume > 1f)
			throw new IllegalArgumentException("Volume not valid: " + volume);
		FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
		gainControl.setValue(20f * (float) Math.log10(volume));
	}
}
