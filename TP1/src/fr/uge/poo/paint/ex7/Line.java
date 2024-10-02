package fr.uge.poo.paint.ex7;

import fr.uge.poo.paint.ex7.Canvas.CanvasColor;

public record Line(int x0, int y0, int x1, int y1) implements Shape {
	@Override
	public void drawFigure(Canvas graphics, CanvasColor color) {
		graphics.drawLine(x0, y0, x1, y1, color);
	}
	

	@Override
	public double distance(int x, int y) {
		int centerX = (x0+x1)/2;
		int centerY = (y0+y1)/2;
		return (centerX-x)*(centerX-x) + (centerY-y)*(centerY-y);
	}


	@Override
	public WindowsSize size() {
		return new WindowsSize(x0+x1, y0+y1);
	}
}
