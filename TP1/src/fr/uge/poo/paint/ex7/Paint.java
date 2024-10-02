package fr.uge.poo.paint.ex7;

import java.io.IOException;

import com.evilcorp.coolgraphics.CoolGraphics;

import fr.uge.poo.paint.ex7.Canvas.CanvasColor;
import fr.uge.poo.simplegraphics.SimpleGraphics;


public class Paint {
	
	public static void main(String[] args) throws IOException {
		//Drawing.readFile("C:\\Users\\Yassine\\Desktop\\Master 2\\M2\\S1\\Design_Pattern\\TP1\\bin\\draw2.txt");
		Drawing.readFile("bin/draw-big.txt");
		var size = Drawing.size();
		Canvas area;
		if(args.length == 1 && args[0].equals("-legacy")) {
			 area = new SimpleGraphicsAdaptater("area", size.x() > 500 ? size.x():500, size.y() > 500 ? size.y(): 500);
		} else {
			 area = new CoolGraphicsAdaptater("area", size.x() > 500 ? size.x():500, size.y() > 500 ? size.y(): 500);
		}
		
		area.clear(CanvasColor.WHITE);
		Drawing.printFigure(area);
		area.waitForMouseEvents((x, y) -> {
			
		});
		
	}
}