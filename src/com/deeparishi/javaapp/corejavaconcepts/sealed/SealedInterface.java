package com.deeparishi.javaapp.corejavaconcepts.sealed;

public class SealedInterface {

    public static void main(String[] args) {

    }
}

sealed interface X permits Y, Z {
    static void run() {
        System.out.println("X is Running!");
    }
}

non-sealed interface Y extends X {

}

sealed interface Z extends X permits Z1{

}

non-sealed interface Z1 extends Z {

}