package collections.coffee.order;

import java.util.*;

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

    public List<Order> draw() {
        List<Order> orderList = new ArrayList<>();
        for (Map.Entry<Integer, String> entry : orders.entrySet()) {
            int orderNumber = entry.getKey();
            String name = entry.getValue();
            Order order = new Order(orderNumber, name);
            orderList.add(order);
        }
        return orderList;
    }
}
