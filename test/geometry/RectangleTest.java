package geometry;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static geometry.Rectangle.*;
import static org.junit.jupiter.api.Assertions.*;

class RectangleTest {

    @Test
    @DisplayName("getArea should return 20 when given rectangle length is 5 and width is 4")
    public void testGetAreaWhenGivenLengthIsFiveAndWidthIsFour() {
        Rectangle rectangle = createRectangle(5, 4);
        int area = rectangle.getArea();
        assertEquals(20, area);
    }

    @Test
    @DisplayName("getArea should return 30 when given rectangle length is 6 and width is 5")
    public void testGetAreaWhenGivenLengthIsSixAndWidthIsFive() {
        Rectangle rectangle = createRectangle(6, 5);
        int area = rectangle.getArea();
        assertEquals(30, area);
    }

    @Test
    @DisplayName("getPerimeter should return 14 when given rectangle length is 4 and width is 3")
    public void testGetPerimeterWhenGivenLengthIsFourAndWidthIsThree() {
        Rectangle rectangle = createRectangle(4, 3);
        int perimeter = rectangle.getPerimeter();
        assertEquals(14, perimeter);
    }

    @Test
    @DisplayName("getPerimeter should return 10 when given rectangle length is 2 and width is 3")
    public void testGetPerimeterWhenGivenLengthIsTwoAndWidthIsThree() {
        Rectangle rectangle = createRectangle(2, 3);
        int perimeter = rectangle.getPerimeter();
        assertEquals(10, perimeter);
    }

    @Test
    @DisplayName("getArea should return 25 when given rectangle is a square with side 5")
    public void testGetAreaWhenGivenRectangleIsSquareWithSideFive() {
        Rectangle square = createSquare(5);
        int area = square.getArea();
        assertEquals(25, area);
    }

    @Test
    @DisplayName("getPerimeter should return 20 when given rectangle is a square with side 5")
    public void testGetPerimeterWhenGivenRectangleIsSquareWithSideFive() {
        Rectangle square = createSquare(5);
        int perimeter = square.getPerimeter();
        assertEquals(20, perimeter);
    }


}