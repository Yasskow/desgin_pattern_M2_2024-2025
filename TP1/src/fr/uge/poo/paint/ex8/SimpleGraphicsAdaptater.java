package fr.uge.poo.paint.ex8;

import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;
import java.util.function.Consumer;

public final class SimpleGraphicsAdaptater implements Canvas {
	private final SimpleGraphics graphics;
	private Consumer<Graphics2D> consumers;

	public SimpleGraphicsAdaptater(String name, int width, int height) {
		graphics = new SimpleGraphics(name, width, height);
	}

	@FunctionalInterface
	public interface MouseCallBackEvent {
		void onClick(int x, int y);
	}

	@Override
	public void drawLine(int x, int y, int x1, int x2, CanvasColor color) {
		consumers = consumers.andThen(t -> {
			t.setColor(toColor(color));
			t.drawLine(x, y, x1, x2);
		});
	}

	@Override
	public void drawEllipse(int x, int y, int width, int height, CanvasColor color) {
		consumers = consumers.andThen(t -> {
			t.setColor(toColor(color));
			t.drawOval(x, y, width, height);
		});
	}

	@Override
	public void waitForMouseEvents(MouseCallBack mouse) {
		graphics.waitForMouseEvents(mouse::onClick);
	}

	@Override
	public void clear(CanvasColor color) {
		graphics.clear(toColor(color));
		consumers = _ -> {};
	}

	@Override
	public void render() {
		graphics.render(g -> consumers.accept(g));
		graphics.clear(Color.WHITE);
	}

	private Color toColor(CanvasColor color) {
		return switch(color) {
		case BLACK -> Color.BLACK;
		case WHITE -> Color.WHITE;
		case ORANGE -> Color.ORANGE;
        };
	}
}