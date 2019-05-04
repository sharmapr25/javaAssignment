package gameoflife;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grid {
    private int rows;
    private int columns;
    private List<Cell> aliveCells;

    private List<Integer> combinationForRows = Arrays.asList(-1, -1, -1, 0, 0, 1, 1, 1);
    private List<Integer> combinationForColumns = Arrays.asList(-1, 0, 1, -1, 1, -1, 0, 1);

    public Grid(int rows, int columns) {
        this.rows = rows;
        this.columns = columns;
        this.aliveCells = new ArrayList<>();
    }

    public List<Cell> nextGeneration() {
        ArrayList<Cell> nextAliveCells = new ArrayList<>();
        for (int rowNumber = 0; rowNumber < this.rows; rowNumber++) {
            for (int columnNumber = 0; columnNumber < this.columns; columnNumber++) {
                Cell cell = new Cell(rowNumber, columnNumber);
                if(willBeAlive(cell)){
                    nextAliveCells.add(cell);
                }
            }
        }
        return nextAliveCells;
    }

    private boolean willBeAlive(Cell cell) {
        List<Cell> aliveNeighbours = findAliveNeighbours(cell);
        return ((aliveNeighbours.size() == 2 && isAlive(cell)) || aliveNeighbours.size() == 3);
    }

    private boolean isAlive(Cell cell) {
        return this.aliveCells.contains(cell);
    }

    private List<Cell> findAliveNeighbours(Cell cell) {
        List<Cell> neighbours = new ArrayList<>();
        for (int index = 0; index < combinationForRows.size(); index++) {
            Cell neighbour = cell.addRowAndColumn(combinationForRows.get(index), combinationForColumns.get(index));
            if (aliveCells.contains(neighbour)) {
                neighbours.add(neighbour);
            }
        }
        return neighbours;
    }

    public void setAliveCells(List<Cell> aliveCells) {
        this.aliveCells = aliveCells;
    }

}
