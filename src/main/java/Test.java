import binary_tree.MatrixPoint;
import binary_tree.NoNumber;
import binary_tree.Node;
import binary_tree.Number;

public class Test {

    public static Node test1() {
        MatrixPoint[][] matrix = new MatrixPoint[5][5];

        matrix[0] = new MatrixPoint[5];
        matrix[1] = new MatrixPoint[5];
        matrix[2] = new MatrixPoint[5];
        matrix[3] = new MatrixPoint[5];
        matrix[4] = new MatrixPoint[5];

        matrix[0][0] = new NoNumber();
        matrix[1][1] = new NoNumber();
        matrix[2][2] = new NoNumber();
        matrix[3][3] = new NoNumber();
        matrix[4][4] = new NoNumber();

        matrix[0][1] = new Number(7);
        matrix[0][2] = new Number(3);
        matrix[0][3] = new Number(18);
        matrix[0][4] = new Number(13);

        matrix[1][0] = new Number(14);
        matrix[1][2] = new Number(12);
        matrix[1][3] = new Number(20);
        matrix[1][4] = new Number(5);

        matrix[2][0] = new Number(6);
        matrix[2][1] = new Number(17);
        matrix[2][3] = new Number(1);
        matrix[2][4] = new Number(19);

        matrix[3][0] = new Number(2);
        matrix[3][1] = new Number(10);
        matrix[3][2] = new Number(16);
        matrix[3][4] = new Number(9);

        matrix[4][0] = new Number(11);
        matrix[4][1] = new Number(4);
        matrix[4][2] = new Number(8);
        matrix[4][3] = new Number(15);

        Node node = new Node(matrix);
        int[] metaDatRow = {1, 2, 3, 4, 5};
        int[] metaDataColumn = {1, 2, 3, 4, 5};
        node.setMeteDataColumn(metaDataColumn);
        node.setMeteDataRow(metaDatRow);

        return node;
    }

    public static Node test2() {
        MatrixPoint[][] matrix = new MatrixPoint[5][5];

        matrix[0] = new MatrixPoint[5];
        matrix[1] = new MatrixPoint[5];
        matrix[2] = new MatrixPoint[5];
        matrix[3] = new MatrixPoint[5];
        matrix[4] = new MatrixPoint[5];

        matrix[0][0] = new NoNumber();
        matrix[1][1] = new NoNumber();
        matrix[2][2] = new NoNumber();
        matrix[3][3] = new NoNumber();
        matrix[4][4] = new NoNumber();

        matrix[0][1] = new Number(1);
        matrix[0][2] = new Number(7);
        matrix[0][3] = new Number(3);
        matrix[0][4] = new Number(5);

        matrix[1][0] = new Number(10);
        matrix[1][2] = new Number(4);
        matrix[1][3] = new Number(12);
        matrix[1][4] = new Number(15);

        matrix[2][0] = new Number(6);
        matrix[2][1] = new Number(16);
        matrix[2][3] = new Number(20);
        matrix[2][4] = new Number(8);

        matrix[3][0] = new Number(11);
        matrix[3][1] = new Number(18);
        matrix[3][2] = new Number(13);
        matrix[3][4] = new Number(17);

        matrix[4][0] = new Number(4);
        matrix[4][1] = new Number(9);
        matrix[4][2] = new Number(19);
        matrix[4][3] = new Number(2);

        Node node = new Node(matrix);
        int[] metaDatRow = {1, 2, 3, 4, 5};
        int[] metaDataColumn = {1, 2, 3, 4, 5};
        node.setMeteDataColumn(metaDataColumn);
        node.setMeteDataRow(metaDatRow);

        return node;
    }
}
