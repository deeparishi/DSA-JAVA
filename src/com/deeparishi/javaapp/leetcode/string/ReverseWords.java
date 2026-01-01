package com.deeparishi.javaapp.leetcode.string;

//https://leetcode.com/problems/reverse-words-in-a-string/description/?envType=study-plan-v2&envId=top-interview-150

public class ReverseWords {

    public static void main(String[] args) {
        System.out.println(reverseWordsV2("the sky is blue"));
    }

    public static String reverseWordsV2(String s) {
        char[] chars = s.toCharArray();
        int n = chars.length;

        reverse(chars, 0, n - 1);

        StringBuilder ans = new StringBuilder();
        int i = 0;

        while (i < n) {

            if (chars[i] == ' ') {
                i++;
                continue;
            }


            int start = i;

            while (i < n && chars[i] != ' ') {
                i++;
            }

            int end = i - 1;


            reverse(chars, start, end);


            if (!ans.isEmpty()) {
                ans.append(' ');
            }
            ans.append(chars, start, end - start + 1);
        }

        return ans.toString();
    }

    private static void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }

    public static String reverseWordsV1(String s) {
        String[] split = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if (!split[i].isEmpty()) {
                builder.append(split[i]).append(" ");
            }
        }

        return builder.toString().trim();
    }
}