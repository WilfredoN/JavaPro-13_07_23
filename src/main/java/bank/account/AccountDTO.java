package bank.account;

public record AccountDTO(
        String id,
        String iban,
        int balance,
        Long personId
) {
}
