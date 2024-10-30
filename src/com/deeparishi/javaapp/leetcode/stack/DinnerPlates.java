package com.deeparishi.javaapp.leetcode.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

//https://leetcode.com/problems/dinner-plate-stacks/description/

class MainClass{
    public static void main(String[] args) {
        DinnerPlates D = new DinnerPlates(2);
        D.push(1);
        D.push(2);
        D.push(3);
        D.push(4);
        D.push(5);
        System.out.println(D.popAtStack(0));
        D.push(20);
        D.push(21);
        System.out.println(D.popAtStack(0));
        System.out.println(D.popAtStack(2));
        System.out.println(D.pop());
        System.out.println(D.pop());
        System.out.println(D.pop());
        System.out.println(D.pop());
        System.out.println(D.pop());
    }
}
class DinnerPlates {

    List<Stack<Integer>> stackStore;
    int capacityOfEachStack;
    TreeSet<Integer> availableAreaOfStack;

    public DinnerPlates(int capacity) {
        this.stackStore = new ArrayList<>();
        this.capacityOfEachStack = capacity;
        this.availableAreaOfStack = new TreeSet<>();
    }

    public void push(int val) {

        if(availableAreaOfStack.isEmpty()){
            stackStore.add(new Stack<>());
            availableAreaOfStack.add(stackStore.size() - 1);
        }

        int index = availableAreaOfStack.first(); // Get the first available stack index
        Stack<Integer> spaceAvailableStack = stackStore.get(index);
        spaceAvailableStack.push(val);

        if(spaceAvailableStack.size() == capacityOfEachStack) availableAreaOfStack.pollFirst();
    }

    public int pop() {

        if (stackStore.isEmpty()) return  -1;

        int res = stackStore.getLast().pop();
        availableAreaOfStack.add(stackStore.size()-1);

        while (!stackStore.isEmpty() && stackStore.getLast().isEmpty()){
            stackStore.removeLast();
            availableAreaOfStack.pollLast();
        }

        return res;
    }

    public int popAtStack(int index) {

        if (index >= stackStore.size()) return -1;
        if (stackStore.size() - 1 == index) return pop();

        Stack<Integer> stackToBePopped = stackStore.get(index);
        int res = stackToBePopped.isEmpty() ? -1 : stackToBePopped.pop();
        availableAreaOfStack.add(index);

        return res;
    }
}