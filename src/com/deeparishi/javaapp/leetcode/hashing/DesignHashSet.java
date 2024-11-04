package com.deeparishi.javaapp.leetcode.hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class DesignHashSet {

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();
        myHashSet.add(1);      // set = [1]
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(1); // return True
        myHashSet.contains(3); // return False, (not found)
        myHashSet.add(2);      // set = [1, 2]
        myHashSet.contains(2); // return True
        myHashSet.remove(2);   // set = [1]
        myHashSet.contains(2); // return False, (already removed)
    }
}

class MyHashSet {

    private static final int NUM_BUCKETS = 1000;
    private List<LinkedList<Integer>> buckets;

    public MyHashSet() {
        buckets = new ArrayList<>(NUM_BUCKETS);
        for (int i = 0; i < NUM_BUCKETS; i++) {
            buckets.add(new LinkedList<>());
        }
    }

    private int getHash(int key) {
        return key % NUM_BUCKETS;
    }

    public void add(int key) {
        int hash = getHash(key);
        LinkedList<Integer> bucket = buckets.get(hash);
        if (!bucket.contains(key)) {
            bucket.add(key);
        }
    }

    public void remove(int key) {
        int hash = getHash(key);
        LinkedList<Integer> bucket = buckets.get(hash);
        bucket.remove(Integer.valueOf(key));
    }

    public boolean contains(int key) {
        int hash = getHash(key);
        LinkedList<Integer> bucket = buckets.get(hash);
        return bucket.contains(key);
    }
}
