package generics;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> fruitList;

    public Box() {
        this.fruitList = new ArrayList<>();
    }

    public void stackTheFruit(T fruits) {
            fruitList.add(fruits);
    }

    public void stackFruits(List<T> fruitList) {
        for (T fruit : fruitList) {
            stackTheFruit(fruit);
        }
    }

    public Float getWeight() {
        float weight = 0F;
        for (Fruit fruit : fruitList) {
            weight += fruit.getWeight();
        }
        return weight;
    }

    public boolean compare(Box<?> anotherFruitBox) {
        return getWeight().equals(anotherFruitBox.getWeight());
    }

    public void merge(Box<T> anotherFruitBox) {
        if (fruitList.isEmpty() || fruitList.get(0).getTypeOfFruit().equals(anotherFruitBox.fruitList.get(0).getTypeOfFruit())) {
            fruitList.addAll(anotherFruitBox.fruitList);
        }
    }
}
