import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {
    @Test
    @DisplayName("turn right should change direction north to east")
    public void testTurnRightWhenGivenDirectionIsNorth() {
        Position position = new Position(new Point(7, 3), Direction.NORTH);
        Robot robot = new Robot(position);
        robot.turnRight();

        Position expectedPosition = new Position(new Point(7, 3), Direction.EAST);
        assertTrue(robot.hasSamePosition(expectedPosition));

    }

    @Test
    @DisplayName("turn right should change direction west to north")
    public void testTurnRightWhenGivenDirectionIsWest() {
        Position position = new Position(new Point(7, 3), Direction.WEST);
        Robot robot = new Robot(position);
        robot.turnRight();

        Position expectedPosition = new Position(new Point(7, 3), Direction.NORTH);
        assertTrue(robot.hasSamePosition(expectedPosition));
    }


    @Test
    @DisplayName("turn left should change direction east to north")
    public void testTurnLeftWhenGivenDirectionIsEast() {
        Position position = new Position(new Point(7, 3), Direction.EAST);
        Robot robot = new Robot(position);
        robot.turnLeft();

        Position expectedPosition = new Position(new Point(7, 3), Direction.NORTH);
        assertTrue(robot.hasSamePosition(expectedPosition));
    }

    @Test
    @DisplayName("turn left should change direction north to west")
    public void testTurnLeftWhenGivenDirectionIsNorth() {
        Position position = new Position(new Point(7, 3), Direction.NORTH);
        Robot robot = new Robot(position);
        robot.turnLeft();

        Position expectedPosition = new Position(new Point(7, 3), Direction.WEST);
        assertTrue(robot.hasSamePosition(expectedPosition));
    }

    @Test
    @DisplayName("move should increase y coordinate when given direction is north")
    public void testMoveWhenGivenDirectionIsNorth() {
        Position position = new Position(new Point(7, 3), Direction.NORTH);
        Robot robot = new Robot(position);
        robot.move();

        Position expectedPosition = new Position(new Point(7, 4), Direction.NORTH);
        assertTrue(robot.hasSamePosition(expectedPosition));
    }

    @Test
    @DisplayName("move should increase x coordinate when given direction is east")
    public void testMoveWhenGivenDirectionIsEast() {
        Position position = new Position(new Point(7, 3), Direction.EAST);
        Robot robot = new Robot(position);
        robot.move();

        Position expectedPosition = new Position(new Point(8, 3), Direction.EAST);
        assertTrue(robot.hasSamePosition(expectedPosition));
    }

    @Test
    @DisplayName("move should decrease x coordinate when given direction is west")
    public void testMoveWhenGivenDirectionIsWest() {
        Position position = new Position(new Point(7, 3), Direction.WEST);
        Robot robot = new Robot(position);
        robot.move();

        Position expectedPosition = new Position(new Point(6, 3), Direction.WEST);
        assertTrue(robot.hasSamePosition(expectedPosition));
    }

    @Test
    @DisplayName("move should decrease y coordinate when given direction is south")
    public void testCurrentPositionWhenMovementInstructionHasGivenWithSouthDirection() {
        Position position = new Position(new Point(7, 3), Direction.SOUTH);
        Robot robot = new Robot(position);
        robot.move();

        Position expectedPosition = new Position(new Point(7, 2), Direction.SOUTH);
        assertTrue(robot.hasSamePosition(expectedPosition));
    }
}