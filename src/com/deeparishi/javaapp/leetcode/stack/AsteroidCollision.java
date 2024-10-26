package com.deeparishi.javaapp.leetcode.stack;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/asteroid-collision/description/

public class AsteroidCollision {

//    Example
//     4, 7, 1, 1, 2, -3, -7, 17, 15, -18, -19
//     4, 7, 1, 1, 2, -3, -7, 17, 15, -16

    public static int[] asteroidCollision(int[] asteroids) {

        Stack<Integer> stack = new Stack<>();

        for (Integer asteroid : asteroids){

            if(asteroid > 0)
                stack.push(asteroid);

            else {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(asteroid)){
                    stack.pop();
                }

                if(stack.isEmpty() || stack.peek() < 0)
                    stack.push(asteroid);

                if(stack.peek() == Math.abs(asteroid))
                    stack.pop();
            }
        }

        int [] arr = new int[stack.size()];

        for (int i= stack.size()-1; i>=0; i--)
            arr[i] = stack.pop();

        return arr;

    }

    public static void main(String[] args) {

        int[] arr = {4, 7, 1, 1, 2, -3, -7, 17, 15, -18, -19};

        int [] res = asteroidCollision(arr);

        System.out.println(Arrays.toString(res));
    }
}
