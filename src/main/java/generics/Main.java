package generics;

import java.util.Arrays;
import java.util.List;

public class Main {
    public <T> List<T> toList(T[] ar) {
        return Arrays.asList(ar);
    }
}
