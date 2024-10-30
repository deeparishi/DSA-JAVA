package com.deeparishi.javaapp.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

public class PrintPattern {

    public static void main(String[] args) {
        List<Integer>  r = pattern(4);
        System.out.println(r);
    }

    static List<Integer> pattern(int n){
        if(n == 0) return List.of(0);
        List<Integer> list = new ArrayList<>();
        generatePattern(n, n, list, true);
        return list;
    }

    private static void generatePattern(int current, int n, List<Integer> result, boolean decreasing) {
        result.add(current);
        if (current - 5 < 0 && current == n)  return;
        if (decreasing) generatePattern(current - 5, n, result, current - 5 > 0);
        else generatePattern(current + 5, n, result, false);
    }

}
