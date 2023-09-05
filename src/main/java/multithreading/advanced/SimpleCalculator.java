package multithreading.advanced;

import java.util.concurrent.CompletableFuture;

public class SimpleCalculator {
    public int squareSum(int first, int second) {
        CompletableFuture<Integer> firstSquare = CompletableFuture.supplyAsync(() -> first * first);
        CompletableFuture<Integer> secondSquare = CompletableFuture.supplyAsync(() -> second * second);
        return firstSquare.thenCombine(secondSquare, Integer::sum).join();
    }
}
