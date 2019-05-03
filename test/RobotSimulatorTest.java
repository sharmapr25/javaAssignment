import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotSimulatorTest {
    @Test
    @DisplayName("current position should be same when no instruction has given")
    public void testCurrentPositionWhenNoInstructionHasGiven() {
        Position position = new Position(new Point(7, 3), Direction.NORTH);
        Robot robot = new Robot(position);
        new RobotSimulator(robot).process("");

        assertTrue(robot.hasSamePosition(position));
    }

    @Test
    @DisplayName("current position should change direction north to east when given instruction is turning right")
    public void testCurrentPositionWhenGivenDirectionIsNorthWithInstructionsR() {
        Position position = new Position(new Point(7, 3), Direction.NORTH);
        Robot robot = new Robot(position);
        new RobotSimulator(robot).process("R");

        Position expectedPosition = new Position(new Point(7, 3), Direction.EAST);
        assertTrue(robot.hasSamePosition(expectedPosition));
    }

    @Test
    @DisplayName("current position should change direction west to north when given instruction is turning right")
    public void testCurrentPositionWhenGivenDirectionIsWestWithInstructionsR() {
        Position position = new Position(new Point(7, 3), Direction.WEST);
        Robot robot = new Robot(position);
        new RobotSimulator(robot).process("R");

        Position expectedPosition = new Position(new Point(7, 3), Direction.NORTH);
        assertTrue(robot.hasSamePosition(expectedPosition));
    }


    @Test
    @DisplayName("current position should changed direction east to north when given instruction is turning left")
    public void testCurrentPositionWhenGivenDirectionIsEastWithInstructionsL() {
        Position position = new Position(new Point(7, 3), Direction.EAST);
        Robot robot = new Robot(position);
        new RobotSimulator(robot).process("L");

        Position expectedPosition = new Position(new Point(7, 3), Direction.NORTH);
        assertTrue(robot.hasSamePosition(expectedPosition));
    }

    @Test
    @DisplayName("current position should changed direction north to west when given instruction is turning left")
    public void testCurrentPositionWhenGivenDirectionIsNorthWithInstructionsIsL() {
        Position position = new Position(new Point(7, 3), Direction.NORTH);
        Robot robot = new Robot(position);
        new RobotSimulator(robot).process("L");

        Position expectedPosition = new Position(new Point(7, 3), Direction.WEST);
        assertTrue(robot.hasSamePosition(expectedPosition));
    }


    @Test
    @DisplayName("current position should give changed direction when multiple directions instructions have given")
    public void testCurrentPositionWhenMultipleDirectionsInstructionsHasGiven() {
        Position position = new Position(new Point(7, 3), Direction.EAST);
        Robot robot = new Robot(position);
        new RobotSimulator(robot).process("LRR");

        Position expectedPosition = new Position(new Point(7, 3), Direction.SOUTH);
        assertTrue(robot.hasSamePosition(expectedPosition));
    }


    @Test
    @DisplayName("current position should increase y coordinate when given direction is north with movement")
    public void testCurrentPositionWhenMovementInstructionHasGivenWithNorthDirection() {
        Position position = new Position(new Point(7, 3), Direction.NORTH);
        Robot robot = new Robot(position);
        new RobotSimulator(robot).process("A");

        Position expectedPosition = new Position(new Point(7, 4), Direction.NORTH);
        assertTrue(robot.hasSamePosition(expectedPosition));
    }

    @Test
    @DisplayName("current position should increase x coordinate when given direction is east with movement")
    public void testCurrentPositionWhenMovementInstructionHasGivenWithEastDirection() {
        Position position = new Position(new Point(7, 3), Direction.EAST);
        Robot robot = new Robot(position);
        new RobotSimulator(robot).process("A");

        Position expectedPosition = new Position(new Point(8, 3), Direction.EAST);
        assertTrue(robot.hasSamePosition(expectedPosition));

    }

    @Test
    @DisplayName("current position should decrease x coordinate when given direction is west with movement")
    public void testCurrentPositionWhenMovementInstructionHasGivenWithWestDirection() {
        Position position = new Position(new Point(7, 3), Direction.WEST);
        Robot robot = new Robot(position);
        new RobotSimulator(robot).process("A");

        Position expectedPosition = new Position(new Point(6, 3), Direction.WEST);
        assertTrue(robot.hasSamePosition(expectedPosition));
    }

    @Test
    @DisplayName("current position should decrease y coordinate when given direction is south with movement")
    public void testCurrentPositionWhenMovementInstructionHasGivenWithSouthDirection() {
        Position position = new Position(new Point(7, 3), Direction.SOUTH);
        Robot robot = new Robot(position);
        new RobotSimulator(robot).process("A");

        Position expectedPosition = new Position(new Point(7, 2), Direction.SOUTH);
        assertTrue(robot.hasSamePosition(expectedPosition));
    }

    @Test
    @DisplayName("current position should give changed position when multiple instructions have given")
    public void testCurrentPositionWhenMultipleInstructionsHasGiven() {
        Position position = new Position(new Point(7, 3), Direction.NORTH);
        Robot robot = new Robot(position);
        new RobotSimulator(robot).process("RAALAL");

        Position expectedPosition = new Position(new Point(9, 4), Direction.WEST);
        assertTrue(robot.hasSamePosition(expectedPosition));
    }
}