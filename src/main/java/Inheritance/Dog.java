package Inheritance;

public class Dog extends Animal {
    String name;
    static int amount = 0;
    public Dog(String name) {
        this.name = name;
        amount++;
    }

    @Override
    public void torun(int distance) {
        if (distance > 500) {
            System.out.println(this.name + " не може пробігти " + distance + " метрів!");
        }
        else System.out.println(this.name + " пробіг\\ла " + distance + " метрів");
    }

    @Override
    public void toswim(int distance) {
        if (distance > 10) {
            System.out.println(this.name + " не може проплисти " + distance + "!");
        }
        else System.out.println(this.name + " проплив\\ла " + distance + " метрів");
    }
}
