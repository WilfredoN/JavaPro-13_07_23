package jdbc.dao;

import lombok.Builder;

@Builder
public record HeroDTO(
        Long id,
        String name,
        String gender,
        String eyeColor,
        String race,
        String hairColor,
        double height,
        String publisher,
        String skinColor,
        String alignment,
        int weight
) {
}
