package jdbc.dao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Hero {
    Long id;
    String name;
    String gender;
    String eyeColor;
    String race;
    String hairColor;
    double height;
    String publisher;
    String skinColor;
    String alignment;
    int weight;
}
