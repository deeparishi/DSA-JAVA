package com.deeparishi.javaapp.cheatsheet.trees.pathanddistance;

import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

import java.util.ArrayList;

//https://www.geeksforgeeks.org/problems/root-to-leaf-paths/1?page=4&category=Tree&sortBy=submissions

public class RootToLeafPath {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(20);
        root.right= new TreeNode(30);
        root.left.left = new TreeNode(40);
        root.left.right = new TreeNode(50);
        System.out.println(findAllPaths(root));
    }

    public static ArrayList<ArrayList<Integer>> findAllPaths(TreeNode root) {
        if(root == null) return new ArrayList<>();
        ArrayList<ArrayList<Integer>> allPaths = new ArrayList<>();
        findAllPaths(root, new ArrayList<Integer>(), allPaths);
        return allPaths;
    }

    private static void findAllPaths(TreeNode root, ArrayList<Integer> paths, ArrayList<ArrayList<Integer>> allPaths) {

        if(root == null)
            return;

        paths.add(root.val);

        if(root.left == null && root.right == null)
            allPaths.add(new ArrayList<>(paths));
        else {
            findAllPaths(root.left, paths, allPaths);
            findAllPaths(root.right, paths, allPaths);
        }

        paths.removeLast();
    }


}
