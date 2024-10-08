package fr.uge.poo.paint.ex8;

import fr.uge.poo.paint.ex8.Canvas.CanvasColor;

public final class Ellipse extends ShapeInRect {

	public Ellipse(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	@Override
	public void drawFigure(Canvas graphics, CanvasColor color) {
		graphics.drawEllipse(x, y, width, height, color);
	}

}
