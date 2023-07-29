package Inheritance;

public class Main {
    public static void main(String[] args) {
        Dog dog_1 = new Dog("Jack");
        Dog dog_2 = new Dog("Bonny");
        dog_1.torun((int)(5 + Math.random() * 600));
        dog_2.torun((int)(5 + Math.random() * 600));
        dog_2.toswim((int)(0 + Math.random() * 10));
        dog_1.toswim((int)(0 + Math.random() * 10));
        Cat cat_1 = new Cat("Lizzy");
        Cat cat_2 = new Cat("Salem");
        Cat cat_3 = new Cat("Max");
        cat_1.torun((int)(5 + Math.random() * 200));
        cat_2.torun((int)(5 + Math.random() * 200));
        cat_3.torun((int)(5 + Math.random() * 200));
        cat_1.toswim((int)(0 + Math.random() + 5));
        cat_2.toswim((int)(0 + Math.random() + 5));
        cat_3.toswim((int)(0 + Math.random() + 5));

        System.out.println(Dog.amount + " собак, " + Cat.amount + " котів, суммарно - " + Animal.getAnimalCount() + " тварин.");
    }
}