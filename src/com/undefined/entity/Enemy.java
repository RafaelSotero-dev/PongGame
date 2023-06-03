package com.undefined.entity;

import java.awt.Color;
import java.awt.Graphics;

import com.undefined.main.Game;

public class Enemy extends Entity {
	
	public Enemy(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void tick() {
		x+= (Game.ball.x - x - 6) *0.8;
		
		if (x > Game.WIDTH - width) {
			x = Game.WIDTH - width;
		} else if (x < 0) {
			x = 0;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
}
