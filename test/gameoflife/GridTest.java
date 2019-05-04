package gameoflife;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class GridTest {

    @Test
    @DisplayName("next generation should return empty grid when no alive cell in grid")
    public void testNextGenerationWhenThereIsNoAliveCell(){
        Grid grid = new Grid(1,1);
        List<Cell> aliveCells = grid.nextGeneration();
        assertTrue(aliveCells.isEmpty());
    }


    @Test
    @DisplayName("next generation should return empty grid when there are two alive cells in grid")
    public void testNextGenerationWhenThereAreTwoAliveCells(){
        Grid grid = new Grid(2,2);
        ArrayList<Cell> cells = new ArrayList<Cell>() {{
            add(new Cell(0, 0));
            add(new Cell(0, 1));
        }};

        grid.setAliveCells(cells);

        List<Cell> aliveCells = grid.nextGeneration();
        assertTrue(aliveCells.isEmpty());
    }

    @Test
    @DisplayName("next generation should return a grid with one alive cell when there are three alive cells in grid")
    public void testNextGenerationWhenThereAreThreeAliveCells(){
        Grid grid = new Grid(3,3);
        ArrayList<Cell> cells = new ArrayList<Cell>() {{
            add(new Cell(0, 0));
            add(new Cell(1, 1));
            add(new Cell(2, 2));
        }};

        grid.setAliveCells(cells);

        List<Cell> aliveCells = grid.nextGeneration();

        ArrayList<Cell> expectedAliveCells = new ArrayList<Cell>() {{
            add(new Cell(1, 1));
        }};

        assertTrue(aliveCells.equals(expectedAliveCells));
    }

    @Test
    @DisplayName("next generation should return a grid with four alive cell when there are three alive cells in grid")
    public void testNextGenerationWhenThereAreThreeAliveCellsIn2By2Grid(){
        Grid grid = new Grid(2,2);
        ArrayList<Cell> cells = new ArrayList<Cell>() {{
            add(new Cell(0, 0));
            add(new Cell(0, 1));
            add(new Cell(1, 0));
        }};

        grid.setAliveCells(cells);

        List<Cell> aliveCells = grid.nextGeneration();

        ArrayList<Cell> expectedAliveCells = new ArrayList<Cell>() {{
            add(new Cell(0, 0));
            add(new Cell(0, 1));
            add(new Cell(1, 0));
            add(new Cell(1, 1));
        }};

        assertTrue(aliveCells.equals(expectedAliveCells));
    }

    @Test
    @DisplayName("next generation should return a grid when grid is in block pattern")
    public void testNextGenerationForBlockPattern(){
        Grid grid = new Grid(3,3);
        ArrayList<Cell> cells = new ArrayList<Cell>() {{
            add(new Cell(1, 1));
            add(new Cell(1, 2));
            add(new Cell(2, 1));
            add(new Cell(2, 2));
        }};

        grid.setAliveCells(cells);

        List<Cell> aliveCells = grid.nextGeneration();

        assertTrue(aliveCells.equals(cells));
    }


    @Test
    @DisplayName("next generation should return a grid when grid is in blinker pattern")
    public void testNextGenerationForBlinkerPattern(){
        Grid grid = new Grid(3,3);
        ArrayList<Cell> cells = new ArrayList<Cell>() {{
            add(new Cell(1, 1));
            add(new Cell(1, 0));
            add(new Cell(1, 2));
        }};

        grid.setAliveCells(cells);

        List<Cell> aliveCells = grid.nextGeneration();

        ArrayList<Cell> expectedCells = new ArrayList<Cell>() {{
            add(new Cell(0, 1));
            add(new Cell(1, 1));
            add(new Cell(2, 1));
        }};

        assertTrue(aliveCells.equals(expectedCells));
    }

    @Test
    @DisplayName("next generation should return a grid when grid is in two phase oscillator pattern")
    public void testNextGenerationForTwoPhaseOscillatorPattern(){
        Grid grid = new Grid(5,5);
        ArrayList<Cell> cells = new ArrayList<Cell>() {{
            add(new Cell(1, 1));
            add(new Cell(1, 2));
            add(new Cell(1, 3));
            add(new Cell(2, 2));
            add(new Cell(2, 3));
            add(new Cell(2, 4));
        }};

        grid.setAliveCells(cells);

        List<Cell> aliveCells = grid.nextGeneration();

        ArrayList<Cell> expectedCells = new ArrayList<Cell>() {{
            add(new Cell(0, 2));
            add(new Cell(1, 1));
            add(new Cell(1, 4));
            add(new Cell(2, 1));
            add(new Cell(2, 4));
            add(new Cell(3, 3));
        }};

        assertTrue(aliveCells.equals(expectedCells));
    }




}