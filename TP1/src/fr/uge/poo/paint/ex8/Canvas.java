package fr.uge.poo.paint.ex8;

public sealed interface Canvas permits SimpleGraphicsAdaptater, CoolGraphicsAdaptater {
	enum CanvasColor {
		BLACK, WHITE, ORANGE
	}

	@FunctionalInterface
	interface MouseCallBack {
		void onClick(int x, int y);
	}

	void clear(CanvasColor color);
	
	void drawLine(int x, int y, int x1, int x2, CanvasColor color);

	void drawEllipse(int x, int y, int width, int height, CanvasColor color);

	void waitForMouseEvents(MouseCallBack mouse);

	default void drawRect(int x, int y, int width, int height, CanvasColor c) {
		drawLine(x, y, x + width, y, c);
		drawLine(x, y + height, x + width, y + height, c);
		drawLine(x, y, x, y + height, c);
		drawLine(x + width, y, x + width, y + height, c);
	}

	void render();
}
