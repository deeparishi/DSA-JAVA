package com.deeparishi.javaapp.leetcode.bitwise;

// https://leetcode.com/problems/minimize-xor

public class MinimizeXOR {

    public static void main(String[] args) {
        System.out.println(minimizeXor(8, 3));

    }

    public static int minimizeXor(int num1, int num2) {

        int bitCountNum2 = Integer.bitCount(num2); // Number of 1s in num2
        int result = 0;

        // Step 1: Fill result using bits from num1
        for (int i = 31; i >= 0 && bitCountNum2 > 0; i--) {
            if ((num1 & (1 << i)) != 0) { // If i-th bit of num1 is set
                result |= (1 << i);      // Set the i-th bit in result
                bitCountNum2--;          // Reduce required bit count
            }
        }

        // Step 2: Fill remaining bits from the least significant side
        for (int i = 0; i <= 31 && bitCountNum2 > 0; i++) {
            if ((result & (1 << i)) == 0) { // If i-th bit of result is not set
                result |= (1 << i);        // Set the i-th bit in result
                bitCountNum2--;            // Reduce required bit count
            }
        }

        return result;
    }
}
