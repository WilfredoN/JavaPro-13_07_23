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
        Integer[] arrayInteger = {1,2,3,4,5};
        String[] arrayString = {"1","2","3"};
        List<Integer> resultInteger = new ArrayList<>(List.of(1, 2, 3, 4, 5));
        List<String> resultString = new ArrayList<>(List.of("1","2","3"));
        assertEquals(resultInteger, Collections.toList(arrayInteger));
        assertEquals(resultString, Collections.toList(arrayString));

    }
    @Test
    void shouldToReturnArrayWithoutDuplicates() {
        List<Integer> array = Arrays.asList(1,1,3,3,6,6,4,3,3);
        List<Integer> arrayResult = Arrays.asList(1,3,4,6);
        List<Integer> result = Collections.findUnique(array);
        assertEquals(arrayResult, result);
    }
    @Test
    void shouldToCalulateOccurance() {
        List<String> array = Arrays.asList("bird", "fox", "fox", "cat", "dog", "dog", "dog", "cat",
                "bird", "fox", "panda", "cat", "dog", "fox");
        HashMap<String, Integer> result = new HashMap<>();
        result.put("panda", 1);
        result.put("bird", 2);
        result.put("cat", 3);
        result.put("dog", 4);
        result.put("fox", 4);
        String resultToCompare = "";
        for (Map.Entry<String, Integer> el : result.entrySet())
            resultToCompare += (el.getKey() + ": " + el.getValue()) + "\n";
        assertEquals(resultToCompare, Collections.calcOccurance(array));
    }
    @Test
    void shouldToFindOccurance() {
        List<String> array = Arrays.asList("bird", "fox", "fox", "cat", "dog", "dog", "dog", "cat",
                "bird", "fox", "panda", "cat", "dog", "fox");
        List<Collections.occuranceFinder> resultToCompare = new ArrayList<>();
        resultToCompare.add(new Collections.occuranceFinder("panda", 1));
        resultToCompare.add(new Collections.occuranceFinder("bird", 2));
        resultToCompare.add(new Collections.occuranceFinder("cat", 3));
        resultToCompare.add(new Collections.occuranceFinder("dog", 4));
        resultToCompare.add(new Collections.occuranceFinder("fox", 4));
        String result = "[\n";
        for (Collections.occuranceFinder item : resultToCompare) result += "{" + item + "\n";
        result += "\n]";
        assertEquals(result, Collections.findOccurance(array));
    }
}