package binary_tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BinaryTree {

    private Node root;
    private List<Path> paths;
    private HashMap<Integer, Node> map;
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

    public HashMap<Integer, Node> getMap() {
        return map;
    }

    public void setMap(HashMap<Integer, Node> map) {
        this.map = map;
    }
}