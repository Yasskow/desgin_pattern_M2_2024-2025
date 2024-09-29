package fr.uge.poo.paint.ex5;

abstract class ShapeInRect {
	private final int x;
    private final int y;
    private final int height;
    private final int width;
    private final int centerX;
    private final int centerY;
    public ShapeInRect(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.centerX = x + (width / 2);
        this.centerY = y + (height / 2);
    }

    public double distance(int x, int y){
        return (centerX-x)*(centerX-x) + (centerY-y)*(centerY-y);
    }
}
