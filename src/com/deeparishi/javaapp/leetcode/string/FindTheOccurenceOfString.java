package com.deeparishi.javaapp.leetcode.string;

public class FindTheOccurenceOfString {

    public static void main(String[] args) {

        int i = strStr("leetcode", "leeto");
        System.out.println(i);
    }

    public static int strStr(String haystack, String needle) {

        int count = -1;
        int needleLen = needle.length()-1;

        for(int i=0; i<haystack.length(); i++){

            for(int j=0; j<needleLen; j++){

                if(haystack.charAt(i)==needle.charAt(j)){
                    String sub = haystack.substring(i,needleLen+i);
                    if(sub.equals(needle)){
                        count = i;
                        break;
                    }
                }
            }

            if(count!=-1){
                break;
            }
        }

        return 0;
    }
}
