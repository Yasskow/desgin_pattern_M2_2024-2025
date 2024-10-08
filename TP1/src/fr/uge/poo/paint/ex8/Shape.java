package fr.uge.poo.paint.ex8;

import fr.uge.poo.paint.ex8.Canvas.CanvasColor;

public sealed interface Shape permits Line, ShapeInRect {
	void drawFigure(Canvas graphics, CanvasColor color);
	double distance(int x, int y);
	WindowsSize size();
}
