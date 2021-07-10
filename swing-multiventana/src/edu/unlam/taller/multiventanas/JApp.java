package edu.unlam.taller.multiventanas;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class JApp extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JApp(int width, int height, boolean sound) throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, width, height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		if(sound) {
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(new File("./sonido.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(audioIn);	
			clip.flush();
			clip.setMicrosecondPosition(0);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
		setVisible(true);
	}

}
