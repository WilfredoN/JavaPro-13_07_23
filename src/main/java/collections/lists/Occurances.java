package collections.lists;

public class Occurances {
    String name;
    int occuranceCount = 0;

    public Occurances(String name, int occuranceCount) {
        this.name = name;
        this.occuranceCount = occuranceCount;
    }

    @Override
    public String toString() {
        return "\n{name='" + name + '\'' +
                ", occurance=" + occuranceCount +
                "}";
    }

}
