package collections.lists;

import java.util.*;

public class Collections {
    public static void main(String[] args) {
        List<String> items = Arrays.asList("java", "java", "js", "tomato", "hillel", "main", "apple", "banana",
                "apple", "apple", "java", "java", "js", "tomato", "hillel", "main", "apple", "banana", "apple", "banana");
        String target = "apple";
        System.out.println("1) Кількість повторів слова " + target + " - " + countOccurance(items, target));
        List<Integer> arrayOne = new ArrayList<>();
        for (int i = 0; i < 5; i++) arrayOne.add((int) (5 + Math.random() * 10));
        System.out.println("2) Масив - " + arrayOne + "\nСписок - " + toList(arrayOne.toArray()));
        List<Integer> arrayTwo = Arrays.asList(1, 2, 3, 4, 2, 3);
        System.out.println("3) Масив - " + arrayTwo + "\nМасив без повторів - " + findUniqueInteger(arrayTwo));
        List<String> arrayThree = Arrays.asList("bird", "fox", "fox", "cat", "dog", "dog", "dog", "cat",
                "bird", "fox", "panda", "cat", "dog", "fox");
        System.out.print("4) ");
        System.out.println(calcOccurance(arrayThree));
        List<String> arrayFour = Arrays.asList("bird", "fox", "fox", "cat", "dog", "dog", "dog", "cat",
                "bird", "fox", "panda", "cat", "dog", "fox");
        System.out.println("5) ");
        System.out.println(findOccurance(arrayFour));
    }

    public static int countOccurance(List<String> items, String target) {
        int counter = 0;
        for (String item : items) if (item.equals(target)) counter++;
        return counter;
    }

    public static <T> List<T> toList(T[] ar) {
        return Arrays.asList(ar);
    }


    public static List<Integer> findUniqueInteger(List<Integer> items) {
        List<Integer> result = new ArrayList<>();

        for (Integer item : items) {
            if (!result.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }
    public static List<String> findUniqueString(List<String> items) {
        List<String> result = new ArrayList<>();

        for (String item : items) {
            if (!result.contains(item)) {
                result.add(item);
            }
        }

        return result;
    }
    public static ArrayList<String> calcOccurance(List<String> items) {
        var result = new ArrayList<String>();
        for (String item : findUniqueString(items)) {
            result.add(item + ": " + countOccurance(items, item));
        }
        return result;
    }

    public static List<Occurances> findOccurance(List<String> items) {
        var result = new ArrayList<Occurances>();
        for (String item : findUniqueString(items)) {
            result.add(new Occurances(item, countOccurance(items, item)));
        }
        return result;
    }
}