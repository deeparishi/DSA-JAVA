package com.deeparishi.javaapp.leetcode.arrays;

import java.util.Iterator;

//https://leetcode.com/problems/peeking-iterator/description/?envType=problem-list-v2&envId=iterator

public class PeekingIterator implements Iterator<Integer> {

    Iterator<Integer> iterator;
    Integer nextElement = 0;

    public PeekingIterator(Iterator<Integer> iterator) {
        this.iterator = iterator;

        if (iterator.hasNext())
            nextElement = iterator.next();
    }

    public Integer peek() {
        return nextElement;
    }

    @Override
    public Integer next() {

        int current = nextElement;

        if (iterator.hasNext())
            nextElement = iterator.next();
        else
            nextElement = null;

        return current;
    }

    @Override
    public boolean hasNext() {
        return nextElement != null;
    }
}
