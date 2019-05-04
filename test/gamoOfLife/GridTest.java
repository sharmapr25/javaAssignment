package gamoOfLife;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

}