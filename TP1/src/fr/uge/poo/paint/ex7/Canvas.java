package fr.uge.poo.paint.ex7;

import java.awt.Color;

public sealed interface Canvas permits SimpleGraphicsAdaptater, CoolGraphicsAdaptater {
	public enum CanvasColor {
		BLACK, WHITE, ORANGE
	}

	@FunctionalInterface
	public interface MouseCallBack {
		void onClick(int x, int y);
	}

	public void clear(CanvasColor color);
	
	public void drawLine(int x, int y, int x1, int x2, CanvasColor color);

	public void drawEllipse(int x, int y, int width, int height, CanvasColor color);

	public void waitForMouseEvents(MouseCallBack mouse);

	default void drawRect(int x, int y, int width, int height, CanvasColor c) {
		drawLine(x, y, x + width, y, c);
		drawLine(x, y + height, x + width, y + height, c);
		drawLine(x, y, x, y + height, c);
		drawLine(x + width, y, x + width, y + height, c);
	}
}
