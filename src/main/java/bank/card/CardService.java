package bank.card;

import bank.account.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Random;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final AccountRepository accountRepository;
    private final Random random = new Random();

    public List<CardDTO> getCards(Pageable pageable) {
        return cardRepository.findAll(pageable).stream()
                .map(this::convertCard)
                .toList();
    }

    private CardDTO convertCard(Card card) {
        return new CardDTO(card.getUid(), card.getPan(), card.getAccount().getUid(),
                card.getExpirationDate().toString(), card.getPin(), card.getCvv(),
                card.getStatus(), card.getPerson().getUid());
    }

    public CardDTO findByPan(String pan) {
        return cardRepository.findByPan(pan).map(this::convertCard)
                .orElseThrow();
    }

    public CardDTO openCard(String accountId) {
        var account = accountRepository.findByUid(accountId)
                .orElseThrow();
        String uid = UUID.randomUUID().toString();
        String pan = String.format("%04d%04d%04d%04d", random.nextInt(10000), random.nextInt(10000), random.nextInt(10000), random.nextInt(10000));
        LocalDate expirationDate = LocalDate.now().plusYears(3);
        String pin = String.format("%04d", random.nextInt(10000));
        String cvv = String.format("%03d", random.nextInt(1000));
        return convertCard(cardRepository.save(Card.builder()
                .uid(uid)
                .pan(pan)
                .account(account)
                .expirationDate(expirationDate)
                .pin(pin)
                .person(account.getPerson())
                .cvv(cvv)
                .status(CardStatus.ACTIVE)
                .build()));
    }
}
