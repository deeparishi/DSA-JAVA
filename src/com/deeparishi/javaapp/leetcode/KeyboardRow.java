package com.deeparishi.javaapp.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class KeyboardRow {

    public static void main(String[] args) {
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        String[] result = findWords(words);

        for (String word : result) {
            System.out.println(word);
        }
    }

    public static String[] findWords(String[] words) {

        List<Character> firstRow = Arrays.asList('q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p');
        List<Character> secondRow = Arrays.asList('a', 's', 'd', 'f', 'g', 'h', 'j', 'k', 'l');
        List<Character> thirdRow = Arrays.asList('z', 'x', 'c', 'v', 'b', 'n', 'm');

        List<String> output = new ArrayList<>();

        for (String word : words) {
            if (isMatching(word.toLowerCase(), firstRow) || isMatching(word.toLowerCase(), secondRow)
                    || isMatching(word.toLowerCase(),thirdRow))
                output.add(word);
        }

        return output.toArray(new String[0]);

    }

    private static boolean isMatching(String word, List<Character> firstRow) {

        for (char c : word.toCharArray()) {
            if (!firstRow.contains(c)) {
                return false;
            }
        }

        return true;

    }
}
