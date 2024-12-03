package com.deeparishi.javaapp.cheatsheet.trees.traversal;

import com.deeparishi.javaapp.cheatsheet.trees.utls.Pairs;
import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;

//https://www.geeksforgeeks.org/problems/top-view-of-binary-tree/1?page=1&category=Tree&sortBy=submissions

public class TopViewOfBT {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        System.out.println(topView(root));
    }

    static ArrayList<Integer> topView(TreeNode root) {

        TreeMap<Integer, Integer> map = new TreeMap<>();

        Queue<Pairs> queue = new LinkedList<>();
        queue.add(new Pairs(0, root));

        while (!queue.isEmpty()){
            Pairs pair = queue.poll();
            int axis = pair.axis;
            TreeNode node = pair.node;

            if(!map.containsKey(axis))
                map.put(axis, node.val);

            if(node.left != null)
                queue.add(new Pairs(axis - 1, node.left));

            if(node.right != null)
                queue.add(new Pairs(axis + 1, node.right));

        }

        return new ArrayList<>(map.values());
    }
}

