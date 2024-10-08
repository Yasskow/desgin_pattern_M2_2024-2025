package fr.uge.poo.paint.ex8;

abstract sealed class ShapeInRect implements Shape permits Rectangle, Ellipse {
	int x;
    int y;
    int height;
    int width;
    int centerX;
    int centerY;
    public ShapeInRect(int x, int y, int width, int height) {
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
    
	@Override
	public WindowsSize size() {
		return new WindowsSize(x+width, y+height);
	}
    
}
