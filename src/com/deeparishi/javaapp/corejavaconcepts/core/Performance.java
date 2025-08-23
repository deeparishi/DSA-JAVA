package com.deeparishi.javaapp.corejavaconcepts.core;

import java.util.*;

public class Performance {

    final static List<Integer> values = new ArrayList<>();
    final static Map<String, Long> winnerLookup = new HashMap<>();

    static {
        for (int i = 0; i < 90000; i++) {
            values.add(i);
        }
    }

    public static void main(String[] args) throws InterruptedException {


        Loop forLoop = () -> {
            long sum = 0;
            for (int i = 0; i < values.size(); i++) {
                sum += values.get(i);
            }
            return sum;
        };

        Loop forEachLoop = () -> {
            long a = 0;
            for (Integer value : values) {
                a += value;
            }
            return a;
        };

        Loop streams = () -> values.stream()
                .mapToLong(Integer::longValue)
                .sum();

        Loop parallelStream = () -> values.parallelStream()
                .mapToLong(Integer::longValue)
                .sum();


        awakeJVM(forLoop, forEachLoop, parallelStream, streams);

        performTest("For Loop", forLoop);
        performTest("For Each Loop", forEachLoop);
        performTest("Streams", streams);
        performTest("parallel streams", parallelStream);

        findWinner();
    }

    private static void awakeJVM(Loop forLoop, Loop forEachLoop, Loop parallelStream, Loop streams) {
        for (int i = 0; i < 5; i++) {
            forLoop.sum();
            forEachLoop.sum();
            parallelStream.sum();
            streams.sum();
        }
    }

    static void performTest(String label, Loop loop) {
        long start = System.currentTimeMillis();
        long sum = loop.sum();
        long end = System.currentTimeMillis();
        long diff = end - start;
        winnerLookup.put(label, diff);

        System.out.println(STR."Result for \{label} :\{sum} and Time taken is :\{diff}");

    }

    static void findWinner() {
        Optional<Map.Entry<String, Long>> fastest = winnerLookup.entrySet()
                .stream()
                .min(Map.Entry.comparingByValue());

        System.out.println();
        fastest.ifPresent(entry ->
                System.out.println(STR."Fastest is: \{entry.getKey()} with time \{entry.getValue()} ms")
        );

    }

}

interface Loop {

    long sum();

}