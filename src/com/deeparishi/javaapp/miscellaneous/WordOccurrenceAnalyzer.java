package com.deeparishi.javaapp.miscellaneous;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

public class WordOccurrenceAnalyzer {

    private static final String FILE_PATH = "D:/Personal/test";

    public static void main(String[] args) throws IOException {
        System.out.println(findNthOccurrence(3, false));
    }

    /**
     * @author Deeparishi
     * @since 2019
     * @link findNthOccurrence
     * {@C}
     **/

    public static List<String> findNthOccurrence(int rank, boolean highest) throws IOException {

        Map<String, Long> wordMap = new HashMap<>();
        List<Path> filePaths = Files.walk(Paths.get(FILE_PATH))
                .filter(Files::isRegularFile)
                .toList();

        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        filePaths.forEach(file -> {
            executor.execute(() -> {
                try {
                    Files.lines(file)
                            .flatMap(line -> Arrays.stream(line.split("\\W+")))
                            .filter(word -> !word.isEmpty())
                            .forEach(word -> {
                                System.out.println(Thread.currentThread().getName());
                                wordMap.merge(word, 1L, Long::sum);
                            });
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        });
        executor.shutdown();

        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
                throw new RuntimeException("Executor did not terminate in time.");
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException("Executor interrupted.", e);
        }

        Map<Long, List<String>> wordFrequency = wordMap.entrySet().stream()
                .collect(Collectors.groupingBy(
                        Map.Entry::getValue,
                        Collectors.mapping(Map.Entry::getKey, Collectors.toList())
                ));

        List<Long> sortedFrequencies = new ArrayList<>(wordFrequency.keySet());
        sortedFrequencies.sort(highest ? Comparator.reverseOrder() : Comparator.naturalOrder());

        if (rank <= 0 || rank > sortedFrequencies.size())
            throw new RuntimeException("Index Out of Bound");

        long targetRank = sortedFrequencies.get(rank - 1);
        return wordFrequency.get(targetRank);
    }
}
