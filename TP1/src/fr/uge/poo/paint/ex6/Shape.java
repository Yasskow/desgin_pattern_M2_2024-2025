package fr.uge.poo.paint.ex6;

import java.awt.*;

public sealed interface Shape permits Line, ShapeInRect {
	void drawFigure(Graphics2D graphics);
	double distance(int x, int y);
	WindowsSize size();
}
