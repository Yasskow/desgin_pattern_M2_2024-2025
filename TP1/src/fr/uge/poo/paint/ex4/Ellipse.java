package fr.uge.poo.paint.ex4;

import java.awt.Graphics2D;

public record Ellipse(int x0, int y0, int width, int height) implements Shape{

	@Override
	public void drawFigure(Graphics2D graphics) {
		graphics.drawOval(x0, y0, width, height);
	}

	@Override
	public double distance(int x, int y) {
		int centerX = x0+(width/2);
		int centerY = y0+(height/2);
		return (centerX-x)*(centerX-x) + (centerY-y)*(centerY-y);
	}
}
