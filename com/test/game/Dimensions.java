package com.test.game;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Dimensions extends Canvas{

	private static final long serialVersionUID = -2611180309131772663L;
	
	public Dimensions (int width, int height, String name, ColorShoot game) {
		JFrame frame = new JFrame(name);
		
		//Designing the window size
		frame.setPreferredSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		
		//Terminating the program and resizing the window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		//frame.setLocationRelativeTo(null);
		frame.setLocation(400, 0);
		frame.add(game);
		frame.setVisible(true);
		game.start();
	}
	
	
}
