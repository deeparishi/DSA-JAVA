package com.deeparishi.javaapp.leetcode.stack;

import java.util.Stack;

// https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string-ii/

public class RemoveDuplicate2 {
    public static void main(String[] args) {
        System.out.println(removeDuplicates("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4));
        System.out.println(removeDuplicates("yfttttfbbbbnnnnffbgffffgbbbbgssssgthyyyy", 4));
    }

    public static String removeDuplicates(String s, int k) {
        Stack<Pair> pairStack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!pairStack.empty() && pairStack.peek().ch == ch) {
                pairStack.peek().inc();
                if (pairStack.peek().count >= k) {
                    int max = pairStack.peek().count - k;
                    if (max <= 0)
                        pairStack.pop();
                    else {
                        Pair pop = pairStack.pop();
                        pop.dec(k);
                        pairStack.push(pop);
                    }
                }
            } else
                pairStack.push(new Pair(ch, 1));
        }

        StringBuilder builder = new StringBuilder();

        while (!pairStack.empty()) {
            Pair pair = pairStack.pop();
            builder.append(String.valueOf(pair.ch).repeat(pair.count));
        }

        return builder.reverse().toString();
    }

    static class Pair {
        char ch;
        int count;

        Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }

        void inc() {
            count++;
        }

        public void dec(int k) {
            count -= k;
        }
    }
}

