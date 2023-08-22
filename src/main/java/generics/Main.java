package generics;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static <T> List<T> toList(T[] ar) {
        return Arrays.asList(ar);
    }

    public static void main(String[] args) {
        String[] ar = {"asda", "Ada"};
        System.out.println(toList(ar));
    }
}
