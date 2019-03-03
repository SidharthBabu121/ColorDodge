package com.test.game;

import java.awt.Graphics;
import java.util.LinkedList;

public class Renderer {
	LinkedList<GameSprite> sprite = new LinkedList<GameSprite>();
	
	public void tick() {
		for (int i = 0; i < sprite.size(); i++) {
			GameSprite tempSprite = sprite.get(i);
			
			tempSprite.tick();
		}
	}
	
	public void render(Graphics res) {
		for (int i = 0; i < sprite.size(); i++) {
			GameSprite tempSprite = sprite.get(i);
			
			tempSprite.render(res);
		}
	}
	
	public void addSprite(GameSprite sprite) {
		this.sprite.add(sprite);
	}
	
	public void removeSprite(GameSprite sprite) {
		this.sprite.remove(sprite);
	}
}
