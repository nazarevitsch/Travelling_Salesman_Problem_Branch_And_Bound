import binary_tree.*;
import binary_tree.Number;

import java.util.HashMap;

public class TravellingSalesmanProblem {

    private BinaryTree tree;

    public BinaryTree calculate(BinaryTree binaryTree) {
        HashMap<Integer, Node> map = new HashMap<Integer, Node>();

        this.tree = binaryTree;
        Node currentNode = tree.getRoot();
        boolean flag = true;
        int id = 0;
        currentNode.setId(id);

        while (!check(currentNode)) {
            reduction(currentNode, flag);
            Path path = afterReduction(currentNode);
            map.put(id, currentNode);

            Node leftChildren = Node.copy(currentNode);
            Node rightChildren = Node.copy(currentNode);
            leftChildren.setId(++id);
            map.put(id, leftChildren);
            rightChildren.setId(++id);
            map.put(id, rightChildren);
            leftChildren.setIncluded(true);
            rightChildren.setIncluded(false);
            leftChildren.setPath(path);
            rightChildren.setPath(path);

            rightChildren.deleteColumnAndRow(path.getRow(), path.getColumn());
            leftChildren.dropNumber(path.getRow(), path.getColumn());

            currentNode.setRight(rightChildren);
            currentNode.setLeft(leftChildren);

            currentNode = afterAfterReduction(currentNode, rightChildren, leftChildren);
            tree.addPath(currentNode.getPath());
            tree.setDeep(tree.getDeep() + 1);
            flag = false;
        }
        findRemainedPaths(currentNode);
        tree.setMap(map);
        return this.tree;
    }

    private void reduction(Node currentNode, boolean firstTime) {
        MatrixPoint[][] currentMatrix = currentNode.getMatrix();
        int[] minNumbersInRow = new int[currentMatrix.length];
        int[] minNumbersInColumn = new int[currentMatrix.length];
        int number = Integer.MAX_VALUE;
        for (int i = 0; i < currentMatrix.length; i++) {
            for (int l = 0; l < currentMatrix[i].length; l++) {
                try {
                    if ((Integer) currentMatrix[i][l].get() < number) {
                        number = (Integer) currentMatrix[i][l].get();
                    }
                } catch (Exception e) {
                }
            }
            if (number > 0) {
                for (int l = 0; l < currentMatrix[i].length; l++) {
                    try {
                        ((Number) currentMatrix[i][l]).setNumber((Integer) currentMatrix[i][l].get() - number);
                    } catch (Exception e) {
                    }
                }
            }
            minNumbersInRow[i] = number;
            number = Integer.MAX_VALUE;
        }

        number = Integer.MAX_VALUE;
        for (int i = 0; i < currentMatrix.length; i++) {
            for (int l = 0; l < currentMatrix[i].length; l++) {
                try {
                    if ((Integer) currentMatrix[l][i].get() < number) {
                        number = (Integer) currentMatrix[l][i].get();
                    }
                } catch (Exception e) {
                }
            }
            if (number > 0) {
                for (int l = 0; l < currentMatrix[i].length; l++) {
                    try {
                        ((Number) currentMatrix[l][i]).setNumber((Integer) currentMatrix[l][i].get() - number);
                    } catch (Exception e) {
                    }
                }
            }
            minNumbersInColumn[i] = number;
            number = Integer.MAX_VALUE;
        }
        currentNode.setMinNumbersInRows(minNumbersInRow);
        currentNode.setMinNumbersInColumns(minNumbersInColumn);
        if (firstTime) {
            currentNode.setSum(currentNode.getSum() + currentNode.sum());
        }
    }

    private Path afterReduction(Node node) {
        Path path = new Path();
        int number = Integer.MAX_VALUE;
        int[] minInRows = new int[node.getMatrix().length];
        int[] minInColumns = new int[node.getMatrix().length];
        for (int i = 0; i < node.getMatrix().length; i++) {

            int zerosCount = 0;
            for (int l = 0; l < node.getMatrix()[i].length; l++) {
                try {
                    if ((Integer) node.getMatrix()[i][l].get() == 0) {
                        zerosCount++;
                    }
                } catch (Exception e) {}
            }
            if (zerosCount >= 2) {
                number = 0;
            } else {

                for (int l = 0; l < node.getMatrix()[i].length; l++) {
                    try {
                        if ((Integer) node.getMatrix()[i][l].get() < number && (Integer) node.getMatrix()[i][l].get() != 0) {
                            number = (Integer) node.getMatrix()[i][l].get();
                        }
                    } catch (Exception e) {
                    }
                }
            }
            minInRows[i] = number;
            number = Integer.MAX_VALUE;

            zerosCount = 0;
            for (int l = 0; l < node.getMatrix()[i].length; l++) {
                try {
                    if ((Integer) node.getMatrix()[l][i].get() == 0) {
                        zerosCount++;
                    }
                } catch (Exception e) {}
            }
            if (zerosCount >= 2) {
                number = 0;
            } else {

                for (int l = 0; l < node.getMatrix()[i].length; l++) {
                    try {
                        if ((Integer) node.getMatrix()[l][i].get() < number && (Integer) node.getMatrix()[l][i].get() != 0) {
                            number = (Integer) node.getMatrix()[l][i].get();
                        }
                    } catch (Exception e) {
                    }
                }
            }
            minInColumns[i] = number;
            number = Integer.MAX_VALUE;
        }
        number = 0;
        for (int i = 0; i < node.getMatrix().length; i++) {
            for (int l = 0; l < node.getMatrix()[i].length; l++) {
                try {
                    if ((Integer) node.getMatrix()[i][l].get() == 0) {
                        if (number < (minInColumns[l] + minInRows[i])) {
                            number = minInColumns[l] + minInRows[i];
                            path.setColumn(node.getMeteDataRow()[l]);
                            path.setRow(node.getMeteDataColumn()[i]);
                        }
                    }
                } catch (Exception e) {}
            }
        }
        return path;
    }

    private Node afterAfterReduction(Node parent, Node right, Node left) {
        int rightSum = findSumOfMinNumbersInRowAndColumn(right);
        int leftSum = findSumOfMinNumbersInRowAndColumn(left);
        right.setSum(parent.getSum() + rightSum);
        left.setSum(parent.getSum() + leftSum);
        return rightSum > leftSum ? left : right;
    }

    private int findSumOfMinNumbersInRowAndColumn(Node node) {
        int sum = 0;
        int number = Integer.MAX_VALUE;
        for (int i = 0; i < node.getMatrix().length; i++) {
            for (int l = 0; l < node.getMatrix()[i].length; l++) {
                try {
                    if ((Integer) node.getMatrix()[i][l].get() < number) {
                        number = (Integer) node.getMatrix()[i][l].get();
                    }
                } catch (Exception e) {}
            }
            sum += number;
            number = Integer.MAX_VALUE;
            for (int l = 0; l < node.getMatrix()[i].length; l++) {
                try {
                    if ((Integer) node.getMatrix()[l][i].get() < number) number = (Integer) node.getMatrix()[l][i].get();
                } catch (Exception e) {}
            }
            sum += number;
            number = Integer.MAX_VALUE;
        }
        return sum;
    }

    private boolean check(Node node) {
        for (int i = 0; i < node.getMatrix().length; i++) {
            for (int l = 0; l < node.getMatrix()[i].length; l++) {
                try {
                    if ((Integer) node.getMatrix()[i][l].get() > 0) {
                        return false;
                    }
                } catch (Exception e) {}
            }
        }
        return true;
    }

    private void findRemainedPaths(Node node) {
        for (int i = 0; i < node.getMatrix().length; i++) {
            tree.addPath(new Path(node.getMeteDataRow()[i], node.getMeteDataColumn()[i]));
        }
    }

}
