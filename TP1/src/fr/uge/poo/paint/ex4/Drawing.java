package fr.uge.poo.paint.ex4;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Stream;

import fr.uge.poo.simplegraphics.SimpleGraphics;

public class Drawing {
	private static final ArrayList<Shape> listLines = new ArrayList<>();

	public static void readFile(String file) throws IOException {
		Objects.requireNonNull(file, "Your file is null");
		Path path = Paths.get(file);
		try (Stream<String> lines = Files.lines(path)) {
			lines.forEach(line -> listLines.add(decompose(line)));
		}
	}

	private static Shape decompose(String line) {
		String[] tokens = line.split(" ");
		var name = tokens[0];
		int x1 = Integer.parseInt(tokens[1]);
		int y1 = Integer.parseInt(tokens[2]);
		int x2 = Integer.parseInt(tokens[3]);
		int y2 = Integer.parseInt(tokens[4]);
		return switch (name) {
		case "line" -> new Line(x1, y1, x2, y2);
		case "rectangle" -> new Rectangle(x1, y1, x2, y2);
		case "ellipse" -> new Ellipse(x1, y1, x2, y2);
		default -> throw new IllegalArgumentException("Unexpected value: " + name);
		};
	}

	public static void printFigure(Graphics2D graphics) {
		graphics.setColor(Color.BLACK);
		listLines.forEach(t -> t.drawFigure(graphics));
	}

	public static void printCoor(SimpleGraphics area, int x, int y) {
		var res = listLines.stream().min(Comparator.comparingDouble(elem -> {
			return elem.distance(x, y);
		}));
		area.render(graphic -> System.out.println(res));
	}
}
