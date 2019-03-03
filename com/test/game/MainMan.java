package com.test.game;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class MainMan extends GameSprite {
	
	Renderer renderer;
	
	public MainMan(int x, int y, Diff id, Renderer renderer) {
		super(x, y, id);
		this.renderer = renderer;
	}
	

	public Rectangle getBounds() {
		return new Rectangle (x, y, 30, 30);
	}
	
	public void tick() {
		x += xMove;
		y += yMove;
		
		x = ColorShoot.limit(x, 0, ColorShoot.WIDTH - 35);
		y = ColorShoot.limit(y, 60, ColorShoot.HEIGHT - 70);
		
		collision();
	}

	private void collision() {
		for (int i = 0; i < renderer.sprite.size(); i++) {
			GameSprite tempSprite = renderer.sprite.get(i);
			if (tempSprite.summonDiff() == Diff.RedEnemy /*TODO: color conditions? also basically tempSprite is RedEnemy here */) {
				if (getBounds().intersects(tempSprite.getBounds())) {
					//collision code here
					healthBarPlus.HEALTH -= 1;
				}
			}
		}
	}
	
	public void render(Graphics res) {
		
		res.setColor(Color.black);
		res.fillRect(x, y, 30, 30);
	}

}
