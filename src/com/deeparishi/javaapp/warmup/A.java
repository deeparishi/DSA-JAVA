package com.deeparishi.javaapp.warmup;

@FunctionalInterface
interface A {

    void run();

    default String get() {
        return "get!";
    }
}