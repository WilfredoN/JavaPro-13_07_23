package jdbc.dao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Hero {
    private final Long id;
    private final String name;
    private final String gender;
    private final String eyeColor;
    private final String race;
    private final String hairColor;
    private final double height;
    private final String publisher;
    private final String skinColor;
    private final String alignment;
    private final int weight;
}
