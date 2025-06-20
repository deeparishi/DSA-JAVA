package com.deeparishi.javaapp.corejavaconcepts.designpatterns.structural.adapter;

public class SchoolStudent {

    private final String name;
    private final String surname;
    private final String email;


    public SchoolStudent(String name, String surname, String email) {

        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    public String getName() { return name; }

    public String getSurName() { return surname; }

    public String getEmail() { return email; }
}
