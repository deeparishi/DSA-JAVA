package com.deeparishi.javaapp.cheatsheet.trees.traversal;

import com.deeparishi.javaapp.cheatsheet.trees.utls.Pairs;
import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

import java.util.*;

public class VerticalTreeTraversal {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = verticalOrder(root);
        ArrayList<Integer> res = verticalOrderWithSingleList(root);

        System.out.println("Vertical Order Traversal:");
        for (List<Integer> list : result) {
            System.out.println(list);
        }

        System.out.println("Vertical Order Traversal with single list:");
        for (Integer res1 : res) {
            System.out.println(res1);
        }

    }

    static ArrayList<Integer> verticalOrderWithSingleList(TreeNode root) {

        TreeMap<Integer, TreeMap<Integer, ArrayList<Integer>>> map = new TreeMap<>();

        Queue<Pairs> queue = new LinkedList<>();
        queue.offer(new Pairs(root, 0, 0));

        while (!queue.isEmpty()) {

            Pairs current = queue.poll();
            int axis = current.axis;
            int level = current.level;
            TreeNode node = current.node;

            map.computeIfAbsent(axis, k -> new TreeMap<>())
                    .computeIfAbsent(level, k -> new ArrayList<>())
                    .add(node.val);

            if (node.left != null)
                queue.offer(new Pairs(node.left, axis - 1, level + 1));
            if (node.right != null)
                queue.offer(new Pairs(node.right, axis + 1, level + 1));
        }

        ArrayList<Integer> result = new ArrayList<>();
        for (TreeMap<Integer, ArrayList<Integer>> levels : map.values()) {
            for (ArrayList<Integer> nodes : levels.values()) {
                result.addAll(nodes);
            }
        }

        return result;
    }

    static List<List<Integer>> verticalOrder(TreeNode root) {

        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Pairs> queue = new LinkedList<>();
        queue.offer(new Pairs(root, 0, 0));

        while (!queue.isEmpty()) {

            Pairs polled = queue.poll();
            int axis = polled.axis;
            int level = polled.level;
            TreeNode node = polled.node;

            if (!map.containsKey(axis))
                map.put(axis, new TreeMap<>());

            if (!map.get(axis).containsKey(level))
                map.get(axis).put(level, new PriorityQueue<>());

            map.get(axis).get(level).offer(node.val);

            if (node.left != null)
                queue.offer(new Pairs(node.left, axis - 1, level + 1));

            if (node.right != null)
                queue.offer(new Pairs(node.right, axis + 1, level + 1));
        }

        List<List<Integer>> res = new ArrayList<>();

        for (TreeMap<Integer, PriorityQueue<Integer>> m : map.values()) {
            List<Integer> subList = new ArrayList<>();
            for (PriorityQueue<Integer> val : m.values()) {
                while (!val.isEmpty())
                    subList.add(val.poll());
            }
            res.add(subList);
        }

        return res;
    }

    static TreeNode buildTree(String[] nodes) {
        if (nodes == null || nodes.length == 0 || nodes[0].equals("N"))
            return null;

        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int i = 1;

        while (!queue.isEmpty() && i < nodes.length) {
            TreeNode current = queue.poll();

            // Add left child
            if (!nodes[i].equals("N")) {
                current.left = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.left);
            }
            i++;

            // Add right child
            if (i < nodes.length && !nodes[i].equals("N")) {
                current.right = new TreeNode(Integer.parseInt(nodes[i]));
                queue.add(current.right);
            }
            i++;
        }

        return root;
    }
}

