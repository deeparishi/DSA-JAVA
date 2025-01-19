package com.deeparishi.javaapp.leetcode.tree.bst;

import com.deeparishi.javaapp.leetcode.tree.utils.TreeNode;

// https://www.udemy.com/course/java-data-structures-and-algorithms-masterclass/learn/quiz/5188534#overview

public class ValidateBST {

    public static Integer lastPrinted = null;

    public static void main(String[] args) {

    }

    public static boolean checkBST(TreeNode node) {
        return checkBST(node, true);
    }

    // Allow "equal" value only for left child. This validates the BST property.
    public static boolean checkBST(TreeNode n, boolean isLeft) {
        if (n == null) {
            return true;
        }

        // Check / recurse left
        if (!checkBST(n.left, true)) {
            return false;
        }

        // Check current
        if (lastPrinted != null) {
            if (isLeft) {
                // left child "is allowed" be equal to parent.
                if (n.val < lastPrinted) {
                    return false;
                }
            } else {
                // Right child "is not allowed" be equal to parent.
                if (n.val <= lastPrinted) {
                    return false;
                }
            }
        }
        lastPrinted = n.val;

        // Check / recurse right
        return checkBST(n.right, false);
    }


}