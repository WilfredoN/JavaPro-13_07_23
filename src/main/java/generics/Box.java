package generics;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> fruits;

    public Box() {
        this.fruits = new ArrayList<>();
    }

    public void stackTheFruit(T fruit) {
            this.fruits.add(fruit);
    }

    public void stackFruits(List<T> fruitList) {
        for (T fruit : fruitList) {
            stackTheFruit(fruit);
        }
    }

    public Float getWeight() {
        float weight = 0F;
        for (Fruit fruit : fruits) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<?> anotherFruitBox) {
        return getWeight().equals(anotherFruitBox.getWeight());
    }

    public void merge(Box<T> anotherFruitBox) {
            fruits.addAll(anotherFruitBox.fruits);
    }
    protected List<T> getAllFruits() {
        return new ArrayList<>(fruits);
    }
}
