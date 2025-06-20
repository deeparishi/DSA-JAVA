package com.deeparishi.javaapp.corejavaconcepts.designpatterns.structural.adapter;

import java.util.List;

public class Client {

    public static void main(String[] args) {

        StudentClient client = new StudentClient();
        List<Student> students = client.getStudentList();
        students.forEach(student -> System.out.println(student.getClass()));
    }
}
