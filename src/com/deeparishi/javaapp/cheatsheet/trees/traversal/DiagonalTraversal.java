package com.deeparishi.javaapp.cheatsheet.trees.traversal;

import com.deeparishi.javaapp.cheatsheet.trees.utls.Pairs;
import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

import java.util.*;

public class DiagonalTraversal {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);

        System.out.println(diagonal(root));
    }

    public static ArrayList<Integer> diagonal(TreeNode root) {

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Pairs> pairsQueue = new LinkedList<>();
        pairsQueue.offer(new Pairs(0, root));

        while (!pairsQueue.isEmpty()){
            Pairs polled = pairsQueue.poll();
            int diagonal = polled.axis;
            TreeNode node = polled.node;

            map.putIfAbsent(diagonal, new ArrayList<>());
            map.get(diagonal).add(node.val);

            if (node.left != null)
                pairsQueue.offer(new Pairs(diagonal + 1, node.left));


            if (node.right != null)
                pairsQueue.offer(new Pairs(diagonal, node.right));

        }

        ArrayList<Integer> result = new ArrayList<>();

        for (List<Integer> diagonalNodes : map.values()) {
            result.addAll(diagonalNodes);
        }

        return result;
    }
}
