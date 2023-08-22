package generics;

import java.util.ArrayList;
import java.util.List;

public class Box {
    private final String type;
    private final List<Fruit> fruitList;

    public Box(String type) {
        this.type = type;
        this.fruitList = new ArrayList<>();
    }

    public void stackTheFruit(Fruit fruits) throws WrongTypeException {
        if (fruits.getTypeOfFruit().equals(type)) {
            fruitList.add(fruits);
        } else {
            throw new WrongTypeException();
        }
    }

    public void stackFruits(List<Fruit> fruitList) throws WrongTypeException {
        for (Fruit fruit : fruitList) {
            stackTheFruit(fruit);
        }
    }

    public Float getWeight() {
        float weight = 0F;
        for (Fruit fruit : fruitList) {
            if (fruit.getTypeOfFruit().equals("Apple")) {
                weight += 1.0F;
            } else if (fruit.getTypeOfFruit().equals("Orange")) {
                weight += 1.5F;
            }
        }
        return weight;
    }

    public boolean compare(Box anotherFruitBox) {
        return getWeight().equals(anotherFruitBox.getWeight());
    }

    public void merge(Box anotherFruitBox) throws WrongTypeException {
        if (!type.equals(anotherFruitBox.type)) {
            throw new WrongTypeException();
        }
        fruitList.addAll(anotherFruitBox.fruitList);
    }

}
