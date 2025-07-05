package com.deeparishi.javaapp.corejavaconcepts.streams;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Streams {


    public static void main(String[] args) {

//        findIntersection();
//        numberStartingWith(1);
//        findDuplicateElements(Arrays.asList(8,3,3,4,5,4,6,7,7,5));
//        findTotalNumOfElementsInList();

    }

    private static void findTotalNumOfElementsInList() {

        System.out.println("-------findTotalNumOfElementsInList------");
        List<Integer> integerList = List.of(2, 2, 4, 5, 6, 7, 4, 3, 5, 21, 133, 54, 44);
        System.out.println("Using List " + integerList.stream().count());
        ;

        int[] arr = {1, 3, 5, 21, 133, 5};
        System.out.println("using array " + IntStream.of(arr).count());
    }

    public static void findIntersection() {

        System.out.println();
        System.out.println("------------FInd Intersection ------------------");
        int[] a = {2, 5, 10, 12};
        int[] b = {7, 8, 10, 12};

        int[] intersected = Arrays.stream(a)
                .filter(x -> Arrays.stream(b).anyMatch(y -> y == x))
                .distinct()
                .toArray();

        IntStream.of(intersected).forEach(System.out::println);
    }

    public static void numberStartingWith(int num) {

        System.out.println();
        System.out.println("-----------Number starting with--------");

        int[] arr = {12, 23, 134, 11, 67, 19, 145};

        System.out.println("Using Array");
        IntStream.of(arr)
                .filter(i -> Integer.toString(i).startsWith(String.valueOf(num)))
                .boxed()
                .forEach(i -> System.out.print(i + " "));

        List<Integer> integerList = List.of(12, 23, 134, 11, 67, 19, 145);

        System.out.println();
        System.out.println("Using List ");
        List<Integer> removedList = integerList.stream()
                .map(Object::toString) // Convert to String
                .filter(x -> x.startsWith(String.valueOf(num))) // Validation
                .map(Integer::valueOf) // Convert to Integer
                .toList();

        System.out.println(removedList);
    }

    public static void findDuplicateElements(List<Integer> integerList) {

        System.out.println();
        System.out.println("-----------Find Duplicate Elements--------");
        Set<Integer> set = new HashSet<>();

        integerList.stream()
                .filter(val -> !set.add(val))
                .forEach(val -> System.out.print(val + " "));
        System.out.println();
    }

    public static void moveZerosToEndWithStreams() {
        moveZerosToEndWithStreams(new int[]{0, 1, 0, -1, 0, 4});
        moveZerosToEndWithStreams(new int[]{0, 0, 0, 0});
        moveZerosToEndWithStreams(new int[]{1, 2, 3, 4});
        moveZerosToEndWithStreams(new int[]{});
        moveZerosToEndWithStreams(new int[]{0});
        moveZerosToEndWithStreams(new int[]{1});
        moveZerosToEndWithStreams(new int[]{0, 1, 0, 0, 1});
        moveZerosToEndWithStreams(new int[]{2, 0, 2, 0, 2});
        moveZerosToEndWithStreams(new int[]{0, 0, 1, 0, 2, 3});
    }

    public static void moveZerosToEndWithStreams(int[] arr) {

        List<Integer> numbers = Arrays.stream(arr)
                .boxed()
                .toList();

        List<Integer> movedZeros = Stream.concat(
                numbers.stream().filter(n -> n > 0), numbers.stream().filter(n -> n == 0)
        ).toList();

        System.out.println(movedZeros);
    }
}
