package jdbc.dao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class Hero {
    long id;
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
