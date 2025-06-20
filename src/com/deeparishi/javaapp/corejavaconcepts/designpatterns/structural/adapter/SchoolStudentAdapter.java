package com.deeparishi.javaapp.corejavaconcepts.designpatterns.structural.adapter;

public class SchoolStudentAdapter implements Student{

    SchoolStudent schoolStudent;

    public SchoolStudentAdapter(SchoolStudent schoolStudent) {
        this.schoolStudent = schoolStudent;
    }

    @Override
    public String getName() {
        return this.schoolStudent.getName();
    }

    @Override
    public String getSurName() {
        return this.schoolStudent.getSurName();
    }

    @Override
    public String getEmail() {
        return this.schoolStudent.getEmail();
    }
}
