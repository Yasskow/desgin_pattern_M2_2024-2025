package fr.uge.poo.paint.ex7;

import java.awt.Color;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Objects;
import java.util.stream.Stream;

import fr.uge.poo.paint.ex7.Canvas.CanvasColor;

public class Drawing {
	private static final ArrayList<Shape> listLines = new ArrayList<>();
	private static Shape lastShape;

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

	public static void printFigure(Canvas graphics) {
		listLines.forEach(t -> t.drawFigure(graphics, CanvasColor.BLACK));
	}

	public static void printCoor(Canvas area, int x, int y) {
		if(lastShape != null){
			lastShape.drawFigure(area, CanvasColor.ORANGE);
		}
		lastShape = listLines.stream().min(Comparator.comparingDouble(elem -> elem.distance(x, y))).orElse(null);
		lastShape.drawFigure(area, CanvasColor.BLACK);
	}
	
	public static WindowsSize size(){
        return listLines.stream()
                      .map(Shape::size)
                      .reduce(new WindowsSize(0,0),WindowsSize::union);
    }
}
