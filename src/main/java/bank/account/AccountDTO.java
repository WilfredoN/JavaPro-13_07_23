package bank.account;

import lombok.Builder;

@Builder
public record AccountDTO(
        String id,
        String iban,
        int balance,
        String personId
) {
}
