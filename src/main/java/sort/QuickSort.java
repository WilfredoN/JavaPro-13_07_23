package sort;

import java.util.Arrays;

public class QuickSort {
    public static void sort(int[] ar, int low, int high) {
        if (ar.length == 0 || low >= high) {
            return;
        }
        int middle = low + (high - low) / 2;
        // Складніть алгоритму залежить від змінної нижче, "опори", якщо це - перший\останній елемент - алгоритм
        // працює довше. Краща\середня складність - O(n * log(n)), гірша - O(n^2).
        int pillar = ar[middle];
        int i = low, j = high;
        while (i <= j) {
            while (ar[i] < pillar) i++;
            while (ar[j] > pillar) j--;
            if (i <= j) {
                int t = ar[i];
                ar[i] = ar[j];
                ar[j] = t;
                i++;
                j--;
            }
        }
        if (low < j) sort(ar, low, i);
        if (high > i) sort(ar, i, high);
    }

    public static void main(String[] args) {
        int[] ar = {32, 187, 745, 993, 665, 643, 287, 656, 426, 528, 120};
        int low = 0;
        int high = ar.length - 1;
        System.out.println("Before - " + Arrays.toString(ar));
        long startTime = System.nanoTime();
        sort(ar, low, high);
        long endTime = System.nanoTime();
        System.out.println("After - " + Arrays.toString(ar) + "\n" + (endTime - startTime));
    }
}
