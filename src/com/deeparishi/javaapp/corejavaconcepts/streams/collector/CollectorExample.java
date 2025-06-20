package com.deeparishi.javaapp.corejavaconcepts.streams.collector;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;

public class CollectorExample {

    public static void main(String[] args) {

        List<String> words = Arrays.asList("apple", "", "banana", "kiwi", "pear");

        Collector<String, StringJoiner, String> joinerCollector = Collector.of(
                () -> new StringJoiner(", "),
                (sj, str) -> {
                    if (str != null && str.length() > 3) {
                        sj.add(str);
                    }
                },
                StringJoiner::merge,
                StringJoiner::toString
        );

        String result = words.stream().collect(joinerCollector);
        System.out.println(result);
    }
}

/*
 * Collector Params
 Collector.of(
     supplier,      // Creates the mutable container
     accumulator,   // Adds each element
     combiner,      // Combines two containers (for parallel streams)
     finisher       // Converts the container to final result
 )

 */