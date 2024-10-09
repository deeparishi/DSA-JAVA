package com.deeparishi.javaapp.old.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        List<List<Integer>> pascal = generate(5);
        System.out.println(pascal);
    }
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList();

        for (int i = 0; i < numRows; i++) {
            List<Integer> rows = new ArrayList();
            for (int j = 0; j <= i; j++) {
                if (i == 0 || j == i) {
                    rows.add(1);
                } else {
                    List<Integer> previousRow = pascal.get(i - 1);
                    int sum = (j == 0 ? 0 : previousRow.get(j - 1)) + previousRow.get(j);
                    rows.add(sum);
                }
            }
            pascal.add(rows);
        }
        return pascal;
    }

}

