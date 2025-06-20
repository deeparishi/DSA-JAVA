package com.deeparishi.javaapp.corejavaconcepts.collections;


import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class TreeSets {

    public static void main(String[] args) {


        List<Integer> integers = List.of(2, 9, 23, 56, 5, 8);
        TreeSet<Integer> sortedInt = new TreeSet<>((a, b) -> b - a); // Descending order
        sortedInt.addAll(integers);

        System.out.println(sortedInt.floor(0)); // It'll return the nearby <= given element from set, if not then null
        System.out.println(sortedInt.ceiling(55)); // It'll return nearby >= given element from set, if not then null;
        System.out.println(sortedInt);

        System.out.println();
        System.out.println("Headset");
        System.out.println(sortedInt.headSet(23)); // It'll return the element greater than given element
        System.out.println(sortedInt.headSet(23, true)); // It'll return the element greater than given element

        System.out.println();
        System.out.println("TailSet");
        System.out.println(sortedInt.tailSet(23)); // It'll return the element from 23 and lesser elements
        System.out.println(sortedInt.tailSet(23, false)); // It'll return the element from 23 and lesser elements & boolean for from element need to include or not

        System.out.println();
        System.out.println("subset");
        System.out.println(sortedInt.subSet(23, 2));


        Comparator<? super Integer> comparator = sortedInt.comparator();
        System.out.println(comparator);


    }
}
