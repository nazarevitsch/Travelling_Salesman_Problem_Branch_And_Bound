package binary_tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    private Node root;
    private List<Path> paths;
    private int deep;

    public BinaryTree() {
        paths = new ArrayList<Path>();
        deep = 1;
    }

    public BinaryTree(Node root) {
        this.root = root;
        paths = new ArrayList<Path>();
        deep = 1;
    }

    public void addPath(Path path) {
        paths.add(path);
    }

    public Node getRoot() {
        return root;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public List<Path> getPaths() {
        return paths;
    }

    public void setPaths(List<Path> paths) {
        this.paths = paths;
    }

    public int getDeep() {
        return deep;
    }

    public void setDeep(int deep) {
        this.deep = deep;
    }

    public String printTree() {
        StringBuilder builder = new StringBuilder();

        int currentDeep = deep;
        Node currentNode = root;
        for (int i = 0; i < 10 * (currentDeep - 1); i++) {
            builder.append(" ");
        }
        builder.append(currentNode.toString());
        builder.append("\n");
        for (int i = 0; i < 10 * (currentDeep - 1) + 7; i++) {
            builder.append(" ");
        }
        builder.append("|\n");


        Node left = currentNode.getLeft();
        Node right = currentNode.getRight();
        currentDeep--;
        for (int i = 0; i < 10 * (currentDeep - 1); i++) {
            builder.append(" ");
        }
        builder.append(left.toString());
        builder.append("\n");
        for (int i = 0; i < 10 * (currentDeep - 1) + 7; i++) {
            builder.append(" ");
        }
        builder.append("|\n");


        return builder.toString();
    }
}