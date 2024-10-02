package fr.uge.poo.paint.ex7;

import java.awt.Color;
import java.util.Objects;


import fr.uge.poo.simplegraphics.SimpleGraphics;

public final class SimpleGraphicsAdaptater implements Canvas {
	private final SimpleGraphics graphics;

	public SimpleGraphicsAdaptater(String name, int width, int height) {
		graphics = new SimpleGraphics(name, width, height);
	}

	@FunctionalInterface
	public interface MouseCallBackEvent {
		void onClick(int x, int y);
	}

	public void clear(Color color) {
		Objects.requireNonNull(color);
		graphics.clear(color);
	}

	@Override
	public void drawLine(int x, int y, int x1, int x2, CanvasColor color) {
		graphics.render(render -> {
			render.setColor(toColor(color));
			render.drawLine(x, y, x1, x2);
		});
	}

	@Override
	public void drawEllipse(int x, int y, int width, int height, CanvasColor color) {
		graphics.render(render -> {
			render.setColor(toColor(color));
			render.drawOval(x, y, width, height);
		});
	}

	@Override
	public void waitForMouseEvents(MouseCallBack mouse) {
		graphics.waitForMouseEvents(mouse::onClick);
	}
	
	private Color toColor(CanvasColor color) {
		return switch(color) {
		case BLACK -> Color.BLACK;
		case WHITE -> Color.ORANGE;
		case ORANGE -> Color.ORANGE;
		default -> throw new UnsupportedOperationException("Unexpected value: " + color);
		};
	}

	@Override
	public void clear(CanvasColor color) {
		// TODO Auto-generated method stub
	}

}