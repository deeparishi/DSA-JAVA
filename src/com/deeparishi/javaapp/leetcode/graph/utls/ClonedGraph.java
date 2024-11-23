package com.deeparishi.javaapp.leetcode.graph.utls;

import java.util.HashMap;
import java.util.Map;

public class ClonedGraph {
    public static void main(String[] args) {

    }

    public Node cloneGraph(Node node) {

        Map<Node, Node> map = new HashMap<>();
        return dfs(node, map);
    }

    private Node dfs(Node node, Map<Node, Node> map) {

        if(map.containsKey(node))
            return map.get(node);

        Node clone = new Node(node.val);
        map.put(node, clone);

        for (Node neighbour : node.neighbors){
            clone.neighbors.add(dfs(neighbour, map));
        }

        return clone;
    }


}
