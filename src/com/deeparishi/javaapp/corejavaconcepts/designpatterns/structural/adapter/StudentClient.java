package com.deeparishi.javaapp.corejavaconcepts.designpatterns.structural.adapter;

import java.util.ArrayList;
import java.util.List;

public class StudentClient {

    public List<Student> getStudentList() {

        List<Student> students = new ArrayList<>();

        CollegeStudent collegeStudent1 = new CollegeStudent("x", "xx", "xxx");
        CollegeStudent collegeStudent2 = new CollegeStudent("y", "yy", "yyy");
        CollegeStudent collegeStudent3 = new CollegeStudent("z", "zz", "zzz");
        students.add(collegeStudent1);
        students.add(collegeStudent2);
        students.add(collegeStudent3);

        SchoolStudent schoolStudent1 = new SchoolStudent("a", "aa", "aaa");
        SchoolStudent schoolStudent2 = new SchoolStudent("b", "bb", "bbb");
        SchoolStudent schoolStudent3 = new SchoolStudent("c", "cc", "ccc");
        students.add(new SchoolStudentAdapter(schoolStudent1));
        students.add(new SchoolStudentAdapter(schoolStudent2));
        students.add(new SchoolStudentAdapter(schoolStudent3));

        return students;
    }
}
