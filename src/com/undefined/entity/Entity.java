package com.undefined.entity;

import java.awt.Color;
import java.awt.Graphics;

public class Entity {

	protected double x,y,width,height;
	
	public Entity(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}
	
	public int getX() {
		return (int)this.x;	
	}
	
	public void setX(int newX) {
		this.x = newX;	
	}
	
	public int getY() {
		return (int)this.y;	
	}
	
	public void setY(int newY) {
		this.y = newY;	
	}
	
	public int getWidth() {
		return (int)this.width;	
	}
	
	public void setWidth(int newWidth) {
		this.width = newWidth;	
	}
	
	public int getHeight() {
		return (int)this.height;	
	}
	
	public void setHeight(int newHeight) {
		this.height = newHeight;	
	}
	
	public void tick() {}
	
	public void render(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(getX(), getY(), getWidth(), getHeight());
	}
	
}
