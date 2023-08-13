package collections.coffee.order;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CoffeeOrderBoardTest {
    private CoffeeOrderBoard orderList;

    @BeforeEach
    void init() {
        orderList = new CoffeeOrderBoard();
    }

    @Test
    void shouldToAddOrders() throws DuplicateNumberException {
        Order third_order = new Order(8, "Lucas");
        Order first_order = new Order(5, "Alex");
        Order second_order = new Order(2, "John");
        orderList.add(first_order.orderNumber(), first_order.name());
        orderList.add(second_order.orderNumber(), second_order.name());
        orderList.add(third_order.orderNumber(), third_order.name());
        assertEquals(2, orderList.orders.firstKey());
        assertEquals(8, orderList.orders.lastKey());
        Throwable err = assertThrows(DuplicateNumberException.class, () -> orderList.add(8, "Lucy"));
        assertNotNull(err.getMessage());
    }

    @Test
    void shouldToOrderNearest() throws DuplicateNumberException {
        Order third_order = new Order(8, "Lucas");
        Order first_order = new Order(5, "Alex");
        Order second_order = new Order(2, "John");
        orderList.add(first_order.orderNumber(), first_order.name());
        orderList.add(second_order.orderNumber(), second_order.name());
        orderList.add(third_order.orderNumber(), third_order.name());
        orderList.deliver();
        assertEquals(5, orderList.orders.firstKey());
    }

    @Test
    void shoultToOrderByNumber() throws DuplicateNumberException, WrongNumberToDeliver {
        Order third_order = new Order(8, "Lucas");
        Order first_order = new Order(5, "Alex");
        Order second_order = new Order(2, "John");
        orderList.add(first_order.orderNumber(), first_order.name());
        orderList.add(second_order.orderNumber(), second_order.name());
        orderList.add(third_order.orderNumber(), third_order.name());
        orderList.deliver(5);
        assertEquals(2, orderList.orders.firstKey());
        Throwable err = assertThrows(WrongNumberToDeliver.class, () -> orderList.deliver(1));
        assertNotNull(err.getMessage());
    }
}