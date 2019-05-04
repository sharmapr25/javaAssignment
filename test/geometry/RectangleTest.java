package geometry;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    @DisplayName("getArea should return 20 when given rectangle length is 5 and width is 4")
    public void testGetAreaWhenGivenLengthIsFiveAndWidthIsFour(){
        Rectangle rectangle = new Rectangle(5, 4);
        int area = rectangle.getArea();
        assertEquals(20, area);
    }

    @Test
    @DisplayName("getArea should return 30 when given rectangle length is 6 and width is 5")
    public void testGetAreaWhenGivenLengthIsSixAndWidthIsFive(){
        Rectangle rectangle = new Rectangle(6, 5);
        int area = rectangle.getArea();
        assertEquals(30, area);
    }

}