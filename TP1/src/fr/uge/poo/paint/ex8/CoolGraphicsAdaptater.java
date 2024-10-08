package fr.uge.poo.paint.ex8;

import com.evilcorp.coolgraphics.CoolGraphics;
import com.evilcorp.coolgraphics.CoolGraphics.ColorPlus;


public final class CoolGraphicsAdaptater implements Canvas {

	private final CoolGraphics graphics;

	public CoolGraphicsAdaptater(String name, int x, int y) {
		this.graphics = new CoolGraphics(name, x, y);
	}

	@Override
	public void drawLine(int x, int y, int x1, int x2, CanvasColor color) {
		graphics.drawLine(x, y, x1, x2, toColor(color));
	}

	@Override
	public void drawEllipse(int x, int y, int width, int height, CanvasColor color) {
		graphics.drawEllipse(x, y, width, height, toColor(color));
	}

	@Override
	public void waitForMouseEvents(MouseCallBack mouse) {
		graphics.waitForMouseEvents(mouse::onClick);
	}

	@Override
	public void clear(CanvasColor color) {
		graphics.repaint(toColor(color));
	}

	@Override
	public void render() {
    }

	private ColorPlus toColor(CanvasColor color) {
		return switch (color) {
		case BLACK -> ColorPlus.BLACK;
		case WHITE -> ColorPlus.WHITE;
		case ORANGE -> ColorPlus.ORANGE;
        };
	}

}
