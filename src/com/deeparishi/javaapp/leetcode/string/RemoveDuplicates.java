package com.deeparishi.javaapp.leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicates {

    public static void main(String[] args) {
        System.out.println(removeDuplicates("Java1234"));   // Output: Javb1234
        System.out.println(removeDuplicates("Python1223")); // Output: Python1234
        System.out.println(removeDuplicates("aBuzZ9900"));  // Output: aBuzC9012
    }

    public static String removeDuplicates(String letter) {
        Set<Character> seen = new HashSet<>();
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < letter.length(); i++) {
            char ch = letter.charAt(i);
            char lowerCh = Character.toLowerCase(ch);

            if (!seen.contains(lowerCh)) {
                seen.add(lowerCh);
                builder.append(ch);
            } else {

                if (Character.isDigit(ch)) {
                    char replacement = ch;
                    do {
                        replacement = nextDigit(replacement);
                    } while (seen.contains(replacement));
                    seen.add(replacement);
                    builder.append(replacement);
                } else if (Character.isUpperCase(ch)) {
                    char replacement = ch;
                    do {
                        replacement = nextUppercase(replacement);
                    } while (seen.contains(Character.toLowerCase(replacement)));
                    seen.add(Character.toUpperCase(replacement));
                    builder.append(replacement);

                } else if (Character.isLowerCase(ch)) {
                    char replacement = ch;
                    do {
                        replacement = nextLowercase(replacement);
                    } while (seen.contains(Character.toLowerCase(replacement)));
                    seen.add(Character.toLowerCase(replacement));
                    builder.append(replacement);

                }

            }
        }

        return builder.toString();
    }

    private static char nextLowercase(char ch) {
        if (ch == 'z') return 'a';
        return (char) (ch + 1);
    }

    private static char nextUppercase(char ch) {
        if (ch == 'Z') return 'A';
        return (char) (ch + 1);
    }

    private static char nextDigit(char ch) {
        return ch == '9' ? '0' : (char) (ch + 1);
    }
}
