package com.deeparishi.javaapp.leetcode;

public class AddBinary {

    public static void main(String[] args) {

        System.out.println(addBinary("11", "1"));
    }

    public static String addBinary(String a, String b) {

        StringBuilder stringBuilder = new StringBuilder();
        int carry = 0;
        int lengthOne = a.length()-1;
        int lengthTwo = b.length()-1;

        while (lengthOne >= 0 || lengthTwo >= 0 || carry == 1){

            if(lengthOne >= 0)
               carry += a.charAt(lengthOne--) - '0';

            if(lengthTwo >= 0)
                carry += b.charAt(lengthTwo--) - '0';

            stringBuilder.append(carry % 2);

            carry /= 2;
        }

        return stringBuilder.reverse().toString();


    }
}
