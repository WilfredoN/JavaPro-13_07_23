package collections.lists;

import collections.coffee.order.CoffeeOrderBoard;
import collections.coffee.order.DuplicateNumberException;

public class Main {
    public static void main(String[] args) throws DuplicateNumberException {
        CoffeeOrderBoard board = new CoffeeOrderBoard();
        board.add(4, "Alen");
        board.add(34, "Yoda");
        board.add(33, "Obi-van");
        board.add(2, "John Snow");

        board.draw(board);
    }
}
