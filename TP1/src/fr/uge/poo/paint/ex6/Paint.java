package fr.uge.poo.paint.ex6;

import fr.uge.poo.simplegraphics.SimpleGraphics;

import java.awt.*;
import java.io.IOException;


public class Paint {
	
	public static void main(String[] args) throws IOException {
		//Drawing.readFile("C:\\Users\\Yassine\\Desktop\\Master 2\\M2\\S1\\Design_Pattern\\TP1\\bin\\draw2.txt");
		Drawing.readFile("bin/draw-big.txt");
		var size = Drawing.size();
		SimpleGraphics area = new SimpleGraphics("area", size.x() > 500 ? size.x():500, size.y() > 500 ? size.y(): 500);
		area.clear(Color.WHITE);
		area.render(Drawing::printFigure);
		area.waitForMouseEvents((x, y) -> Drawing.printCoor(area, x, y));
		//area.render(Drawing::printLastShape);
	}
}