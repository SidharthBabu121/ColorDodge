package com.test.game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameSprite {
	protected int x, y;
	protected Diff id;
	protected int xMove, yMove;
	
	public GameSprite(int x, int y, Diff id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics res);
	public abstract Rectangle getBounds();
	
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int summonX() {
		return x;
	}
	public int summonY() {
		return y;
	}
	public void Differentiate(Diff id) {
		this.id = id;
	}
	public Diff summonDiff() {
		return id;
	}
	public void setXMove(int xMove) {
		this.xMove = xMove;
	}
	public void setYMove(int yMove) {
		this.yMove = yMove;
	}
	public int summonXMove() {
		return xMove;
	}
	public int summonYMove() {
		return yMove;
	}
}
