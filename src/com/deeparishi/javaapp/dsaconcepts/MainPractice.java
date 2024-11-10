package com.deeparishi.javaapp.dsaconcepts;

import com.deeparishi.javaapp.leetcode.stack.DesignTwitter;
import org.w3c.dom.Entity;

import java.util.HashMap;
import java.util.Map;

public class MainPractice {

    static {
        System.out.println("hello world");
    }


    public static void main(String[] args) {

        Map<Class<?>, String> map = new HashMap<>();

        map.put(String.class, "String class");
        map.put(Integer.class, "Integer class");
        map.put(DesignTwitter.class, "Integer 2 class");

        System.out.println(map.get(String.class));
    }


}
