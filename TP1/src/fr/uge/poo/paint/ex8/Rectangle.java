package fr.uge.poo.paint.ex8;

import fr.uge.poo.paint.ex8.Canvas.CanvasColor;

public final class Rectangle extends ShapeInRect {
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
	public void drawFigure(Canvas graphics, CanvasColor color) {
		graphics.drawRect(x0, y0, width, height, color);
	}

}
