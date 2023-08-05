package collections.lists;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class CollectionsTest {
    @Test
    void shouldToCountOccurances() {
        List<String> items = Arrays.asList("java", "java", "js", "tomato", "hillel", "main", "apple", "banana",
                "apple", "apple", "java", "java", "js", "tomato", "hillel", "main", "apple", "banana", "apple", "banana");
        String target = "apple";
        int result = Collections.countOccurance(items, target);
        assertEquals(5, result);
    }

    @Test
    void shouldReturnArrayIntoList() {
        Integer[] arrayInteger = {1, 2, 3, 4, 5};
        String[] arrayString = {"1", "2", "3"};
        List<Integer> resultInteger = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<String> resultString = new ArrayList<>(List.of("1", "2", "3"));
        assertEquals(resultInteger, Collections.toList(arrayInteger));
        assertEquals(resultString, Collections.toList(arrayString));

    }

    @Test
    void shouldToReturnArrayWithoutDuplicates() {
        List<Integer> array = Arrays.asList(1, 1, 3, 3, 6, 6, 4, 3, 3);
        List<Integer> arrayResult = Arrays.asList(1, 3, 6, 4);
        List<Integer> result = Collections.findUniqueInteger(array);
        assertEquals(arrayResult, result);
    }

    @Test
    void shouldToCalculateOccurance() {
        List<String> array = Arrays.asList("bird", "fox", "fox", "cat", "dog", "dog", "dog", "cat",
                "bird", "fox", "panda", "cat", "dog", "fox");
        var result = new ArrayList<String>();
        result.add("bird" + ": " + "2");
        result.add("fox" + ": " + "4");
        result.add("cat" + ": " + "3");
        result.add("dog" + ": " + "4");
        result.add("panda" + ": " + "1");
        assertEquals(result, Collections.calcOccurance(array));
    }

    @Test
    void shouldToFindOccurance() {
        List<String> array = Arrays.asList("bird", "fox", "fox", "cat", "dog", "dog", "dog", "cat",
                "bird", "fox", "panda", "cat", "dog", "fox");
        List<Occurances> resultToCompare = new ArrayList<>();
        resultToCompare.add(new Occurances("bird", 2));
        resultToCompare.add(new Occurances("fox", 4));
        resultToCompare.add(new Occurances("cat", 3));
        resultToCompare.add(new Occurances("dog", 4));
        resultToCompare.add(new Occurances("panda", 1));
        List<Occurances> result = Collections.findOccurance(array);
        assertEquals(String.valueOf(result), String.valueOf(resultToCompare));
    }
}