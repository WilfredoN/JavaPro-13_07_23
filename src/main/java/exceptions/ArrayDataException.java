package exceptions;

public class ArrayDataException extends Exception {
    int i, j;

    public int getI() {
        return i;
    }

    public int getJ() {
        return j;
    }

    public ArrayDataException(int i, int j) {
        super("Немає числа на позиції ar[" + i + "][" + j + "]");
        this.i = i;
        this.j = j;
    }
}
