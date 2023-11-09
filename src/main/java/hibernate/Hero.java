package hibernate;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "heroes")
@Builder
@RequiredArgsConstructor
public class Hero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String gender;
    private String eyeColor;
    private String race;
    private String hairColor;
    private double height;
    private String publisher;
    private String skinColor;
    private String alignment;
    private int weight;
}
