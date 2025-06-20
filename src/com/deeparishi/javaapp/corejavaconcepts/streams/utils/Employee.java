package com.deeparishi.javaapp.corejavaconcepts.streams.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class Employee {

    public String name;

    public Integer age;

    public  Long salary;

    public String dept;

    public List<Employee> employees = new ArrayList<>();














    List<String> departments =  List.of("IT", "HR", "QA", "SUPPORT", "DevOPS");

    List<String> names = List.of("Jack","Ajit", "Rahul", "Priya", "Sweta", "Hari");

    public void init() {

        IntStream.range(0, 10)
                .forEach(_ -> {
                    Employee employee = new Employee();
                    employee.name = names.get(ThreadLocalRandom.current().nextInt(names.size() - 1));
                    employee.age = ThreadLocalRandom.current().nextInt(220, 5);
                    employee.salary = ThreadLocalRandom.current().nextLong(20000L, 200000L);
                    employee.dept = departments.get(ThreadLocalRandom.current().nextInt(names.size() - 1));
                    employees.add(employee);
                });

        System.out.println("Employee List ");
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", dept='" + dept + '\'' +
                ", employees=" + employees +
                ", departments=" + departments +
                ", names=" + names +
                '}';
    }
}
