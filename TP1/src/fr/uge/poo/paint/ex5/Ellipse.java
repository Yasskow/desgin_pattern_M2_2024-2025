package fr.uge.poo.paint.ex5;

import java.awt.*;

public final class Ellipse extends ShapeInRect implements Shape {
	private final int x0;
	private final int y0;
	private final int width;
	private final int height;

	public Ellipse(int x, int y, int height, int width) {
		super(x, y, height, width);
		this.x0 = x;
		this.y0 = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public void drawFigure(Graphics2D graphics) {
		graphics.drawOval(x0, y0, width, height);
	}
}
