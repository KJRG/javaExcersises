package com.capgemini.taxi;

public class Point {
	private int x, y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public double distance(Point p) {
		return Math.sqrt((this.x - p.x) * (this.x - p.x)
				+ (this.y - p.y) * (this.y - p.y));
	}
}
