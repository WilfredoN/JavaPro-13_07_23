package generics;

public class WrongTypeException extends Throwable {
    public WrongTypeException() {
        super("В одну коробку не можна скласти різни типи фруктів!");
    }
}
