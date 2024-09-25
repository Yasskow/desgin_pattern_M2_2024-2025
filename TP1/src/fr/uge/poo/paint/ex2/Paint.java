package fr.uge.poo.paint.ex2;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import fr.uge.poo.simplegraphics.SimpleGraphics;

public class Paint {
	public record Line(int x0, int y0, int x1, int y1) {}
	private static final ArrayList<Line> listLines = new ArrayList<>();
	
	public static void readFile(String file) throws IOException {
		Objects.requireNonNull(file, "Your file is null");
		Path path = Paths.get(file);
	       try(Stream<String> lines = Files.lines(path)) {
	         lines.forEach(line -> listLines.add(decompose(line)));
	         }
	}
	
	private static Line decompose(String line) {
		String[] tokens = line.split(" ");
	    int x1 = Integer.parseInt(tokens[1]);
	    int y1 = Integer.parseInt(tokens[2]);
	    int x2 = Integer.parseInt(tokens[3]);
	    int y2 = Integer.parseInt(tokens[4]);
	    return new Line(x1, y1, x2, y2);
	}
	
	private static void printLines(Graphics2D graphics) {
		graphics.setColor(Color.BLACK);
		System.out.println(listLines);
		listLines.forEach(t -> graphics.drawLine(t.x0, t.y0, t.x1, t.y1));
	}
	
	public static void main(String[] args) throws IOException {
		Paint.readFile("bin/draw1.txt");
		SimpleGraphics area = new SimpleGraphics("area", 800, 600);
        area.clear(Color.WHITE);
        area.render(Paint::printLines);
	}
}
