package fr.uge.poo.paint.ex3;

import java.awt.Graphics2D;

public record Rectangle(int x0, int y0, int width, int height) implements Shape{

	@Override
	public void drawFigure(Graphics2D graphics) {
		graphics.drawRect(x0, y0, width, height);
	}
	
}
