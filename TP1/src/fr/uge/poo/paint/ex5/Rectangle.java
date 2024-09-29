package fr.uge.poo.paint.ex5;

import java.awt.*;

public final class Rectangle extends ShapeInRect implements Shape {
	private final int x0;
	private final int y0;
	private final int width;
	private final int height;
	public Rectangle(int x0, int y0, int width, int height) {
        super(x0, y0, width, height);
		this.x0 = x0;
		this.y0 = y0;
		this.width = width;
		this.height = height;
	}

	@Override
	public void drawFigure(Graphics2D graphics) {
		graphics.drawRect(x0, y0, width, height);
	}
}
