package com.deeparishi.javaapp.leetcode.stack;

import java.util.Stack;

public class CollisionOnRoad {

    public static int countCollisions(String directions) {

        int collisionCount = 0;
        Stack<Character> status = new Stack<>();

        for (Character c : directions.toCharArray()) {

            if (c == 'R') {
                status.push(c);
            } else if (c == 'L') {

                while (!status.isEmpty() && status.peek() == 'R') {
                    status.pop();
                    collisionCount += 2;

                }
                if (!status.isEmpty() && status.peek() == 'S') {
                    collisionCount += 1;
                }

                status.push('S');
            } else if (c == 'S') {

                while (!status.isEmpty() && status.peek() == 'R') {
                    status.pop();
                    collisionCount += 1;
                }

                status.push('S');

            }
        }

        return collisionCount;
    }


    public static void main(String[] args) {

        System.out.println(countCollisions("LLRR"));
    }

}