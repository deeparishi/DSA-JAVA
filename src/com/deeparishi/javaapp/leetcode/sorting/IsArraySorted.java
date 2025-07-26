package com.deeparishi.javaapp.leetcode.sorting;

import java.util.ArrayList;
import java.util.List;

public class IsArraySorted {

    public static void main(String[] args) {

        System.out.println(isSorted(new ArrayList<>(List.of(1, 2, 3, 4, 5))));
        System.out.println(isSorted(new ArrayList<>(List.of(1, 2, 1, 4, 5))));
        System.out.println(isSorted(new ArrayList<>(List.of(1, 9, 6, 8, 5, 0))));
        System.out.println(isSorted(new ArrayList<>(List.of(3, 4, 5, 1, 2))));
    }

    public static boolean isSortedBruteForce(ArrayList<Integer> values) {

        for (int i = 0; i < values.size(); i++) {
            for (int j = i + 1; j < values.size(); j++) {
                if (values.get(i) > values.get(j))
                    return false;
            }
        }

        return true;
    }

    public static boolean isSorted(ArrayList<Integer> values) {

        for (int i = 1; i < values.size(); i++) {
          if (values.get(i) < values.get(i - 1))
              return false;
        }

        return true;
    }
}
