package sort;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class QuickSortTest {

    @Test
    public void shouldToSort() {
        var array = new int[]{
                915, 681, 774, 524, 293, 745, 702, 809, 610, 422
        };
        var exceptedResult = new int[]{
                293, 422, 524, 610, 681, 702, 745, 774, 809, 915
        };
        System.out.println("Before - " + Arrays.toString(array));
        QuickSort.sort(array, 0, array.length - 1);
        System.out.println("After - " + Arrays.toString(array));
        assertArrayEquals(exceptedResult, array);
    }

    @Test
    public void shouldReturn() {
        var array = new int[]{};
        int[] exceptedResult = new int[]{};
        QuickSort.sort(array, 0, array.length);
        assertArrayEquals(exceptedResult, array);
    }
}