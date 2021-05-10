package binary_tree;

public class Number implements MatrixPoint<Integer>{
    private int number;

    public Number() {}

    public Number(int number) {
        this.number = number;
    }

    public Integer get(){
        return number;
    }

    public MatrixPoint copy() {
        return new Number(this.number);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
