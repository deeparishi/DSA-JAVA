package com.deeparishi.javaapp.cheatsheet.trees.traversal;

import com.deeparishi.javaapp.cheatsheet.trees.utls.Pairs;
import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

import java.util.*;

public class BottomViewOfBT {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(20);
        root.left = new TreeNode(8);
        root.right = new TreeNode(22);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(3);
        root.left.right.left = new TreeNode(10);
        root.right.left = new TreeNode(4);
        root.right.left.right = new TreeNode(14);
        root.right.right = new TreeNode(25);

        System.out.println(bottomView(root));
    }

    public static ArrayList<Integer> bottomView(TreeNode root) {

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pairs> queue = new LinkedList<>();
        queue.offer(new Pairs(0, root));

        while (!queue.isEmpty()){

            Pairs pair = queue.poll();
            int axis = pair.axis;
            TreeNode node = pair.node;

            map.put(axis, node.val);

            if(node.left != null)
                queue.offer(new Pairs(axis - 1, node.left));

            if(node.right != null)
                queue.offer(new Pairs(axis + 1, node.right));
        }

        return new ArrayList<>(map.values());
    }
}
