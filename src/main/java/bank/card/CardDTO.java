package bank.card;

import lombok.Builder;

@Builder
public record CardDTO
        (
                String id,
                String pan,
                String accountId,
                String expirationDate,
                String pin,
                String cvv,
                CardStatus status,
                String personId
        ) {

}
