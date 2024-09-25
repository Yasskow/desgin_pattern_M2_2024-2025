package fr.uge.poo.paint.ex3;

import java.awt.Graphics2D;

public sealed interface Shape permits Line, Ellipse, Rectangle{
	public void drawFigure(Graphics2D graphics);
}
