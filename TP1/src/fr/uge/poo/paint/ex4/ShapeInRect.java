package fr.uge.poo.paint.ex4;

abstract sealed class ShapeInRect implements Shape permits Rectangle, Ellipse{
	int x;
    int y;
    int height;
    int width;
    int centerX;
    int centerY;
    public ShapeInRect(int x, int y, int height, int width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.centerX = x + (width / 2);
        this.centerY = y + (height / 2);
    }

    
    public double distance(int x0, int y0){
        return (centerX-x0)*(centerX-x0) + (centerY-y0)*(centerY-y0);
    }
}
