package gameoflife;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CellTest {

    @Test
    @DisplayName("addRowAndColumn should add -1 and 0 as row and column")
    public void testAddRowAndColumnWithRowAsNegativeOneAndColumnAsZero(){
        Cell cell = new Cell(1, 1);
        Cell updatedCell = cell.addRowAndColumn(-1, 0);

        Cell expectedCell = new Cell(0, 1);
        assertEquals(updatedCell, expectedCell);
    }

    @Test
    @DisplayName("addRowAndColumn should add 1 and 0 as row and column")
    public void testAddRowAndColumnWithRowAsOneAndColumnAsZero(){
        Cell cell = new Cell(1, 1);
        Cell updatedCell = cell.addRowAndColumn(1, 0);

        Cell expectedCell = new Cell(2, 1);
        assertEquals(updatedCell, expectedCell);
    }

    @Test
    @DisplayName("addRowAndColumn should add 1 and -1 as row and column")
    public void testAddRowAndColumnWithRowAsOneAndColumnAsNegativeOne(){
        Cell cell = new Cell(1, 1);
        Cell updatedCell = cell.addRowAndColumn(1, -1);

        Cell expectedCell = new Cell(2, 0);
        assertEquals(updatedCell, expectedCell);
    }

}