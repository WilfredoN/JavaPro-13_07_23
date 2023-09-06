package multithreading;

import java.util.Arrays;

public class ArrayInitializer {
    public static void init(double[] array) {
        int half = array.length / 2;
        double[] firstArrayPart = Arrays.copyOfRange(array, 0, half);
        double[] secondArrayPart = Arrays.copyOfRange(array, half, array.length);
        Thread firstThread = new Thread(new calculateNewIndexValue(firstArrayPart));
        Thread secondThread = new Thread(new calculateNewIndexValue(secondArrayPart));
        firstThread.start();
        secondThread.start();
        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.arraycopy(firstArrayPart, 0, array, 0, half);
        System.arraycopy(secondArrayPart, 0, array, half, half);
    }

    private record calculateNewIndexValue(double[] array) implements Runnable {
        public static void main(String[] args) {
            double[] array = new double[10];
            Arrays.fill(array, 5.5);
            init(array);
            for (double value : array) {
                System.out.println(value);
            }
        }

        @Override
        public void run() {
            for (int i = 0; i < array.length; i++) {
                var offset = i / 5.0;
                array[i] = array[i] * Math.sin(0.2 + offset) * Math.cos(0.2 + offset) * Math.cos(0.4 + offset);
            }
        }
    }
}
