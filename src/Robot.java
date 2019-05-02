import java.util.Arrays;
import java.util.List;

public class Robot {

    private int xCordinate;
    private int yCordinate;
    private char currentDirection;
    private List<Character> directions;

    public Robot(int xCordinate, int yCordinate, char direction) {
        this.xCordinate = xCordinate;
        this.yCordinate = yCordinate;
        this.currentDirection = direction;
        this.directions = Arrays.asList('N', 'E', 'S', 'W');
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
        if(currentDirection == 'N') {
            this.yCordinate++;
        }
        else if (currentDirection == 'S'){
            this.yCordinate--;
        }
        else if(currentDirection == 'E'){
            this.xCordinate++;
        }
        else{
            this.xCordinate--;
        }
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

        if (xCordinate != robot.xCordinate) return false;
        if (yCordinate != robot.yCordinate) return false;
        if (currentDirection != robot.currentDirection) return false;
        return directions != null ? directions.equals(robot.directions) : robot.directions == null;
    }

    @Override
    public int hashCode() {
        int result = xCordinate;
        result = 31 * result + yCordinate;
        result = 31 * result + (int) currentDirection;
        return result;
    }
}