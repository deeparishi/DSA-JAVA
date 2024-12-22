package com.deeparishi.javaapp.ZohoExam;

import java.util.HashSet;

public class RemoveDuplicateReverse {
    public static void main(String[] args) {
        String sb = "Geeks for Geeks";
        String s = sb.toLowerCase();
        HashSet<Character> a = new HashSet<>();
        StringBuilder st = new StringBuilder();

        for (int i = s.length() - 1; i >= 0; i--) {
            char cur = s.charAt(i);
            if (cur != ' ' && !a.contains(cur)) {
                a.add(cur);
                st.append(cur);

            }
        }
        System.out.println(st.toString());
    }
}
