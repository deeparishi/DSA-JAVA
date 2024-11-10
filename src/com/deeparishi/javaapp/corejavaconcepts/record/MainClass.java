package com.deeparishi.javaapp.corejavaconcepts.record;

public class MainClass {

    public static void main(String[] args) {

        LegacyClassEmployee legacyClassEmployee = new LegacyClassEmployee("Rishi", 012);
        System.out.println();
        System.out.println(legacyClassEmployee.getEmployeeName());
        System.out.println(legacyClassEmployee.getEmployeeNumber());
        System.out.println(legacyClassEmployee.toString());
        System.out.println(legacyClassEmployee.hashCode());
        System.out.println();

        EmployeeRecord employeeRecord = new EmployeeRecord("Deepak", 952);
        System.out.println(employeeRecord.employeeName());
        System.out.println(employeeRecord.employeeNumber());
        System.out.println(employeeRecord.toString());
        System.out.println(employeeRecord.hashCode());

    }
}
