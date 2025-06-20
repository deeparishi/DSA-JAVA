package com.deeparishi.javaapp.corejavaconcepts.streams.functions;

import java.util.function.BiFunction;
import java.util.function.Function;

public class FunctionExamples {

    public static void main(String[] args) {
        biFunctionWithThen();
    }

    public void singleFunction() {
        Function<Integer, Integer> function = (a) -> a * 2;
        System.out.println(function.apply(22));
    }

    public static void biFunction() {
        BiFunction<Integer, Integer, String> biFunction = (a, b) -> {
            int i = a + b;
            return "Output is " + i;
        };
        System.out.println(biFunction.apply(90, 90));
    }

    public static void biFunctionWithThen() {

        BiFunction<Integer, Integer, Integer> biFunction = (a, b) -> a + b + 1;
        Function<Integer, Integer> sum = (a) -> a + 25;
        Function<Integer, String>  display = (a) -> "Output is " + a;

        BiFunction<Integer, Integer, String> output = biFunction
                .andThen(sum)
                .andThen(display);

        System.out.println(output.apply(22, 33));

    }
}
