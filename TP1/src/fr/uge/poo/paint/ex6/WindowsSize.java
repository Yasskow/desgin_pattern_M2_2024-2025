package fr.uge.poo.paint.ex6;

import java.util.Objects;

public record WindowsSize(int x, int y) {
	public WindowsSize{
		
	}
	
	public static WindowsSize union(WindowsSize windows1, WindowsSize windows2) {
		Objects.requireNonNull(windows1);
		Objects.requireNonNull(windows2);
		int w = windows1.x() > windows2.x() ? windows1.x(): windows2.x();
		int h = windows1.y() > windows2.y() ? windows1.y(): windows2.y();
		return new WindowsSize(w, h);
	}
}
