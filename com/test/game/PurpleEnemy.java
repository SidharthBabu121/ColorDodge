package com.test.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;


public class PurpleEnemy extends GameSprite{

	private Renderer renderer;
	
	public PurpleEnemy(int x, int y, Diff id, Renderer renderer) {
		super(x, y, id);
		
		Random rNum = new Random();
		
		this.renderer = renderer;
		
		//enemy speed here.  Must be an even number
		final int bounce = 12;
		xMove = rNum.nextInt(bounce) - bounce/2;
			if (xMove == 0) xMove += 5;
		yMove = rNum.nextInt(bounce) - bounce/2;
			if (yMove == 0) yMove += 5;
	}

	public Rectangle getBounds() {
		return new Rectangle (x, y, 20, 20);
	}
	
	public void tick() {
		x += xMove;
		y += yMove;
		if(y <= 70 || y >= ColorShoot.HEIGHT - 60) yMove *= -1;
		if(x <= 0 || x >= ColorShoot.WIDTH - 20) xMove *= -1;
	}

	public void render(Graphics res) {
		if (id == Diff.PurpleEnemy) {
			res.setColor(Color.magenta);
			res.fillRect(x, y, 20, 20);
		}
	}

}
