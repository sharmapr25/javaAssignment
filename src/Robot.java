public class Robot {
    private Position position;

    public Robot(Position position) {

        this.position = position;
    }

    public void process(String instructions) {
        if (!instructions.isEmpty()) {
            for (String instruction : instructions.split("")) {
                if (instruction.equals("R")) {
                    turnRight();
                } else if (instruction.equals("L")) {
                    turnLeft();
                } else {
                    move();
                }
            }
        }
    }

    public void move() {
        this.position = this.position.move();

    }

    public void turnLeft() {
        this.position = this.position.turnLeft();
    }

    public void turnRight() {
        this.position = this.position.turnRight();

    }

    public boolean hasSamePosition(Position expectedPosition) {
        return this.position.equals(expectedPosition);
    }
}