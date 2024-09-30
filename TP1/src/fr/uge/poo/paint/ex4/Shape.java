package fr.uge.poo.paint.ex4;

import java.awt.Graphics2D;

public sealed interface Shape permits Line, ShapeInRect {
	void drawFigure(Graphics2D graphics);
	double distance(int x, int y);
}
