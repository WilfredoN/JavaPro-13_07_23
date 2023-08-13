package collections.coffee.order;

import java.util.TreeMap;

public class CoffeeOrderBoard {
    final TreeMap<Integer, String> orders = new TreeMap<>();

    public void add(int orderNumber, String name) throws DuplicateNumberException {
        if (!orders.containsKey(orderNumber)) {
            orders.put(orderNumber, name);
        } else {
            throw new DuplicateNumberException(orderNumber);
        }
    }

    public void deliver() {
        orders.remove(orders.firstKey());
    }

    public void deliver(int orderToDelete) throws WrongNumberToDeliver {
        if (orders.containsKey(orderToDelete)) {
            orders.remove(orderToDelete);
        } else {
            throw new WrongNumberToDeliver(orderToDelete);
        }
    }

    public void draw(CoffeeOrderBoard board) {
        System.out.println(
                "=============\n" +
                        "Num | Name");
        for (int order : board.orders.keySet()) {
            System.out.println(order + " | " + board.orders.get(order));
        }
    }
}
