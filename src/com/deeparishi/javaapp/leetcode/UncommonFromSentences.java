package com.deeparishi.javaapp.leetcode;

import java.util.*;

public class UncommonFromSentences {

    public static void main(String[] args) {

        String [] result = uncommonFromSentences("this apple is sweet", "this apple is sour");
        System.out.println(Arrays.stream(result).toList());
    }


    public static String[] uncommonFromSentences(String s1, String s2) {

        String combined = STR."\{s1} \{s2}";
        String[] split = combined.split(" ");

        Map<String, Integer> words = new HashMap<>();

        for (String s : split) {
            words.put(s, words.getOrDefault(s, 0) + 1);
        }

        List<String> uncommonWords = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : words.entrySet()){

            if(entry.getValue() == 1)
                uncommonWords.add(entry.getKey());
        }

        return uncommonWords.toArray(new String[0]);
    }
}
