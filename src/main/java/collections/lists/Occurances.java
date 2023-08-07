package collections.lists;

import java.util.Objects;

public class Occurances {
    private final String name;
    private final int occuranceCount;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Occurances that = (Occurances) o;
        return occuranceCount == that.occuranceCount && Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, occuranceCount);
    }
}
