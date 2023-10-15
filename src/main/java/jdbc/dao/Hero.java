package jdbc.dao;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Hero {
    Long id;
    String name;
    String gender;
    String eye_color;
    String race;
    String hair_color;
    double height;
    String publisher;
    String skin_color;
    String alignment;
    int weight;
}
