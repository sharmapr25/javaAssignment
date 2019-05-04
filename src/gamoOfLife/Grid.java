package gamoOfLife;

import java.util.ArrayList;
import java.util.List;

public class Grid {
    private final int row;
    private final int column;
    private List<Cell> aliveCells;

    public Grid(int row, int column) {
        this.row = row;
        this.column = column;
        this.aliveCells = new ArrayList<>();
    }

    public List<Cell> nextGeneration() {
        return aliveCells;
    }
}
