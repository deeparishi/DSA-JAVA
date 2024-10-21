package com.deeparishi.javaapp.leetcode.linkedList;

import com.deeparishi.javaapp.leetcode.linkedList.utl.LinkedList;
import com.deeparishi.javaapp.leetcode.linkedList.utl.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//https://leetcode.com/problems/linked-list-random-node/description/?envType=problem-list-v2&envId=linked-list
public class RandomNode {

    public static void main(String[] args) {

        LinkedList ll = new LinkedList();

        ll.insert(1);
        ll.insert(2);
        ll.insert(3);
        ll.insert(4);
        ll.insert(5);

        Solution solution = new Solution(ll.head);

        int trials = 100000;
        Map<Integer, Integer> frequencyMap = new HashMap<>();

        for (int i = 0; i < trials; i++) {
            int randomValue = solution.getRandom();
            frequencyMap.put(randomValue, frequencyMap.getOrDefault(randomValue, 0) + 1);
        }

        System.out.println(STR."Frequency of random values after \{trials} trials:");
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            System.out.println(STR."Value: \{entry.getKey()}, Frequency: \{entry.getValue()}");
        }


    }

}



class Solution {
    Node head;
    Random random;

    public Solution(Node head) {
        this.head = head;
        this.random = new Random();
    }

    public int getRandom() {
        Node current = head;
        int result = current.value;
        int count = 1;

        // Traverse the list
        while (current != null) {
            if (random.nextInt(count) == 0) {
                result = current.value;
            }
            count++;
            current = current.next;
        }

        return result;
    }
}



