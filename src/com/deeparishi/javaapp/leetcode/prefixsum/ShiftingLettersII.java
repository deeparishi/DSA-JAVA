package com.deeparishi.javaapp.leetcode.prefixsum;

// https://leetcode.com/problems/shifting-letters-ii/

public class ShiftingLettersII {

    public static void main(String[] args) {

        int[][] shifts = new int[][] {
                {0, 1, 0},
                {1, 2, 1},
                {0, 2, 1}
        };

        System.out.println(shiftingLettersV2("abc", shifts));
    }

    public static String shiftingLetters(String s, int[][] shifts) {

        StringBuilder builder = new StringBuilder(s);

        for (int[] shift : shifts) {
            int from = shift[0];
            int to = shift[1];
            int direction = shift[2];
            for (int i = from; i <= to; i++) {
                char ch = builder.charAt(i);
                if (direction == 0) {
                    // Move Backward
                    ch = (char) ((ch - 'a' - 1 + 26) % 26 + 'a');
                } else if (direction == 1) {
                    // Move Forward
                    ch = (char) ((ch - 'a' + 1) % 26 + 'a');
                }
                builder.setCharAt(i, ch);
            }
        }

        return builder.toString();
    }


    public static String shiftingLettersV2(String s, int[][] shifts) {

        int n = s.length();
        int[] shiftAmount = new int[n + 1]; // Extra space to handle range end efficiently

        for (int[] shift : shifts) {
            int from = shift[0];
            int to = shift[1];
            int direction = shift[2];

            shiftAmount[from] += (direction == 1) ? 1 : -1; // Increment or decrement
            shiftAmount[to + 1] += (direction == 1) ? -1 : 1; // Reverse effect after 'to'
        }

        int netShift = 0;
        for (int i = 0; i < n; i++) {
            netShift += shiftAmount[i];
            shiftAmount[i] = netShift;
        }

        StringBuilder builder = new StringBuilder(s);
        for (int i = 0; i < n; i++) {
            int shift = shiftAmount[i] % 26; // Modulo 26 to handle full cycles
            char ch = builder.charAt(i);
            ch = (char) ((ch - 'a' + shift + 26) % 26 + 'a');
            builder.setCharAt(i, ch);
        }

        return builder.toString();
    }

}