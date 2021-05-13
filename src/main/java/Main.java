import binary_tree.BinaryTree;
import binary_tree.Node;
import binary_tree.Path;

public class Main {

    public static void main(String[] args) {

        TravellingSalesmanProblem tsp = new TravellingSalesmanProblem();
        Node node = Test.test1();
        node.setPath(new Path());

        tsp.calculate(new BinaryTree(node));
        tsp.printResult();
    }
}
