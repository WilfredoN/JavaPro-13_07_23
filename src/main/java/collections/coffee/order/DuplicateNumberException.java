package collections.coffee.order;

public class DuplicateNumberException extends Throwable {
    int number;

    public int getNumber() {
        return number;
    }

    public DuplicateNumberException(int number) {
        super("Номер " + number + " вже існує");
        this.number = number;
    }
}
