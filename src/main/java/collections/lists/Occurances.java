package collections.lists;

public class Occurances {
    String name;
    int occuranceCount;

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
