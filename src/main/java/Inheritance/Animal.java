package Inheritance;

public abstract class Animal {
    private static int animalCount;
    public Animal() {
        animalCount++;
    }

    public abstract void torun (int distance);
    public abstract void toswim (int distance);

    public static int getAnimalCount() {
        return animalCount;
    }
}