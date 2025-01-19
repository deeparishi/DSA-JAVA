package com.deeparishi.javaapp.corejavaconcepts.serialization;

import java.io.Serial;
import java.io.Serializable;

// https://stackoverflow.com/questions/10378855/java-io-invalidclassexception-local-class-incompatible
// https://www.javatpoint.com/serialization-in-java

public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 6529685098267757690L; // refer above link

    public User(long id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    long id;
    transient String name; // THis field will not serialize
    int age;

}
