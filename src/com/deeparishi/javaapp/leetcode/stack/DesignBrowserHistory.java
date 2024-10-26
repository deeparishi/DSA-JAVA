package com.deeparishi.javaapp.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

public class DesignBrowserHistory {

    List<String> browsedPages = new ArrayList<>();
    int current = -1;

    public DesignBrowserHistory(String homepage) {
       browsedPages.add(homepage);
       current = 0;
    }

    public void visit(String url) {

        while (browsedPages.size() > current+1)
            browsedPages.removeLast();

        browsedPages.add(url);
        current++;

    }

    public String back(int steps) {

        current = Math.max(0, current - steps);
        return browsedPages.get(current);
    }

    public String forward(int steps) {

        current = Math.min(browsedPages.size()-1, current+steps);
        return browsedPages.get(current);
    }
}

class Main {

    public static void main(String[] args) {

        DesignBrowserHistory browserHistory = new DesignBrowserHistory("Leetcode");

        browserHistory.visit("Google");
        browserHistory.visit("FB");
        browserHistory.visit("YouTube");

        System.out.println(browserHistory.back(1));
        System.out.println(browserHistory.back(1));

        browserHistory.visit("LinkedIn");

        System.out.println(browserHistory.forward(2));

        System.out.println(browserHistory.back(2));
        System.out.println(browserHistory.back(7));

    }
}
