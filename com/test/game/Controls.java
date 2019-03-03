package com.test.game;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Controls extends KeyAdapter{

	private Renderer renderer;
	
	public Controls(Renderer renderer) {
		this.renderer = renderer;
	}

	
	int moveSpeed = 10;
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i = 0; i < renderer.sprite.size(); i++) {
			GameSprite tempSprite = renderer.sprite.get(i);
			
			if (tempSprite.summonDiff() == Diff.Player) {
				//Any controls for Player 1 here
				//Movement
				if (key == KeyEvent.VK_W) tempSprite.setYMove(-moveSpeed);
				if (key == KeyEvent.VK_A) tempSprite.setXMove(-moveSpeed);
				if (key == KeyEvent.VK_S) tempSprite.setYMove(moveSpeed);
				if (key == KeyEvent.VK_D) tempSprite.setXMove(moveSpeed);
			}
		}
		if (key == KeyEvent.VK_ESCAPE) System.exit(1);
	}
	
	//Color Switch
	//if (key == KeyEvent.VK_Y) fill = red;
	//return fill;
	
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		for (int i = 0; i < renderer.sprite.size(); i++) {
			GameSprite tempSprite = renderer.sprite.get(i);
			
			if (tempSprite.summonDiff() == Diff.Player) {
				//Any controls for Player 1 here
				if (key == KeyEvent.VK_W) tempSprite.setYMove(0);
				if (key == KeyEvent.VK_A) tempSprite.setXMove(0);
				if (key == KeyEvent.VK_S) tempSprite.setYMove(0);
				if (key == KeyEvent.VK_D) tempSprite.setXMove(0);
			}
		}

	}
}
