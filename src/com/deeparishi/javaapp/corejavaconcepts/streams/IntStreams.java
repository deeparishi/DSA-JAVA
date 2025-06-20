package com.deeparishi.javaapp.corejavaconcepts.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class IntStreams {

    public static void main(String[] args) {
        range();
        rangeClosed();
        findEven();
        findDistinctElementInArray();
        generateDoubleArrayOrList();
        twoDimensionInStreams();
        sumRangeIdx();
    }

    public static void range() {

        System.out.println("-----------------range---------------------");
        IntStream.range(0, 5)
                .forEach(System.out::println);

        IntStream.range(0, 5)
                .forEach(i -> System.out.print(i + " "));
        System.out.println();
    }

    public static void rangeClosed() {
        System.out.println("-----------------rangeClosed---------------------");
        IntStream.rangeClosed(0, 5)
                .forEach(System.out::println);
    }

    public static void findEven() {

        System.out.println("-----------------findEven()------------------");
        List<Integer> list = IntStream.range(0, 10)
                .filter(i -> i % 2 == 0)
                .boxed()
                .toList();

        System.out.println("Even " + list);

    }

    public static void twoDimensionInStreams() {

        System.out.println("--------------twoDimensionInStreams--------------");
        int[][] matrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        List<Integer> twoD = Arrays.stream(matrix)
                .flatMapToInt(arr -> Arrays.stream(arr))
                .boxed()
                .toList();

        System.out.println(twoD);
    }

    public static void sumRangeIdx () {
        System.out.println("------------sumRangeIdx---------------");
        int sum = IntStream.range(0, 20)
                .reduce(0, (a, b) -> a + b);

        System.out.println(sum);

    }

    public static void generateDoubleArrayOrList() {

        System.out.println("--------------generateDoubleArrayOrList---------------------");
        double[] doubles = IntStream.range(0, 20)
                .mapToDouble(e -> (double) e)
                .toArray();

        List<Double> doubleList = IntStream.range(0, 10)
                .mapToDouble(e -> (double) e)
                .boxed()
                .toList();

        System.out.println("Array -> " + Arrays.toString(doubles));
        System.out.println("List -> " + doubleList);
    }

    public static void findDistinctElementInArray() {

        System.out.println("-------------------findDistinctElementInArray-------------------");
        int[] arr = {3, 4, 5, 4, 7, 7, 0};

        int[] distinct = IntStream.of(arr)
                .distinct()
                .toArray();

        System.out.println("Distinct " + Arrays.toString(distinct));
    }

}
