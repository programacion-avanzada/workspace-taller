package demo_ball_real_time_with_gravity;

import javafx.scene.media.AudioClip;

public class Sound2ChannelsFX {
	AudioClip audioClip;

	public Sound2ChannelsFX(String sound) {
		audioClip = new AudioClip("file:/D:/projects/eclipse-workspace/Graphics/" + sound);
	}

	public void play() {
		audioClip.play();
	}

	public void setBalance(double balance) {
		audioClip.setBalance(balance);
	}
	
	public void setVolume(double volume) {
		audioClip.setVolume(volume);
	}
}
