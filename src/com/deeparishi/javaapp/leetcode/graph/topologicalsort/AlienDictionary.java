package com.deeparishi.javaapp.leetcode.graph.topologicalsort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://www.geeksforgeeks.org/problems/alien-dictionary/1

public class AlienDictionary {

    public static void main(String[] args) {
        String[] dict = new String[]{"baa","abcd","abca","cab","cad"};
        System.out.println(findOrderIsPresentOrNot(dict, 4));
    }

    public static String findOrder(String[] dict, int k) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < k - 1; i++) {
            String s1 = dict[i];
            String s2 = dict[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int v = 0; v < len; v++) {
                if (s1.charAt(v) != s2.charAt(v)) {
                    adj.get(s1.charAt(v) - 'a').add(s2.charAt(v) - 'a');
                    break;
                }
            }
        }

        List<Integer> topoSort = topoSort(k, adj);
        StringBuilder ans = new StringBuilder();

        for (Integer val : topoSort){
            char c = (char) (val + (int) ('a'));
            ans.append(c);
        }

         return ans.isEmpty() ? "false" : "true";

    }

    private static List<Integer> topoSort(int k, List<List<Integer>> adj) {

        int[] inDegree = new int[k];
        for (int i = 0; i < k; i++) {
            for(int neighbour : adj.get(i))
                inDegree[neighbour]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if(inDegree[i] == 0)
                queue.add(i);
        }

        List<Integer> ans = new ArrayList<>();

        while (!queue.isEmpty()) {

            int node = queue.poll();
            ans.add(node);

            for (int neighbour : adj.get(node)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        return ans;
    }


    public static String findOrderIsPresentOrNot(String[] dict, int k) {
        // Step 1: Build the graph
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < dict.length - 1; i++) {
            String word1 = dict[i];
            String word2 = dict[i + 1];
            int len = Math.min(word1.length(), word2.length());

            for (int j = 0; j < len; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adj.get(word1.charAt(j) - 'a').add(word2.charAt(j) - 'a');
                    break;
                }
            }
        }

        int[] inDegree = new int[k];
        for (List<Integer> neighbors : adj) {
            for (int neighbor : neighbors) {
                inDegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder ans = new StringBuilder();
        while (!queue.isEmpty()) {
            int node = queue.poll();
            ans.append((char) (node + 'a'));

            for (int neighbor : adj.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        return ans.length() == k ? ans.toString() : "";
    }

}
