package com.undefined.entity;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import com.undefined.main.Game;

public class Ball extends Entity {

	public double dx, dy;
	public double speed = 1.6;
	
	public Ball(int x, int y, int width, int height) {
		super(x, y, width, height);
		
		int angle = new Random().nextInt(120 - 45) + 45;
		dx = Math.cos(Math.toRadians(angle));
		dy = Math.sin(Math.toRadians(angle));
	}

	public void tick() {		
		if (x+(speed*dx)+width > Game.WIDTH - width) {
			dx*=-1;
		} else if (x+(speed*dx)  < 0) {
			dx*=-1;
		}
		
		Rectangle bound = new Rectangle(getX(), getY(), getWidth(), getHeight());
		
		Rectangle boundPlayer = new Rectangle(Game.player.getX(), Game.player.getY(), Game.player.getWidth(), Game.player.getHeight());
		Rectangle boundEnemy = new Rectangle(Game.enemy.getX(), Game.enemy.getY(), Game.enemy.getWidth(), Game.enemy.getHeight());
		
		if (bound.intersects(boundPlayer)) {
			int angle = new Random().nextInt(120 - 45) + 45;
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			if (x >0)
				dy*=-1;
		} else if (bound.intersects(boundEnemy)) {
			int angle = new Random().nextInt(120 - 45) + 45;
			dx = Math.cos(Math.toRadians(angle));
			dy = Math.sin(Math.toRadians(angle));
			if (x < 0)
				dy*=-1; 
		}
		
		if (y >= Game.HEIGHT) {
			System.out.println("Ponto do inimigo!!");
			Game.entities = new ArrayList<Entity>();
			Game.player = new Player((Game.WIDTH/2) - 25, Game.HEIGHT-6, 50, 6);
			Game.enemy = new Enemy((Game.WIDTH/2) - 25, 0, 50, 6);
			Game.ball = new Ball((Game.WIDTH/2)-2, Game.HEIGHT/2-2, 4, 4);
			Game.entities.add(Game.enemy);
			Game.entities.add(Game.player);
			Game.entities.add(Game.ball);
		} else if (y < 0) {
			System.out.println("Ponto do nosso!!");
			Game.entities = new ArrayList<Entity>();
			Game.player = new Player((Game.WIDTH/2) - 25, Game.HEIGHT-6, 50, 6);
			Game.enemy = new Enemy((Game.WIDTH/2) - 25, 0, 50, 6);
			Game.ball = new Ball((Game.WIDTH/2)-2, Game.HEIGHT/2-2, 4, 4);
			Game.entities.add(Game.enemy);
			Game.entities.add(Game.player);
			Game.entities.add(Game.ball);
		}
		
		
		x+= dx*speed;
		y+= dy*speed;
	}
	
	public void render(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
}
