package com.deeparishi.javaapp.leetcode.string;

public class MakeFancyString {

    // https://leetcode.com/problems/delete-characters-to-make-fancy-string/description/?envType=problem-list-v2&envId=string&difficulty=EASY

    public static void main(String[] args) {
//        System.out.println(makeFancyString("leeetcode"));   //leetcode
//        System.out.println(makeFancyString("aaabaaaa"));    // aabaa
//        System.out.println(makeFancyString("aab"));         //aab
        System.out.println(makeFancyString("aaabaaaa"));         //aabaa
    }

    public static String makeFancyString(String s) {

        StringBuilder builder = new StringBuilder();
        int count = 1;
        Character prev = s.charAt(0);
        builder.append(prev);

        for (int i = 1; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (prev == s.charAt(0))
                continue;
            if (ch == prev) {
                count++;
                if (count < 3) {
                    builder.append(ch);

                }
            } else {
                prev = ch;
                builder.append(ch);
                count = 1;

            }
        }

        return builder.toString();

    }
}
