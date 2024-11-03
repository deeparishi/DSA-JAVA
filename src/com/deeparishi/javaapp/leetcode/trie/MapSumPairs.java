package com.deeparishi.javaapp.leetcode.trie;

//https://leetcode.com/problems/map-sum-pairs/description/?envType=problem-list-v2&envId=trie

import java.util.HashMap;
import java.util.Map;

public class MapSumPairs {

    public static void main(String[] args) {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        System.out.println(mapSum.sum("ap"));
        mapSum.insert("app", 2);
        mapSum.insert("apple", 2);
        System.out.println(mapSum.sum("ap"));
    }

}

class MapSum {

    Map<String, Integer> map;

    Map<String, Integer> score;

    public MapSum(){
        map = new HashMap<>();
        score = new HashMap<>();
    }

    public void insert(String key, int value) {

        int d = value - map.getOrDefault(key, 0);
        map.put(key, value);

        StringBuilder w = new StringBuilder();

        for (char ch : key.toCharArray()){
            w.append(ch);
            score.put(w.toString(), score.getOrDefault(w.toString(),0)+d);
        }

    }

    public int sum(String ap) {

        return score.getOrDefault(ap, score.getOrDefault(ap, 0));
    }
}