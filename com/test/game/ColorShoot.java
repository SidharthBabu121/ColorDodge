package com.test.game;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class ColorShoot extends Canvas implements Runnable{

	private static final long serialVersionUID = 8078479178424421479L;

	public static final int WIDTH = 1200, HEIGHT = WIDTH / 6 * 4;
	private Thread notRecommended;
	private boolean working = false;
	
	private Random rNum;
	private Renderer renderer;
	private healthBarPlus hbp;
	
	public ColorShoot() {
		renderer = new Renderer();
		this.addKeyListener(new Controls(renderer));
		
		new Dimensions(WIDTH, HEIGHT, "HackMerced IV Game: Color Shooter II", this);
		
		hbp = new healthBarPlus();
		
		rNum = new Random();
		
		renderer.addSprite(new MainMan(WIDTH/2, HEIGHT/2, Diff.Player, renderer));
		
		//number of enemies here
		for (int i = 0; i < 10; i++) {
			//renderer.addSprite(new RedEnemy(rNum.nextInt(WIDTH), rNum.nextInt(HEIGHT), Diff.RedEnemy, renderer));
			float j = 0;
			while (j < 17000000) j++;
		}
	}
	
	public synchronized void start() {
		notRecommended = new Thread(this);
		notRecommended.start();
		working = true;
	}

	public synchronized void stop() {
		try {
			notRecommended.join();
			working = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void run () {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		int sec = 0;
		while (working) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if (working)
				render();
			frames++;
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println("FPS: " + frames + "\nSeconds: " + sec);
				System.out.println("Seconds: " + sec);
				sec++;
				frames = 0;
				int eType = rNum.nextInt(5);
				//System.out.print(eType); //DISABLED:  Prints enemy type 
				if (eType == 0) renderer.addSprite(new RedEnemy(rNum.nextInt(WIDTH), rNum.nextInt(HEIGHT), Diff.RedEnemy, renderer));
				if (eType == 1) renderer.addSprite(new BlueEnemy(rNum.nextInt(WIDTH), rNum.nextInt(HEIGHT), Diff.BlueEnemy, renderer));
				if (eType == 2) renderer.addSprite(new GreenEnemy(rNum.nextInt(WIDTH), rNum.nextInt(HEIGHT), Diff.GreenEnemy, renderer));
				if (eType == 3) renderer.addSprite(new YellowEnemy(rNum.nextInt(WIDTH), rNum.nextInt(HEIGHT), Diff.YellowEnemy, renderer));
				if (eType == 4) renderer.addSprite(new PurpleEnemy(rNum.nextInt(WIDTH), rNum.nextInt(HEIGHT), Diff.PurpleEnemy, renderer));
			}
		}
		stop();
	}
	
	private void tick() {
		renderer.tick();
		hbp.tick();
	}
	
	private void render() {
		BufferStrategy bufStrat = this.getBufferStrategy();
		if (bufStrat == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics res = bufStrat.getDrawGraphics();
		
		//background design
		res.setColor(Color.cyan);
		res.fillRect(0, 0, WIDTH, HEIGHT);
		
		renderer.render(res);
		
		hbp.render(res);
		
		res.dispose();
		bufStrat.show();
	}
	
	public static int limit(int var, int low, int high) {
		if(var >= high) return var = high;
		else if (var <= low) return var = low;
		else return var;
	}
	
	public static void main(String[] args) {
		new ColorShoot();
	}

}
