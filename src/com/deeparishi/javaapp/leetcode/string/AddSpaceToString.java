package com.deeparishi.javaapp.leetcode.string;

//https://leetcode.com/problems/adding-spaces-to-a-string/?envType=daily-question&envId=2024-12-03

public class AddSpaceToString {

    public static void main(String[] args) {
        System.out.println(addSpaces("LeetcodeHelpsMeLearn", new int[]{8, 13, 15}));
    }

    public static String addSpaces(String s, int[] spaces) {

        StringBuilder builder = new StringBuilder();
        int spaceIdx = 0;

        for (int i = 0; i < s.length(); i++) {
            if(spaceIdx < spaces.length && i == spaces[spaceIdx]){
                builder.append(" ");
                spaceIdx++;
            }
            builder.append(s.charAt(i));
        }

        return builder.toString();
    }
}
