package robo;

public class RobotSimulator {


    private Robot robot;

    public RobotSimulator(Robot robot) {
        this.robot = robot;
    }

    public void process(String instructions) {
        if (!instructions.isEmpty()) {
            for (String instruction : instructions.split("")) {
                if (instruction.equals("R")) {
                    robot.turnRight();
                } else if (instruction.equals("L")) {
                    robot.turnLeft();
                } else {
                    robot.move();
                }
            }
        }
    }

}
