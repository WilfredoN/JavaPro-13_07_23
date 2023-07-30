package exceptions;

public class ArraySizeException extends Exception {
    public ArraySizeException() {
        super("Некорректний розмір масива");
    }
}
