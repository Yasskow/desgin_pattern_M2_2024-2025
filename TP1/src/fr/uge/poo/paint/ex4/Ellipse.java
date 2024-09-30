package fr.uge.poo.paint.ex4;

import java.awt.*;

public final class Ellipse extends ShapeInRect{

	public Ellipse(int x, int y, int height, int width) {
		super(x, y, height, width);
	}

	@Override
	public void drawFigure(Graphics2D graphics) {
		graphics.drawOval(x, y, width, height);
	}
}
