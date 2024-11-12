package com.deeparishi.javaapp.dsaconcepts.tree.binarytree.basictree;

public class BinaryTree {

    public static void main(String[] args) {

        BasicTreeNode drinks = new BasicTreeNode("Drinks");
        BasicTreeNode hot = new BasicTreeNode("Hot");
        BasicTreeNode cold = new BasicTreeNode("Cold");
        BasicTreeNode tea = new BasicTreeNode("Tea");
        BasicTreeNode coffee = new BasicTreeNode("Coffee");
        BasicTreeNode wine = new BasicTreeNode("Wine");
        BasicTreeNode beer = new BasicTreeNode("Beer");

        drinks.addChildren(hot);
        drinks.addChildren(cold);

        hot.addChildren(tea);
        hot.addChildren(coffee);

        cold.addChildren(wine);
        cold.addChildren(beer);

        System.out.println(drinks.print(2));

    }

}
