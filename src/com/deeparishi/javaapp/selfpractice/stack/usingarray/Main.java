package com.deeparishi.javaapp.selfpractice.stack.usingarray;

public class Main {

    public static void main(String[] args) {
        Stack stack = new Stack();

        for (int i = 0; i <= 9; i++) {
            stack.push(i);
        }
        System.out.println("After Insertion ");
        stack.print();
        System.out.println("After Peek ");
        System.out.println(STR."\{stack.peek()} Peek Element");
        stack.print();
        System.out.println("After Pop ");
        System.out.println(STR."\{stack.pop()} Popped one");
        stack.print();
        System.out.println("After deletion");
        stack.delete();
        stack.print();

    }
}
