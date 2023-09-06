package multithreading.advanced;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayInitializerForkTest {
    private double[] array;
    private ThreadSafeList<Double> threadSafeList;

    @BeforeEach
    void setUp() {
        array = new double[10];
        Arrays.fill(array, 5.5);
        threadSafeList = new ThreadSafeList<>(array.length);
    }

    @Test
    void testArrayInitializerFork() {
        ForkJoinPool pool = new ForkJoinPool();
        ThreadSafeList<Double> threadSafe = new ThreadSafeList<>(array.length);
        pool.invoke(new InitArray(array, threadSafe, 0, array.length));
        for (int i = 0; i < array.length / 2; i++) {
            System.out.println(array[i] + " | " + array[array.length / 2 + i]);
            assertEquals(array[i], array[array.length / 2 + i]);
        }
    }

    @Test
    void testThreadSafeList() {
        threadSafeList.add(10.0);
        assertEquals(1, threadSafeList.size());
        assertEquals(10.0, threadSafeList.get(0));
        double removedValue = threadSafeList.remove(0);
        assertEquals(0, threadSafeList.size());
        assertEquals(10.0, removedValue, 1e-6);
    }
}
