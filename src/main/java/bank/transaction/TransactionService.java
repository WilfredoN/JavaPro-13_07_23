package bank.transaction;

import bank.card.CardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TransactionService {
    private final CardRepository cardRepository;

@Transactional
public void transferMoney(String from, String to, int amount) {
    var fromCard = cardRepository.findByUid(from)
            .orElseThrow(() -> new CardNotFoundException("Card with id " + from + " not found"));
    var toCard = cardRepository.findByUid(to)
            .orElseThrow(() -> new CardNotFoundException("Card with id " + to + " not found"));
    if (fromCard.getAccount().getBalance() < amount) {
        throw new BalanceNotEnoughException("Not enough money");
    }
    fromCard.getAccount().setBalance(fromCard.getAccount().getBalance() - amount);
    toCard.getAccount().setBalance(toCard.getAccount().getBalance() + amount);
    cardRepository.save(fromCard);
    cardRepository.save(toCard);
}
}
