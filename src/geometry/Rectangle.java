package geometry;

public class Rectangle {
    private final int length;
    private final int width;

    public Rectangle(int length, int width) {
        this.length = length;
        this.width = width;
    }

    public int getArea() {
        return length * width;
    }

    public int getPerimeter() {
        return 2 * (length + width);
    }

    public static Rectangle createSquare(int side) {
        return new Rectangle(side, side);
    }

    public static Rectangle createRectangle(int length, int width) {
        return new Rectangle(length, width);
    }
}
