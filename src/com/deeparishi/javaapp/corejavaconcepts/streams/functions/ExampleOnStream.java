package com.deeparishi.javaapp.corejavaconcepts.streams.functions;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ExampleOnStream {
    public static void main(String[] args) {

        singleFunction();
    }

    private static void singleFunction() {

        List<Person> people = Arrays.asList(
                new Person("Alice", 30),
                new Person("Bob", 25),
                new Person("Charlie", 35)
        );

        Function<Person, String> function = (p) -> {
            if (p.age <= 20) return "Less than 20";
            else if (p.age <= 40) return "Between 20 - 40";
            return "Above 40";
        };

        // Single Grouping
        Map<String, List<Person>> personMap = people
                .stream()
                .collect(Collectors.groupingBy(function, TreeMap::new, Collectors.toList()));

        // Multi Grouping
        Map<String, TreeMap<Character, List<Person>>> multiMap = people
                .stream()
                .collect(Collectors.groupingBy(function,
                                HashMap::new,
                                Collectors.groupingBy(
                                        p -> p.name.charAt(0),
                                        TreeMap::new,
                                        Collectors.toList()
                                )
                        )
                );

        System.out.println(personMap);
        System.out.println(multiMap);
    }

    private static void biFunction() {

    }
}
class Person {
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    String name;
    int age;
}
