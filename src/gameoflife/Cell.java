package gameoflife;

public class Cell {
    private final int rowNumber;
    private final int columnNumber;

    public Cell(int rowNumber, int columnNumber) {
        this.rowNumber = rowNumber;
        this.columnNumber = columnNumber;
    }

    public Cell addRowAndColumn(Integer rowValueToAdd, Integer columnValueToAdd) {
        return new Cell(rowNumber + rowValueToAdd, columnNumber+columnValueToAdd);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cell cell = (Cell) o;

        if (rowNumber != cell.rowNumber) return false;
        return columnNumber == cell.columnNumber;
    }

    @Override
    public int hashCode() {
        int result = rowNumber;
        result = 31 * result + columnNumber;
        return result;
    }
}
