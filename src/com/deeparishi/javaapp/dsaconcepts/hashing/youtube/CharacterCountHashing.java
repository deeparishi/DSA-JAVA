package com.deeparishi.javaapp.dsaconcepts.hashing.youtube;

import java.util.HashMap;
import java.util.Map;

public class CharacterCountHashing {

    private final static int[] chars = new int[26];

    private final static Map<Character, Integer> charMap = new HashMap<>();


    public static void main(String[] args) {
        System.out.println(characterCountUsingMap("abcdabefc", 'a'));
    }

    // Using Array
    public static void hashTheCharacter(String input){

        for (int i = 0; i < input.length(); i++) {
            int val = input.charAt(i) - 'a';
            chars[val]++;
        }
    }

    public static int characterCount(String input, char a){
        hashTheCharacter(input);
        return chars[a - 'a'];
    }

    // Using Map
    public static void hashTheCharacterUsingMap(String input){

        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            charMap.putIfAbsent(ch, 0);
            charMap.put(ch, charMap.getOrDefault(ch, 0)+1);
//            charMap.merge(ch,1, Integer::sum);
        }
    }

    public static int characterCountUsingMap(String input, char a){
        hashTheCharacterUsingMap(input);
        return charMap.getOrDefault(a,0);
    }
}
