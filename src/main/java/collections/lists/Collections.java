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
        System.out.println("3) Масив - " + arrayTwo + "\nМасив без повторів - " + findUnique(arrayTwo));
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


    public static List<Integer> findUnique(List<Integer> ar) {
        return new ArrayList<>(new HashSet<>(ar));
    }

    public static String calcOccurance(List<String> items) {
        HashMap<String, Integer> result = new HashMap<>();
        for (String item : items) result.put(item, result.getOrDefault(item, 0) + 1);
        String resultString = "";
        for (Map.Entry<String, Integer> el : result.entrySet())
            resultString += (el.getKey() + ": " + el.getValue()) + "\n";
        return resultString;
    }

    public static record occuranceFinder(String name, int occurance) {
        @Override
        public String toString() {
            return "name: " + "\"" + name + "\"" +
                    ", occurance: " + occurance +
                    "},";
        }
    }

    public static String findOccurance(List<String> items) {
        HashMap<String, Integer> result = new HashMap<>();
        for (String item : items) result.put(item, result.getOrDefault(item, 0) + 1);
        List<occuranceFinder> occuranceList = new ArrayList<>();
        for (Map.Entry<String, Integer> el : result.entrySet())
            occuranceList.add(new occuranceFinder(el.getKey(), el.getValue()));
        String resultStr = "[\n";
        for (occuranceFinder item : occuranceList) resultStr += "{" + item + "\n";
        resultStr += "\n]";
        return resultStr;
    }
}
