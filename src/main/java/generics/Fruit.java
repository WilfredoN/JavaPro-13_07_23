package generics;

public class Fruit {
    private final String typeOfFruit;
    private final Float weight;

    public Fruit(String typeOfFruit, Float weight) {
        this.typeOfFruit = typeOfFruit;
        this.weight = weight;
    }

    public String getTypeOfFruit() {
        return typeOfFruit;
    }
    public Float getWeight() {
        return weight;
    }
}
