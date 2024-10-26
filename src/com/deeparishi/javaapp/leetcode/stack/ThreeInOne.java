package com.deeparishi.javaapp.leetcode.stack;

//https://www.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/quiz/5132864#questions

public class ThreeInOne {

    public static void main(String[] args) {

    }


}

class ThreeInOneImpl {

    private final int NUMBER_OF_STACKS = 3;
    private int stackCapacity;
    private int[] values;
    private int[] sizes;

    public ThreeInOneImpl(int eachStackSize) {
        stackCapacity = eachStackSize;
        values = new int[stackCapacity * NUMBER_OF_STACKS];
        sizes = new int[NUMBER_OF_STACKS];
    }

    // isFull
    public boolean isFull(int stackNum) {
        return sizes[stackNum] == stackCapacity;
    }

    // isEmpty
    public boolean isEmpty(int stackNum) {
        return sizes[stackNum] == 0;
    }

    // indexOfTop - this is helper method for push, pop and peek methods
    private int indexOfTop(int stackNum) {
        int offset = stackNum * stackCapacity;
        int size = sizes[stackNum];
        return offset + size - 1;
    }

    // push
    public void push(int stackNum, int value) {
        if(isFull(stackNum)) return;
        else{
            sizes[stackNum]++;
            values[indexOfTop(stackNum)] = value;
        }
    }

    // pop
    public int pop(int stackNum) {
        if(isEmpty(stackNum)) return  -1;
        else{
            int value = values[indexOfTop(stackNum)];
//            values[indexOfTop(stackNum)] = 0;
            sizes[stackNum]--;
            return value;
        }
    }

    // peek
    public int peek(int stackNum) {
        if(isEmpty(stackNum)) return  -1;
        else{
            return values[indexOfTop(stackNum)];
        }
    }

}
