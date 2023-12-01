package bank.person;

import lombok.Builder;

@Builder
public record PersonDTO(
        String id,
        String name,
        String email
) {
}
