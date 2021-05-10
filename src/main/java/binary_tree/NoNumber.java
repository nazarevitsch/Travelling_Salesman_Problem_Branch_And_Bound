package binary_tree;

public class NoNumber implements MatrixPoint<String> {

    public String get() {
        return "-";
    }

    public MatrixPoint copy() {
        return new NoNumber();
    }
}
