package com.deeparishi.javaapp.leetcode.tree.binarytree;

import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/leaf-similar-trees/?envType=problem-list-v2&envId=binary-tree&difficulty=EASY

public class LeafSimilarTree {
    public static void main(String[] args) {

    }

    static boolean leafSimilar(TreeNode root1, TreeNode root2) {

        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        getLeaves(root1, leaves1);
        getLeaves(root2, leaves2);

        return leaves1.equals(leaves2);
    }

    private static void getLeaves(TreeNode root1, List<Integer> leaves) {

        if(root1 == null) return;

        if(root1.left == null && root1.right == null){
            leaves.add(root1.val);
            return;
        }

        getLeaves(root1.left, leaves);
        getLeaves(root1.right, leaves);
    }
}
