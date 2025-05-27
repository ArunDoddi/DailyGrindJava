package com.rough;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Comparator;

public class FolderBuildTest {
    public static void main(String[] args) throws IOException {
        String rootFolder = "test_namespace_root"; // easy to delete this
        int totalFolders = 1_000_000;

        System.out.println("Starting to create " + totalFolders + " folders...");
        long start = System.nanoTime();

        for (int i = 0; i < totalFolders; i++) {
            String padded = String.format("%06d", i);  // e.g., 000001
            String sub1 = padded.substring(0, 3);       // first level
            String sub2 = padded.substring(3);          // second level

            Path folderPath = Paths.get(rootFolder, sub1, sub2);
            Files.createDirectories(folderPath);

            if (i > 0 && i % 100_000 == 0) {
                System.out.println("Created " + i + " folders...");
            }
        }

        Files.walk(Paths.get("test_namespace_root"))
                .sorted(Comparator.reverseOrder())
                .map(Path::toFile)
                .forEach(File::delete);


        long end = System.nanoTime();
        double timeSec = (end - start) / 1_000_000_000.0;
        System.out.printf("✅ Completed. Total Time: %.2f seconds%n", timeSec);

        System.out.println("\nTo delete all, simply run:");
        System.out.println("rm -rf " + rootFolder);
    }
}
