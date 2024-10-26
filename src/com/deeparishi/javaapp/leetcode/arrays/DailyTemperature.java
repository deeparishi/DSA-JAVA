package com.deeparishi.javaapp.leetcode.arrays;

import java.util.Arrays;
import java.util.Stack;

//https://leetcode.com/problems/daily-temperatures/description/

public class DailyTemperature {

    public static int[] dailyTemperatures(int[] temperatures) {

        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]){
                int prev = stack.pop();
                result[prev] = i - prev;
            }

            stack.push(i);
        }

        return result;

    }

    public static int[] dailyTemperaturess(int[] temperatures) {

        int n = temperatures.length;
        int[] answer = new int[n];  // The array to store the result
        Stack<Integer> stack = new Stack<>();  // Stack to store indices of days

        // Traverse the temperatures array
        for (int i = 0; i < n; i++) {
            // While the current temperature is warmer than the temperature at the index stored at the top of the stack
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int previousDay = stack.pop();  // Get the index of the day with the colder temperature
                answer[previousDay] = i - previousDay;  // Calculate the number of days waited
            }
            stack.push(i);  // Push the current day index to the stack
        }

        // The remaining indices in the stack are those with no warmer day in the future, so their answer remains 0
        return answer;
    }


    public static void main(String[] args) {

        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] result = dailyTemperaturess(temperatures);

        System.out.println(Arrays.toString(result));
    }
}
