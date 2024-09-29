package fr.uge.poo.paint.ex5;

import java.awt.*;

public sealed interface Shape permits Line, Ellipse, Rectangle {
	void drawFigure(Graphics2D graphics);
	double distance(int x, int y);
}
