import java.util.Arrays;
import java.util.List;

public class Robot {

    Point point;
    private Direction currentDirection;
    private List<Direction> directions;

    public Robot(int xCoordinate, int yCoordinate, Direction direction) {
        this.point = new Point(xCoordinate, yCoordinate);
        this.currentDirection = direction;
        this.directions = Arrays.asList(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST);
    }

    public void process(String instructions) {
        if(!instructions.isEmpty()){
            for (String instruction : instructions.split("")){
                if(instruction.equals("R")){
                    turnRight();
                }
                else if(instruction.equals("L")){
                    turnLeft();
                }
                else{
                    move();
                }
            }
        }
    }

    private void move() {
        currentDirection.changeCoordinates(point);
    }


    private void turnLeft() {
        try{
            this.currentDirection = directions.get(directions.indexOf(currentDirection)-1);
        }catch (ArrayIndexOutOfBoundsException e){
            this.currentDirection = directions.get(directions.size()-1);
        }
    }

    private void turnRight() {
        try{
            this.currentDirection = directions.get(directions.indexOf(currentDirection)+1);
        }catch (ArrayIndexOutOfBoundsException e){
            this.currentDirection = directions.get(0);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Robot robot = (Robot) o;

        if (point != null ? !point.equals(robot.point) : robot.point != null) return false;
        return currentDirection == robot.currentDirection;
    }

    @Override
    public int hashCode() {
        int result = point != null ? point.hashCode() : 0;
        result = 31 * result + (currentDirection != null ? currentDirection.hashCode() : 0);
        return result;
    }
}