public class Point {

    private int xCoordinate;
    private int yCoordinate;

    public Point(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public void incrementX() {
        this.xCoordinate++;
    }

    public void incrementY() {
        this.yCoordinate++;
    }

    public void decrementX() {
        this.xCoordinate--;
    }

    public void decrementY() {
        this.yCoordinate--;
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
