package fr.uge.poo.paint.ex4;

import java.awt.Color;
import java.io.IOException;

import fr.uge.poo.simplegraphics.SimpleGraphics;


public class Paint {
	
	public static void main(String[] args) throws IOException {
		Drawing.readFile("C:\\Users\\Yassine\\Desktop\\Master 2\\M2\\S1\\Design_Pattern\\TP1\\bin\\draw2.txt");
		SimpleGraphics area = new SimpleGraphics("area", 800, 600);
		area.clear(Color.WHITE);
		area.render(Drawing::printFigure);
		area.waitForMouseEvents((x, y) -> Drawing.printCoor(area, x, y));
	}
}