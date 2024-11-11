package com.deeparishi.javaapp.dsaconcepts.tree.basictree;

import java.util.ArrayList;

public class BasicTreeNode {

    String data;

    ArrayList<BasicTreeNode> children;

    BasicTreeNode(String data) {
        this.data = data;
        children = new ArrayList<>();
    }

    public void addChildren(BasicTreeNode treeNode) {
        this.children.add(treeNode);
    }

    public String print(int level) {

        String rtr = " ".repeat(level) + data + "\n";

        for (BasicTreeNode child : children) {
            rtr += child.print(level + 1);
        }

        return rtr;
    }

}


