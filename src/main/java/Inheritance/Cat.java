package Inheritance;

public class Cat extends Animal {
    String name;
    static int amount = 0;
    public Cat(String name) {
        this.name = name;
        amount++;
    }
    @Override
    public void torun(int distance) {
        if (distance > 200) {
            System.out.println(this.name + " не може пробігти " + distance + " метрів!");
        }
        else System.out.println(this.name + " пробіг\\ла "+ distance + "  метрів");
    }

    @Override
    public void toswim(int distance) {
        System.out.println("Коти не плавають! :<");
    }
}
