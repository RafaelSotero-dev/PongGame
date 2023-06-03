package com.undefined.entity;

import java.awt.Color;
import java.awt.Graphics;

import com.undefined.main.Game;

public class Player extends Entity {

	public boolean right = false, left = false;
	public double speed = 1.2;
	
	public Player(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void tick() {
		if (right) {
			x += speed;
		} else if (left) {
			x -= speed;
		}
		
		if (x > Game.WIDTH - width) {
			x = Game.WIDTH - width;
		} else if (x < 0) {
			x = 0;
		}
	}
	
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}
}
