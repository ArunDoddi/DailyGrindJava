package com.rough;

public class PerformanceTest {
    public static void main(String[] args) {
        long startTime = System.nanoTime();

        // CPU-bound task: Fibonacci
        int n = 45;
        System.out.println("Fibonacci(" + n + ") = " + fib(n));

        // Memory-bound task: Allocate and fill large array
        int[] bigArray = new int[100_000_000];
        for (int i = 0; i < bigArray.length; i++) {
            bigArray[i] = i;
        }
        System.out.println("Array filled: " + bigArray.length + " elements");

        long endTime = System.nanoTime();
        double elapsedSeconds = (endTime - startTime) / 1_000_000_000.0;
        System.out.printf("Total Runtime: %.3f seconds%n", elapsedSeconds);
    }

    // Recursive Fibonacci (inefficient to stress CPU)
    private static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }
}
