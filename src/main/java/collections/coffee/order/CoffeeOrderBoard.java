package collections.coffee.order;

import java.util.*;

public class CoffeeOrderBoard {
    Map<Integer, String> orders = new TreeMap<>();

    void add(int orderNumber, String name) throws DuplicateNumberException {
        if (!orders.containsKey(orderNumber)) {
            orders.put(orderNumber, name);
        } else {
            throw new DuplicateNumberException(orderNumber);
        }
    }

}
