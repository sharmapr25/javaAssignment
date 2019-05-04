package robo;

public class Robot {
    private Position position;

    public Robot(Position position) {

        this.position = position;
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