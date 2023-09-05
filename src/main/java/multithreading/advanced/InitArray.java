package multithreading.advanced;

import java.util.concurrent.RecursiveAction;

public class InitArray extends RecursiveAction {
    private static final int threadCount = 2;
    private final double[] array;
    private final ThreadSafeList<Double> threadSafe;
    private final int start;
    private final int end;

    public InitArray(double[] array, ThreadSafeList<Double> threadSafe, int start, int end) {
        this.array = array;
        this.threadSafe = threadSafe;
        this.start = start;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - start <= threadCount) {
            for (int i = start; i < end; i++) {
                double offset = i / 5.0;
                double value = array[i] * Math.sin(0.2 + offset) * Math.cos(0.2 + offset) * Math.cos(0.4 + offset);
                threadSafe.add(value);
            }
        } else {
            int middle = (start + end) / 2;
            invokeAll(new InitArray(array, threadSafe, start, middle),
                    new InitArray(array, threadSafe, middle, end));
        }
    }
}
