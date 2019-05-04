package robo;

public class Point {

    private final int xCoordinate;
    private final int yCoordinate;

    public Point(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public Point incrementX() {
        return new Point(this.xCoordinate+1, this.yCoordinate);
    }

    public Point incrementY() {
        return new Point(this.xCoordinate, this.yCoordinate+1);
    }

    public Point decrementX() {
        return new Point(this.xCoordinate-1, this.yCoordinate);
    }

    public Point decrementY() {
        return new Point(this.xCoordinate, this.yCoordinate-1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Point point = (Point) o;

        if (xCoordinate != point.xCoordinate) return false;
        return yCoordinate == point.yCoordinate;
    }

    @Override
    public int hashCode() {
        int result = xCoordinate;
        result = 31 * result + yCoordinate;
        return result;
    }
}
