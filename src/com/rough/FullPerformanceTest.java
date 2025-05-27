package com.rough;

import java.io.*;
import java.nio.file.*;
import java.util.concurrent.*;

public class FullPerformanceTest {

    public static void main(String[] args) throws Exception {
        long totalStart = System.nanoTime();

        // CPU Test (Single Thread)
        long cpuStart = System.nanoTime();
        int fibResult = fib(45);
        long cpuEnd = System.nanoTime();
        System.out.println("Fibonacci(45) = " + fibResult);
        printTime("CPU (Single Thread)", cpuStart, cpuEnd);

        // Memory Test
        long memStart = System.nanoTime();
        int[] array = new int[100_000_000]; // ~400 MB
        for (int i = 0; i < array.length; i++) {
            array[i] = i;
        }
        long memEnd = System.nanoTime();
        System.out.println("Memory Test: Filled 100 million integers");
        printTime("Memory", memStart, memEnd);

        // Multi-threading Test
        long threadStart = System.nanoTime();
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Future<Integer> f1 = executor.submit(() -> fib(42));
        Future<Integer> f2 = executor.submit(() -> fib(42));
        Future<Integer> f3 = executor.submit(() -> fib(42));
        Future<Integer> f4 = executor.submit(() -> fib(42));
        int result = f1.get() + f2.get() + f3.get() + f4.get();
        executor.shutdown();
        long threadEnd = System.nanoTime();
        System.out.println("Multi-thread Fibonacci sum: " + result);
        printTime("Multi-threading", threadStart, threadEnd);

        // I/O Test
        long ioStart = System.nanoTime();
        Path path = Files.createTempFile("iotest", ".txt");
        BufferedWriter writer = Files.newBufferedWriter(path);
        for (int i = 0; i < 1_000_000; i++) {
            writer.write("This is a line for I/O performance test.\n");
        }
        writer.close();

        BufferedReader reader = Files.newBufferedReader(path);
        while (reader.readLine() != null);
        reader.close();
        Files.delete(path);
        long ioEnd = System.nanoTime();
        printTime("Disk I/O", ioStart, ioEnd);

        // Total Time
        long totalEnd = System.nanoTime();
        printTime("Total Runtime", totalStart, totalEnd);
    }

    // Naive recursive Fibonacci for stress testing
    private static int fib(int n) {
        if (n <= 1) return n;
        return fib(n - 1) + fib(n - 2);
    }

    private static void printTime(String label, long start, long end) {
        double seconds = (end - start) / 1_000_000_000.0;
        System.out.printf("%-20s: %.3f seconds%n", label, seconds);
    }
}
