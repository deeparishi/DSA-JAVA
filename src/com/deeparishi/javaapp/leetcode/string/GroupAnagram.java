package com.deeparishi.javaapp.leetcode.string;

import java.util.*;

public class GroupAnagram {

    public static void main(String[] args) {
        groupAnagram(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }

    public static void groupAnagram(String[] values) {

        Map<String, List<String>> lookUp = new HashMap<>();

        for (String val : values) {
            char[] chars = val.toCharArray();
            Arrays.sort(chars);
            String str = new String(chars);
            lookUp.computeIfAbsent(str, _ -> new ArrayList<>()).add(str);
        }

        System.out.println(lookUp.values());
    }


}
