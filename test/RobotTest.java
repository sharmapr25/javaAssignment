import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotTest {

    @Test
    @DisplayName("current position should be same when no instruction has given")
    public void getCurrentPositionWhenNoInstructionHasGiven(){
        Robot robot = new Robot(7, 3, 'N');
        robot.process("");

        assertEquals("7 3 N", robot.currentPosition());
    }

    @Test
    @DisplayName("current position should give changed direction when given instruction is about turning right")
    public void getCurrentPositionWhenGivenDirectionInstructionsIsR(){
        Robot robot = new Robot(7, 3, 'N');
        robot.process("R");
        assertEquals("7 3 E", robot.currentPosition());

        Robot robot2 = new Robot(7, 3, 'W');
        robot2.process("R");
        assertEquals("7 3 N", robot2.currentPosition());
    }


    @Test
    @DisplayName("current position should give changed direction when given instruction is about turning left")
    public void getCurrentPositionWhenGivenDirectionInstructionsIsL(){
        Robot robot = new Robot(7, 3, 'E');
        robot.process("L");
        assertEquals("7 3 N", robot.currentPosition());

        Robot robot2 = new Robot(7, 3, 'N');
        robot2.process("L");
        assertEquals("7 3 W", robot2.currentPosition());
    }


    @Test
    @DisplayName("current position should give changed direction when multiple directions instructions have given")
    public void getCurrentPositionWhenMultipleDirectionsInstructionsHasGiven(){
        Robot robot = new Robot(7, 3, 'E');
        robot.process("LRR");
        assertEquals("7 3 S", robot.currentPosition());
    }


    @Test
    @DisplayName("current position should give changed position when advance instruction is given")
    public void getCurrentPositionWhenMovementInstructionHasGiven(){
        Robot robot1 = new Robot(7, 3, 'N');
        robot1.process("A");
        assertEquals("7 4 N",robot1.currentPosition());

        Robot robot2 = new Robot(7, 3, 'E');
        robot2.process("A");
        assertEquals("8 3 E",robot2.currentPosition());


        Robot robot3 = new Robot(7, 3, 'W');
        robot3.process("A");
        assertEquals("6 3 W",robot3.currentPosition());


        Robot robot4 = new Robot(7, 3, 'S');
        robot4.process("A");
        assertEquals("7 2 S",robot4.currentPosition());
    }

    @Test
    @DisplayName("current position should give changed position when multiple instructions have given")
    public void getCurrentPositionWhenMultipleInstructionsHasGiven(){

        Robot robot = new Robot(7,3,'N');
        robot.process("RAALAL");
        assertEquals("9 4 W",robot.currentPosition());
    }

}