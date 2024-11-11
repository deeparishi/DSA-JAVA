package com.deeparishi.javaapp.leetcode.trie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LexicographicalNumber {

    public static void main(String[] args) {

        System.out.println(lexicalOrder(2));
    }

    static List<Integer> lexicalOrder(int n) {

        List<String> v = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
          v.add(String.valueOf(i));
        }

        v.sort(String::compareTo);

        List<Integer> result = new ArrayList<>();
        for (String str : v) {
            result.add(Integer.parseInt(str));
        }

        return result;
    }
}
