import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PointTest {

    @Test
    @DisplayName("incrementX should increase x coordinate value by 1")
    public void testXIncrement(){
        Point point = new Point(1, 2);
        point.incrementX();

        Point expectedPoint = new Point(2, 2);
        assertTrue(point.equals(expectedPoint));
    }

    @Test
    @DisplayName("incrementY should increase y coordinate value by 1")
    public void testYIncrement(){
        Point point = new Point(1, 2);
        point.incrementY();

        Point expectedPoint = new Point(1, 3);
        assertTrue(point.equals(expectedPoint));
    }

    @Test
    @DisplayName("decrementX should decrease x coordinate value by 1")
    public void testXDecrement(){
        Point point = new Point(1, 2);
        point.decrementX();

        Point expectedPoint = new Point(0, 2);
        assertTrue(point.equals(expectedPoint));
    }

    @Test
    @DisplayName("decrementY should decrease y coordinate value by 1")
    public void testYDecrement(){
        Point point = new Point(1, 2);
        point.decrementY();

        Point expectedPoint = new Point(1, 1);
        assertTrue(point.equals(expectedPoint));
    }

}