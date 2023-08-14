package collections.coffee.order;

public class WrongNumberToDeliver extends Throwable {
    int number;

    public int getNumber() {
        return number;
    }

    public WrongNumberToDeliver(int number) {
        super("Номеру " + number + " немає у списку замовлень");
        this.number = number;
    }
}
