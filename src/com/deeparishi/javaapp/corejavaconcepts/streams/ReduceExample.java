package com.deeparishi.javaapp.corejavaconcepts.streams;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

public class ReduceExample {

    public static void main(String[] args) {

        List<Sale> sales = List.of(
                new Sale("1", LocalDate.of(2024, Month.JANUARY, 25), 10),
                new Sale("2", LocalDate.of(2024, Month.FEBRUARY, 21), 22),
                new Sale("3", LocalDate.of(2024, Month.FEBRUARY, 5), 33)
        );

        Integer sum = sales
                .stream()
                .filter(sale -> sale.date().getMonth().equals(Month.FEBRUARY))
                .map(Sale::amount)
                .reduce(0, Integer::sum);

        System.out.println(sum);

    }

    record Sale(String product, LocalDate date, int amount) {}
}

