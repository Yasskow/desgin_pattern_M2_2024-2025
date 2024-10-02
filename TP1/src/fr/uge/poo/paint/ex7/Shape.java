package fr.uge.poo.paint.ex7;

import fr.uge.poo.paint.ex7.Canvas.CanvasColor;

public sealed interface Shape permits Line, ShapeInRect {
	void drawFigure(Canvas graphics, CanvasColor color);
	double distance(int x, int y);
	WindowsSize size();
}
