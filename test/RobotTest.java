import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    @Test
    @DisplayName("current position should be same when no instruction has given")
    public void testCurrentPositionWhenNoInstructionHasGiven() {
        Robot robot = new Robot(7, 3, 'N');
        robot.process("");

        Robot expectedRobot = new Robot(7, 3, 'N');
        assertTrue(robot.equals(expectedRobot));
    }

    @Test
    @DisplayName("current position should change direction north to east when given instruction is turning right")
    public void testCurrentPositionWhenGivenDirectionIsNorthWithInstructionsR() {
        Robot robot = new Robot(7, 3, 'N');
        robot.process("R");

        Robot expectedRobot = new Robot(7, 3, 'E');
        assertTrue(robot.equals(expectedRobot));


    }

    @Test
    @DisplayName("current position should change direction west to north when given instruction is turning right")
    public void testCurrentPositionWhenGivenDirectionIsWestWithInstructionsR() {
        Robot robot = new Robot(7, 3, 'W');
        robot.process("R");

        Robot expectedRobot = new Robot(7, 3, 'N');
        assertTrue(robot.equals(expectedRobot));
    }


    @Test
    @DisplayName("current position should changed direction east to north when given instruction is turning left")
    public void testCurrentPositionWhenGivenDirectionIsEastWithInstructionsL() {
        Robot robot = new Robot(7, 3, 'E');
        robot.process("L");

        Robot expectedRobot = new Robot(7, 3, 'N');
        assertTrue(robot.equals(expectedRobot));
    }

    @Test
    @DisplayName("current position should changed direction north to west when given instruction is turning left")
    public void testCurrentPositionWhenGivenDirectionIsNorthWithInstructionsIsL() {
        Robot robot = new Robot(7, 3, 'N');
        robot.process("L");
        Robot expectedRobot = new Robot(7, 3, 'W');
        assertTrue(robot.equals(expectedRobot));
    }


    @Test
    @DisplayName("current position should give changed direction when multiple directions instructions have given")
    public void testCurrentPositionWhenMultipleDirectionsInstructionsHasGiven() {
        Robot robot = new Robot(7, 3, 'E');
        robot.process("LRR");

        Robot expectedRobot = new Robot(7, 3, 'S');
        assertTrue(robot.equals(expectedRobot));
    }


    @Test
    @DisplayName("current position should increase y coordinate when given direction is north with movement")
    public void testCurrentPositionWhenMovementInstructionHasGivenWithNorthDirection() {
        Robot robot = new Robot(7, 3, 'N');
        robot.process("A");

        Robot expectedRobot = new Robot(7, 4, 'N');
        assertTrue(robot.equals(expectedRobot));
    }

    @Test
    @DisplayName("current position should increase x coordinate when given direction is east with movement")
    public void testCurrentPositionWhenMovementInstructionHasGivenWithEastDirection() {

        Robot robot = new Robot(7, 3, 'E');
        robot.process("A");

        Robot expectedRobot2 = new Robot(8, 3, 'E');
        assertTrue(robot.equals(expectedRobot2));
    }

    @Test
    @DisplayName("current position should decrease x coordinate when given direction is west with movement")
    public void testCurrentPositionWhenMovementInstructionHasGivenWithWestDirection() {

        Robot robot = new Robot(7, 3, 'W');
        robot.process("A");

        Robot expectedRobot2 = new Robot(6, 3, 'W');
        assertTrue(robot.equals(expectedRobot2));
    }

    @Test
    @DisplayName("current position should decrease y coordinate when given direction is south with movement")
    public void testCurrentPositionWhenMovementInstructionHasGivenWithSouthDirection() {

        Robot robot = new Robot(7, 3, 'S');
        robot.process("A");

        Robot expectedRobot2 = new Robot(7, 2, 'S');
        assertTrue(robot.equals(expectedRobot2));
    }

    @Test
    @DisplayName("current position should give changed position when multiple instructions have given")
    public void testCurrentPositionWhenMultipleInstructionsHasGiven() {

        Robot robot = new Robot(7, 3, 'N');
        robot.process("RAALAL");

        Robot expectedRobot = new Robot(9, 4, 'W');
        assertTrue(robot.equals(expectedRobot));
    }

}