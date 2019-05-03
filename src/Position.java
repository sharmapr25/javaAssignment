import java.util.Arrays;
import java.util.List;

public class Position {
    private final Point point;
    private final Direction direction;
    private List<Direction> directions;

    public Position(Point point, Direction direction) {
        this.point = point;
        this.direction = direction;
        this.directions = Arrays.asList(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);
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

    public Position turnLeft() {
        try{
            return new Position(this.point, directions.get(directions.indexOf(this.direction) - 1));
        }catch (ArrayIndexOutOfBoundsException e){
            return new Position(this.point, directions.get(directions.size()-1));
        }
    }

    public Position turnRight() {
        try{
            return new Position(this.point, directions.get(directions.indexOf(direction)+1));
        }catch (ArrayIndexOutOfBoundsException e){
            return new Position(this.point, directions.get(0));
        }
    }

    public Position move() {
        return new Position(direction.changeCoordinates(point), direction);
    }
}
