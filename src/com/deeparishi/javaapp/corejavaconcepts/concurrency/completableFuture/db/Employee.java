package com.deeparishi.javaapp.corejavaconcepts.concurrency.completableFuture.db;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Employee {

    int id;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public boolean isNewJoined() {
        return isNewJoined;
    }


    String name;

    int age;

    boolean isNewJoined;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Employee(int id, String name, int age, boolean isNewJoined) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.isNewJoined = isNewJoined;
    }

    static String[] NAMES = {"John", "Jane", "Michael", "Sarah", "David", "Emily", "Daniel",
            "Laura", "Chris", "Anna"};

    public static List<Employee> generateEmployees() {

        List<Employee> employees = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 2000; i++) {

            int id = i + 1;
            int age = 18 + random.nextInt(48);
            String name = NAMES[random.nextInt(NAMES.length)];
            Employee employee = new Employee(id, name, age, true);
            employees.add(employee);
        }

        return employees;
    }

}
