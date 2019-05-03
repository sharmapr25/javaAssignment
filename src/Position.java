public class Position {
    private final Point point;
    private final Direction direction;

    public Position(Point point, Direction direction) {
        this.point = point;
        this.direction = direction;
    }

    public Position turnLeft() {
       return new Position(this.point, this.direction.left());
    }

    public Position turnRight() {
        return new Position(this.point, this.direction.right());
    }

    public Position move() {
        return new Position(direction.changeCoordinates(point), direction);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Position position = (Position) o;

        if (point != null ? !point.equals(position.point) : position.point != null) return false;
        return direction == position.direction;
    }

    @Override
    public int hashCode() {
        int result = point != null ? point.hashCode() : 0;
        result = 31 * result + (direction != null ? direction.hashCode() : 0);
        return result;
    }
}
