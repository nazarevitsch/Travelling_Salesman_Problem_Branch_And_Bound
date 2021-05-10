package binary_tree;

import com.sun.rowset.internal.Row;

public class Path {

    private int row;
    private int column;

    public Path() {}

    public Path(int column, int row) {
        this.column = column;
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public String toString() {
        return "Path{" +
                "row=" + row +
                ", column=" + column +
                '}';
    }
}
