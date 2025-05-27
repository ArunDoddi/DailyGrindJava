package com.rough;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.*;
import java.util.concurrent.*;

public class NamespacePerformanceTest {

    private static final String ROOT_FOLDER = "test_namespace_root";
    private static final int TOTAL_FOLDERS = 1_000_000;
    private static final boolean WRITE_FILES = true;

    public static void main(String[] args) throws Exception {
        createFolders();
        // Uncomment the line below to auto-delete after creation
        deleteFolders();
    }

    // 🏗️ Folder Creation
    private static void createFolders() throws IOException {
        System.out.println("Creating " + TOTAL_FOLDERS + " folders...");
        long start = System.nanoTime();

        for (int i = 0; i < TOTAL_FOLDERS; i++) {
            String padded = String.format("%06d", i); // e.g., 000001
            String sub1 = padded.substring(0, 3);
            String sub2 = padded.substring(3);

            Path folderPath = Paths.get(ROOT_FOLDER, sub1, sub2);
            Files.createDirectories(folderPath);

            if (WRITE_FILES) {
                Path filePath = folderPath.resolve("meta.txt");
                Files.writeString(filePath, "Sample metadata for folder " + i);
            }

            if (i > 0 && i % 100_000 == 0) {
                System.out.println("Created: " + i + " folders...");
            }
        }

        long end = System.nanoTime();
        System.out.printf("✅ Folder creation complete in %.2f seconds%n",
                (end - start) / 1_000_000_000.0);
    }

    // 🧹 Multithreaded Folder Deletion
    private static void deleteFolders() throws IOException {
        Path rootPath = Paths.get(ROOT_FOLDER);
        if (!Files.exists(rootPath)) {
            System.out.println("Nothing to delete.");
            return;
        }

        System.out.println("🧹 Starting safe deletion of: " + rootPath.toAbsolutePath());
        long start = System.nanoTime();

        Files.walkFileTree(rootPath, new SimpleFileVisitor<>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                try {
                    Files.delete(file);
                } catch (IOException e) {
                    System.err.println("Failed to delete file: " + file + " (" + e.getMessage() + ")");
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                try {
                    Files.delete(dir);
                } catch (IOException e) {
                    System.err.println("Failed to delete directory: " + dir + " (" + e.getMessage() + ")");
                }
                return FileVisitResult.CONTINUE;
            }
        });

        long end = System.nanoTime();
        System.out.printf("✅ Deletion completed in %.2f seconds%n", (end - start) / 1_000_000_000.0);
    }
}
