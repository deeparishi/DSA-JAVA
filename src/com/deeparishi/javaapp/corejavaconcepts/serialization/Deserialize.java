package com.deeparishi.javaapp.corejavaconcepts.serialization;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class Deserialize {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("aaa.txt"));
        User user = (User) inputStream.readObject();
        System.out.println(user);
        inputStream.close();
    }
}
