package fr.uge.poo.paint.ex3;

import java.awt.Graphics2D;

public record Line(int x0, int y0, int x1, int y1) implements Shape{

	@Override
	public void drawFigure(Graphics2D graphics) {
		graphics.drawLine(x0, y0, x1, y1);
	}
	
}
