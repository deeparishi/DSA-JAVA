package com.deeparishi.javaapp.leetcode.string;

public class LicenseKeyFormatting {

    public static void main(String[] args) {

//        System.out.println(licenseKeyFormatting("5F3Z-2e-9-w",4));
        System.out.println(licenseKeyFormatting("2-5g-3-J",2));

    }

    public static String licenseKeyFormatting(String s, int k) {

        final StringBuilder sb = new StringBuilder();
        int count = 0;

        for (int i = s.length() - 1 ; i >= 0; i--) {

            char c = s.charAt(i);

            if(c == '-')
                continue;

            if(count == k){
                sb.append("-");
                count = 0;
            }

            sb.append(c);
            count++;
        }

        return sb.reverse().toString().toUpperCase();
    }
}
