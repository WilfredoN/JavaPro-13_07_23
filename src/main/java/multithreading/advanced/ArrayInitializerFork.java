package multithreading.advanced;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

public class ArrayInitializerFork {
    public static void main(String[] args) {
        double[] array = new double[10];
        Arrays.fill(array, 5.5);
        ForkJoinPool pool = new ForkJoinPool();
        ThreadSafeList<Double> threadSafe = new ThreadSafeList<>(array.length);

        pool.invoke(new InitArray(array, threadSafe, 0, array.length));

        for (double value : threadSafe) {
            System.out.println(value);
        }
    }
}
