package com.deeparishi.javaapp.corejavaconcepts.serialization;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serialize {

    public static void main(String[] args) throws IOException {
        User user = new User(1, "Rishi", 23);
        FileOutputStream stream = new FileOutputStream("aaa.txt");
        ObjectOutputStream out=new ObjectOutputStream(stream);
        out.writeObject(user);
        out.flush();
        out.close();
        System.out.println("success");
    }
}
