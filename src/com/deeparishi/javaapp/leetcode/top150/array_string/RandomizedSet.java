package com.deeparishi.javaapp.leetcode.top150.array_string;

import java.util.*;

public class RandomizedSet {

    List<Integer> values;
    Map<Integer, Integer> lookup;
    Set<Integer> unique;
    Random random;

    public RandomizedSet() {
        this.values = new ArrayList<>();
        this.lookup = new HashMap<>();
        this.unique = new HashSet<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (unique.contains(val))
            return false;

        unique.add(val);
        values.add(val);
        lookup.put(val, values.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!unique.contains(val))
            return false;

        unique.remove(val);
        int index = lookup.get(val);
        int lastElement = values.getLast();

        values.add(index, lastElement);
        lookup.put(lastElement, index);
        values.removeLast();

        return true;
    }

    public int getRandom() {
        int rand = random.nextInt(values.size() - 1);
        return values.get(rand);
    }

    public static void main(String[] args) {
        RandomizedSet obj = new RandomizedSet();
        boolean param_1 = obj.insert(2);
        boolean param_2 = obj.remove(3);
        int param_3 = obj.getRandom();
    }
}
