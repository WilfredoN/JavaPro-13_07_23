package hibernate;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "heroes")
public class Hero {

    @Column(name = "eye_color")
    private String eyeColor;
    @Column(name = "hair_color")
    private String hairColor;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String gender;
    @Column(name = "skin_color")
    private String skinColor;
    private String race;
    public Hero() {
    }
    private double height;
    private String publisher;
    public Hero(String name, String gender, String eyeColor, String race,
                String hairColor, double height, String publisher, String skinColor,
                String alignment, int weight) {
        this.name = name;
        this.gender = gender;
        this.eyeColor = eyeColor;
        this.race = race;
        this.hairColor = hairColor;
        this.height = height;
        this.publisher = publisher;
        this.skinColor = skinColor;
        this.alignment = alignment;
        this.weight = weight;
    }
    private String alignment;
    private int weight;
}
