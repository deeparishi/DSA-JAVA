package com.deeparishi.javaapp.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        int len = lengthOfLongestSubstring("pwwkew");
        System.out.println(len);
    }
        static int lengthOfLongestSubstring(String s) {

            int start = 0;
            int end = 0;
            Set<Character> element = new HashSet<>();
            int maxLen = Math.min(s.length(), 1);

            while(end<s.length()){
                char a = s.charAt(end);
                while(element.contains(a)){
                    element.remove(s.charAt(start));
                    start+=1;
                }
                element.add(a);
                int size = end-start +1;
                maxLen = Math.max(maxLen,size);
                end+=1;
            }

            return maxLen;

        }
    }

