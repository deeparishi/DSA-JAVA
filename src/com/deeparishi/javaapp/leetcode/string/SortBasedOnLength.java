package com.deeparishi.javaapp.leetcode.string;

// Neuralm Interview Question 13-07-2025 for 2YOE

import java.util.*;
import java.util.stream.Collectors;

    /*
        Input: If I was a old man to walk alone How range do I walking now?
        Output: [I, a, I, If, to, do, was, old, man, how, now, alone, range]
     */

public class SortBasedOnLength {

    public static void main(String[] args) {
        System.out.println(splitV3("If I was a old man to walk alone How range do I walking now ??????"));
    }

    public static List<String> splitV3(String sentence) {

        String[] words = sentence.split("\\s+");

        Map<Integer, Integer> lengthCount = new HashMap<>();

        for (String word : words) {
            int len = word.length();
            lengthCount.put(len, lengthCount.getOrDefault(len, 0) + 1);
        }

        Map<Integer, List<String>> grouped = new TreeMap<>();

        for (String word : words) {
            int len = word.length();
            if (lengthCount.get(len) > 1)
                grouped.computeIfAbsent(len, _ -> new ArrayList<>()).add(word);
        }

        List<String> result = grouped
                .entrySet()
                .stream()
                .flatMap(group -> group.getValue().stream())
                .toList();
        System.out.println(result);

        return result;
    }

    public static List<String>  splitOptimal(String sentence) {

        String[] words = sentence.split(" ");

        Map<Integer, Long> lookup = Arrays.stream(words)
                .collect(Collectors.groupingBy(String::length, Collectors.counting()));

        List<String> sortedWords = Arrays.stream(words)
                .filter(word -> lookup.get(word.length()) > 1)
                .toList();

        System.out.println(sortedWords);
        System.out.println();

        return sortedWords;
    }

    public static List<String>  split(String sentence) {

        String[] words = sentence.split(" ");

        Map<Integer, List<String>> lookup = new HashMap<>();

        for (String word : words)
            lookup.computeIfAbsent(word.length(), _ -> new ArrayList<>()).add(word);

        List<String> sortedWords = new ArrayList<>();

        for (Map.Entry<Integer, List<String>> entry : lookup.entrySet()) {
            if (entry.getValue().size() > 1) {
                sortedWords.addAll(entry.getValue());
            }
        }

        System.out.println(sortedWords);
        return sortedWords;
    }
}
