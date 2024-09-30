package fr.uge.poo.paint.ex6;

import java.awt.*;

public final class Ellipse extends ShapeInRect{

	public Ellipse(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	@Override
	public void drawFigure(Graphics2D graphics) {
		graphics.drawOval(x, y, width, height);
	}

}
