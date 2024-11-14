package com.deeparishi.javaapp.leetcode.tree.binarytree;

import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/binary-tree-paths/?envType=problem-list-v2&envId=binary-tree&difficulty=EASY

public class BinaryTreePath {
    public static void main(String[] args) {

    }

    static List<String> binaryTreePaths(TreeNode root) {
        return binaryTreePaths("", new ArrayList<>(), root);
    }

    static List<String> binaryTreePaths(String path, ArrayList<String> paths, TreeNode root) {

        if(root == null) return paths;

        path += root.val;

        if(root.left == null && root.right == null) {
            paths.add(path);
        }else {
            path += "->";
            binaryTreePaths(path, paths, root.left);
            binaryTreePaths(path, paths, root.right);
        }

        return paths;

    }
}
