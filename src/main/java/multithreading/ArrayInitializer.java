package multithreading;

import java.util.Arrays;

public class ArrayInitializer {
    public static void init(double[] array) {
        double[] firstArrayPart = Arrays.copyOfRange(array, 0, array.length / 2);
        double[] secondArrayPart = Arrays.copyOfRange(array, array.length / 2, array.length);
        Thread firstThread = new Thread(() -> calculateNewIndexValue(firstArrayPart));
        Thread secondThread = new Thread(() -> calculateNewIndexValue(secondArrayPart));
        firstThread.start();
        secondThread.start();
        try {
            firstThread.join();
            secondThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage());
        }
        System.arraycopy(firstArrayPart, 0, array, 0, firstArrayPart.length);
        System.arraycopy(secondArrayPart, 0, array, firstArrayPart.length, secondArrayPart.length);
    }

    private static void calculateNewIndexValue(double[] arrPart) {
        for (int i = 0; i < arrPart.length; i++) {
            arrPart[i] = (arrPart[i] * Math.sin(0.2 + i / 5.0) * Math.cos(0.2 + i / 5.0) * Math.cos(0.4 + i / 2.0));
        }
    }

    public static void main(String[] args) {
        double[] array = new double[10];
        Arrays.fill(array, 5.5);
        init(array);
        for (double value : array) {
            System.out.println(value);
        }
    }
}
