package com.deeparishi.javaapp.cheatsheet.trees.traversal;

import com.deeparishi.javaapp.cheatsheet.trees.utls.Pairs;
import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

import java.util.*;

//https://www.geeksforgeeks.org/problems/left-view-of-binary-tree/1?page=1&category=Tree&sortBy=submissions
//https://www.geeksforgeeks.org/problems/right-view-of-binary-tree/1?page=1&category=Tree&sortBy=submissions

public class LeftViewAndRightViewOfBT {

    public static void main(String[] args) {

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(rightView(root));
    }

    static ArrayList<Integer> leftView(TreeNode root) {

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pairs> pairs = new LinkedList<>();
        pairs.add(new Pairs(0, root));

        while (!pairs.isEmpty()){

            Pairs polled = pairs.poll();
            int level = polled.axis;
            TreeNode node = polled.node;

            if(!map.containsKey(level))
                map.put(level, node.val);

            if(node.left != null)
                pairs.add(new Pairs(level + 1, node.left));

            if(node.right != null)
                pairs.add(new Pairs(level + 1, node.right));
        }
        return new ArrayList<>(map.values());
    }

    static ArrayList<Integer> rightView(TreeNode root) {

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pairs> pairs = new LinkedList<>();
        pairs.add(new Pairs(0, root));

        while (!pairs.isEmpty()){

            Pairs polled = pairs.poll();
            int level = polled.axis;
            TreeNode node = polled.node;

            if(!map.containsKey(level))
                map.put(level, node.val);

            if(node.right != null)
                pairs.add(new Pairs(level + 1, node.right));

            if(node.left != null)
                pairs.add(new Pairs(level + 1, node.left));
        }
        return new ArrayList<>(map.values());
    }
}
