package multithreading;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayInitializerTest {
    @Test
    public void shouldToCheckThreadWork() {
        double[] ar = new double[10];
        double value = 5.5;
        Arrays.fill(ar, value);
        ArrayInitializer.init(ar);
        for (int i = 0; i < ar.length / 2; i++) {
            System.out.println(ar[i] + " | " + ar[ar.length / 2 + i]);
            assertEquals(ar[i], ar[ar.length / 2 + i]);
        }
    }

}