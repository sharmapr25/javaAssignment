import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    @Test
    @DisplayName("current position should be same when no instruction has given")
    public void testCurrentPositionWhenNoInstructionHasGiven() {
        
        Robot robot = new Robot(7, 3, Direction.NORTH);
        robot.process("");

        Robot expectedRobot = new Robot(7, 3, Direction.NORTH);
        assertTrue(robot.equals(expectedRobot));
    }

    @Test
    @DisplayName("current position should change Direction.NORTH to east when given instruction is turning right")
    public void testCurrentPositionWhenGivenDirectionIsNorthWithInstructionsR() {
        Robot robot = new Robot(7, 3, Direction.NORTH);
        robot.process("R");

        Robot expectedRobot = new Robot(7, 3, Direction.EAST);
        assertTrue(robot.equals(expectedRobot));

    }

    @Test
    @DisplayName("current position should change direction west to north when given instruction is turning right")
    public void testCurrentPositionWhenGivenDirectionIsWestWithInstructionsR() {
        Robot robot = new Robot(7, 3, Direction.WEST);
        robot.process("R");

        Robot expectedRobot = new Robot(7, 3, Direction.NORTH);
        assertTrue(robot.equals(expectedRobot));
    }


    @Test
    @DisplayName("current position should changed direction east to north when given instruction is turning left")
    public void testCurrentPositionWhenGivenDirectionIsEastWithInstructionsL() {
        Robot robot = new Robot(7, 3, Direction.EAST);
        robot.process("L");

        Robot expectedRobot = new Robot(7, 3, Direction.NORTH);
        assertTrue(robot.equals(expectedRobot));
    }

    @Test
    @DisplayName("current position should changed Direction.NORTH to west when given instruction is turning left")
    public void testCurrentPositionWhenGivenDirectionIsNorthWithInstructionsIsL() {
        Robot robot = new Robot(7, 3, Direction.NORTH);
        robot.process("L");
        Robot expectedRobot = new Robot(7, 3, Direction.WEST);
        assertTrue(robot.equals(expectedRobot));
    }


    @Test
    @DisplayName("current position should give changed direction when multiple directions instructions have given")
    public void testCurrentPositionWhenMultipleDirectionsInstructionsHasGiven() {
        Robot robot = new Robot(7, 3, Direction.EAST);
        robot.process("LRR");

        Robot expectedRobot = new Robot(7, 3, Direction.SOUTH);
        assertTrue(robot.equals(expectedRobot));
    }


    @Test
    @DisplayName("current position should increase y coordinate when given direction is north with movement")
    public void testCurrentPositionWhenMovementInstructionHasGivenWithNorthDirection() {
        Robot robot = new Robot(7, 3, Direction.NORTH);
        robot.process("A");

        Robot expectedRobot = new Robot(7, 4, Direction.NORTH);
        assertTrue(robot.equals(expectedRobot));
    }

    @Test
    @DisplayName("current position should increase x coordinate when given direction is east with movement")
    public void testCurrentPositionWhenMovementInstructionHasGivenWithEastDirection() {

        Robot robot = new Robot(7, 3, Direction.EAST);
        robot.process("A");

        Robot expectedRobot = new Robot(8, 3, Direction.EAST);
        assertTrue(robot.equals(expectedRobot));
    }

    @Test
    @DisplayName("current position should decrease x coordinate when given direction is west with movement")
    public void testCurrentPositionWhenMovementInstructionHasGivenWithWestDirection() {

        Robot robot = new Robot(7, 3, Direction.WEST);
        robot.process("A");

        Robot expectedRobot = new Robot(6, 3, Direction.WEST);
        assertTrue(robot.equals(expectedRobot));
    }

    @Test
    @DisplayName("current position should decrease y coordinate when given direction is south with movement")
    public void testCurrentPositionWhenMovementInstructionHasGivenWithSouthDirection() {

        Robot robot = new Robot(7, 3, Direction.SOUTH);
        robot.process("A");

        Robot expectedRobot = new Robot(7, 2, Direction.SOUTH);
        assertTrue(robot.equals(expectedRobot));
    }

    @Test
    @DisplayName("current position should give changed position when multiple instructions have given")
    public void testCurrentPositionWhenMultipleInstructionsHasGiven() {

        Robot robot = new Robot(7, 3, Direction.NORTH);
        robot.process("RAALAL");

        Robot expectedRobot = new Robot(9, 4, Direction.WEST);
        assertTrue(robot.equals(expectedRobot));
    }

}