package com.deeparishi.javaapp.leetcode.string;

public class IntegerToRoman {

    public static void main(String[] args) {
        System.out.println(intToRomanV2(3749));
        System.out.println(intToRomanV2(58));
        System.out.println(intToRomanV2(1994));
    }


    public static String intToRomanV2(int num) {

        StringBuilder result = new StringBuilder();
        int a = helperLoop(num, result, "M", 1000);
        int b = helperLoop(a, result, "CM", 900);
        int c = helperLoop(b, result, "D", 500);
        int d = helperLoop(c, result, "CD", 400);
        int e = helperLoop(d, result, "C", 100);
        int f = helperLoop(e, result, "XC", 90);
        int g = helperLoop(f, result, "L", 50);
        int h = helperLoop(g, result, "XL", 40);
        int i = helperLoop(h, result, "X", 10);
        int j = helperLoop(i, result, "IX", 9);
        int k = helperLoop(j, result, "V", 5);
        int l = helperLoop(k, result, "IV", 4);
        helperLoop(l, result, "I", 1);
        return result.toString();
    }

    public static int helperLoop(int val, StringBuilder appender, String append, int until) {
        while (val >= until) {
            val -= until;
            appender.append(append);
        }

        return val;
    }

    public static String intToRomanV1(int num) {
        StringBuilder op = new StringBuilder();
        String[] romans = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        int ptr = 0;
        int val = num;

        while (val > 0) {
            if (val >= numbers[ptr]) {
                op.append(romans[ptr]);
                val -= numbers[ptr];
            } else {
                ptr++;
            }
        }

        return op.toString();
    }
}
