package fr.uge.poo.paint.ex4;

import java.awt.Graphics2D;

public record Line(int x0, int y0, int x1, int y1) implements Shape{
	@Override
	public void drawFigure(Graphics2D graphics) {
		graphics.drawLine(x0, y0, x1, y1);
	}
	

	@Override
	public double distance(int x, int y) {
		int centerX = (x0+x1)/2;
		int centerY = (y0+y1)/2;
		return (centerX-x)*(centerX-x) + (centerY-y)*(centerY-y);
	}
}
