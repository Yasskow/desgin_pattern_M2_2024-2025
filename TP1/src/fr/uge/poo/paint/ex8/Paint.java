package fr.uge.poo.paint.ex8;

import fr.uge.poo.paint.ex8.Canvas.CanvasColor;

import java.io.IOException;


public class Paint {
	
	public static void main(String[] args) throws IOException {
		Drawing.readFile("C:\\Users\\Yassine\\Desktop\\Master 2\\M2\\S1\\Design_Pattern\\TP1\\bin\\draw-big.txt");
		//Drawing.readFile("bin/draw-big.txt");
		var size = Drawing.size();
		Canvas area;
		if(args.length == 1 && args[0].equals("-legacy")) {
			 area = new SimpleGraphicsAdaptater("area", Math.max(size.x(), 500), Math.max(size.y(), 500));
			System.out.println("TEST");
		} else {
			 area = new CoolGraphicsAdaptater("area", Math.max(size.x(), 500), Math.max(size.y(), 500));
		}

		area.clear(CanvasColor.WHITE);
		Drawing.printFigure(area);
		area.waitForMouseEvents((x, y) -> Drawing.printCoor(area, x, y));
	}
}