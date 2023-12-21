package bank.exception;

import bank.transaction.BalanceNotEnoughException;
import bank.transaction.CardNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(CardNotFoundException.class)
    public ResponseEntity<String> handleCardNotFoundException(CardNotFoundException e) {
        return ResponseEntity.notFound().build();
    }
    @ExceptionHandler(BalanceNotEnoughException.class)
    public ResponseEntity<String> handleBalanceNotEnoughException(BalanceNotEnoughException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
