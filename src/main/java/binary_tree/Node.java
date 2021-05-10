package binary_tree;

import java.util.Arrays;

public class Node {

    private Node left;
    private Node right;
    private MatrixPoint[][] matrix;
    private int[] minNumbersInRows;
    private int[] minNumbersInColumns;
    private Path path;
    private boolean isIncluded;
    private int[] meteDataRow;
    private int[] meteDataColumn;

    private int sum;

    public Node(MatrixPoint[][] matrix) {
        this.matrix = matrix;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public int[] getMeteDataRow() {
        return meteDataRow;
    }

    public void setMeteDataRow(int[] meteDataRow) {
        this.meteDataRow = meteDataRow;
    }

    public int[] getMeteDataColumn() {
        return meteDataColumn;
    }

    public void setMeteDataColumn(int[] meteDataColumn) {
        this.meteDataColumn = meteDataColumn;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public MatrixPoint[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(MatrixPoint[][] matrix) {
        this.matrix = matrix;
    }

    public int[] getMinNumbersInRows() {
        return minNumbersInRows;
    }

    public void setMinNumbersInRows(int[] minNumbersInRows) {
        this.minNumbersInRows = minNumbersInRows;
    }

    public int[] getMinNumbersInColumns() {
        return minNumbersInColumns;
    }

    public void setMinNumbersInColumns(int[] minNumbersInColumns) {
        this.minNumbersInColumns = minNumbersInColumns;
    }

    public Path getPath() {
        return path;
    }

    public void setPath(Path path) {
        this.path = path;
    }

    public boolean isIncluded() {
        return isIncluded;
    }

    public void setIncluded(boolean included) {
        isIncluded = included;
    }

    public int sum() {
        int sum = 0;
        for (int i = 0; i < minNumbersInColumns.length; i++) {
            sum += minNumbersInColumns[i];
            sum += minNumbersInRows[i];
        }
        return sum;
    }

    public void deleteColumnAndRow(int row, int column) {
        dropNumber(column, row);
        int rowIndex = 0;
        int columnIndex = 0;
        for (int i = 0; i < meteDataRow.length; i++) {
            if (meteDataColumn[i] == row) {
                rowIndex = i;
            }
            if (meteDataRow[i] == column) {
                columnIndex = i;
            }
        }
        this.minNumbersInRows = new int[this.matrix.length - 1];
        this.minNumbersInColumns = new  int[this.matrix.length - 1];
        MatrixPoint[][] matrix = new MatrixPoint[this.minNumbersInColumns.length][];
        for (int i = 0; i < this.minNumbersInColumns.length; i++) {
            matrix[i] = new  MatrixPoint[this.minNumbersInColumns.length];
            for (int l = 0; l < this.minNumbersInColumns.length; l++) {
                if (i >= rowIndex) {
                    if (l >= columnIndex){
                        matrix[i][l] = this.matrix[i + 1][l + 1];
                    } else {
                        matrix[i][l] = this.matrix[i + 1][l];
                    }
                } else {
                    if (l >= columnIndex){
                        matrix[i][l] = this.matrix[i][l + 1];
                    } else {
                        matrix[i][l] = this.matrix[i][l];
                    }
                }
            }
        }
        this.matrix = matrix;
        int[] newMetaDataRow = new int[meteDataRow.length - 1];
        for (int i = 0; i < newMetaDataRow.length; i++) {
            if (i >= columnIndex) {
                newMetaDataRow[i] = meteDataRow[i + 1];
            } else {
                newMetaDataRow[i] = meteDataRow[i];
            }
        }
        int[] newMetaDataColumn = new int[meteDataColumn.length - 1];
        for (int i = 0; i < newMetaDataColumn.length; i++) {
            if (i >= rowIndex) {
                newMetaDataColumn[i] = meteDataColumn[i + 1];
            } else {
                newMetaDataColumn[i] = meteDataColumn[i];
            }
        }
        this.meteDataRow = newMetaDataRow;
        this.meteDataColumn = newMetaDataColumn;
    }

    public void dropNumber(int row, int column) {
        int rowIndex = 0;
        int columnIndex = 0;
        for (int i = 0; i < meteDataRow.length; i++) {
            if (meteDataRow[i] == column) {
                rowIndex = i;
            }
            if (meteDataColumn[i] == row) {
                columnIndex = i;
            }
        }
        matrix[columnIndex][rowIndex] = new NoNumber();
    }

    public static void print(Node node) {
        System.out.print("\t ");
        for (int i = 0; i < node.getMatrix().length; i++) {
            System.out.print(node.getMeteDataRow()[i] + "\t");
        }
        System.out.print("\n-");
        for (int i = 0; i <= node.getMatrix().length; i++) {
            System.out.print("----");
        }
        System.out.println();
        for (int i = 0; i < node.getMatrix().length; i++) {
            System.out.print(node.getMeteDataColumn()[i] + "\t");
            System.out.print("|");
            for (int l = 0; l < node.getMatrix()[i].length; l++) {
                System.out.print(node.getMatrix()[i][l].get() + "\t");
            }
            System.out.println();
        }
    }

    public static Node copy(Node node) {
        MatrixPoint[][] newMatrix = new MatrixPoint[node.getMatrix().length][];
        for (int i = 0; i < node.getMatrix().length; i++) {
            newMatrix[i] = new MatrixPoint[node.getMatrix()[i].length];
            for (int l = 0; l < node.getMatrix()[i].length; l++) {
                newMatrix[i][l] = node.getMatrix()[i][l].copy();
            }
        }
        Node newNode = new Node(newMatrix);
        newNode.setMinNumbersInColumns(new int[node.getMatrix().length]);
        newNode.setMinNumbersInRows(new int[node.getMatrix().length]);
        newNode.setMeteDataRow(Arrays.copyOf(node.getMeteDataRow(), node.getMeteDataRow().length));
        newNode.setMeteDataColumn(Arrays.copyOf(node.getMeteDataColumn(), node.getMeteDataColumn().length));
        return newNode;
    }

    public String toString() {
        return "ID: " + 0 + ", P: " + path.getRow() + " ," + path.getColumn() + " ,";
    }
}
