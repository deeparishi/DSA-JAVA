package com.deeparishi.javaapp.leetcode;

//https://leetcode.com/problems/reverse-prefix-of-word

public class ReversePrefix {

    public static void main(String[] args) {

        System.out.println(reversePrefix("abcdefd", 'd'));
    }

    public static String reversePrefix(String word, char ch) {


        int index = 0;

        for (int i=0; i<word.length(); i++){
            if(ch == word.charAt(i)) {
                index = i;
                break;
            }
        }

        StringBuilder builder = new StringBuilder();

        String str = word.substring(0, index+1);

        builder.append(str).reverse();

        for (int i = index; i <word.length() ; i++) {
                builder.append(word.charAt(i));
        }

        return builder.toString();


    }
}
