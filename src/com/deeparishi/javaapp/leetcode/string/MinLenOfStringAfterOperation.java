package com.deeparishi.javaapp.leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class MinLenOfStringAfterOperation {

    public static void main(String[] args) {
        System.out.println(minimumLength("abaacbcbb"));
        System.out.println(minimumLength("aa"));
        System.out.println(minimumLength("ucvbutgkohgbcobqeyqwppbxqoynxeuuzouyvmydfhrprdbuzwqebwuiejoxsxdhbmuaiscalnteocghnlisxxawxgcjloevrdcj"));
    }

    public static int minimumLength(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        int count = 0;

        for (Integer val : map.values()) {
            if (val % 2 == 0) count += 2;
            else count += 1;
        }

        return count;
    }


    public static int minimumLengthWontWork(String s) {

        StringBuilder builder = new StringBuilder(s);

        for (int pos = 1; pos < s.length(); pos++) {
            char ch = s.charAt(pos);
            String left = builder.substring(0, pos - 1);
            String right = builder.substring(pos + 1, builder.length());
            int leftIdx = left.indexOf(ch);
            int rightIdx = right.indexOf(ch);
            builder.deleteCharAt(leftIdx);
            builder.deleteCharAt(rightIdx);
        }

        return builder.length();
    }

        public static int minimumLengthNotWorking(String s) {

        Map<Character, Integer> map = new HashMap<>();

        for(char ch : s.toCharArray())
            map.put(ch, map.getOrDefault(ch, 0) + 1);

        int count = 0;

        for (Integer val : map.values()) {
            if (val < 3) {
                count += val;
            } else {
                int mod = val % 3;
                int div = (val - mod) / 3;
                count += mod;
                count += div;

            }
        }

        return count;
    }
}
