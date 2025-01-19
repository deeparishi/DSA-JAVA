package com.deeparishi.javaapp.leetcode.graph.dfs;

import java.util.*;

// https://leetcode.com/problems/evaluate-division/?envType=problem-list-v2&envId=graph

public class EvaluateEquation {

    public static void main(String[] args) {

    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {

        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] results = new double[queries.size()];

        for (int i = 0; i < queries.size(); i++) {
            List<String> query = queries.get(i);
            String numerator = query.get(0);
            String denominator = query.get(1);

            if (!graph.containsKey(numerator) || !graph.containsKey(denominator))
                results[i] = -1.0;
            else
                results[i] = dfs(graph, numerator, denominator, new HashSet<>(), 1.0);

        }

        return results;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {

        Map<String, Map<String, Double>> graph = new HashMap<>();

        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];

            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());

            graph.get(a).put(b, value);
            graph.get(b).put(a, 1.0 / value);
        }

        return graph;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String current, String target, Set<String> visited, double value) {

        if (current.equals(target))
            return value;


        visited.add(current);

        for (Map.Entry<String, Double> neighbor : graph.get(current).entrySet()) {
            String nextNode = neighbor.getKey();
            double edgeWeight = neighbor.getValue();

            if (!visited.contains(nextNode)) {
                double result = dfs(graph, nextNode, target, visited, value * edgeWeight);
                if (result != -1.0) {
                    return result;
                }
            }
        }

        return -1.0;
    }
}