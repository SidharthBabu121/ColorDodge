package com.test.game;

import java.awt.Color;
import java.awt.Graphics;

public class healthBarPlus {

	public static int HEALTH = 100;
	
	public void tick () {
		HEALTH = ColorShoot.limit(HEALTH, 0, 100);
		if (HEALTH <= 0) {
			System.out.println("GAME OVER");
			System.exit(1);
		}
	}
	
	public void render(Graphics res) {
		res.setColor(Color.red);
		res.fillRect(15, 15, 1000, 40);	
		res.setColor(Color.green);
		res.fillRect(15, 15, HEALTH * 10, 40);
		res.setColor(Color.black);
		res.drawRect(15, 15, 1000, 40);
	}
}
