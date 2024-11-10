package com.deeparishi.javaapp.corejavaconcepts.record;

public record EmployeeRecord(String employeeName, Integer employeeNumber) implements Runnable{

    public static final String employeeAddress = "No 7, White Town, America..";

//    public EmployeeRecord(String employeeName, Integer employeeNumber){
//        this.employeeName = employeeName;
//        this.employeeNumber = employeeNumber;
//    }

    public EmployeeRecord{
        if(employeeNumber < 0) throw new RuntimeException("Number should not be -ve");
    }
    public String nameInUpperCase() {
        return employeeName.toUpperCase();
    }

    public static void show() {
        System.out.println(employeeAddress);
    }

    @Override
    public void run() {

    }
}

/**
 * ABOUT RECORD'S
 * Main agenda of record to reduce line's of code compare to class
 * We have to do all such things in that class what I'm done on LegacyClassEmployee but with one line all those code provided by Record
 * Record must have parameters, those parameters considered as fields as same as class fields
 * Arguments in records are immutable, these final in nature
 * We cannot create mutable field inside the record (i.e) we cannot create non-final & non-static fields
 * We can create the static methods inside the record's
 * Records are final classes (i.e) we cannot extend any class, but we can implement the interface with record
 * Records automatically provide a canonical constructor that initializes all fields,so need of explicitly declaration
 * We can create the constructor with same args passed in the record, and we should set with record's args
       (i.e) whatever passed in the constructor we should set it with record arg. so, it cannot create NoArg constructor until the record args empty
 * You can create either all arg constructor or without args in constructor for validation
 */



/**
 * ABOUT RECORDS
 *
 * The main purpose of records is to reduce boilerplate code compared to regular classes.
 * With records, we can achieve what a traditional class requires many lines for, with a single line.
 *
 * Key Points:
 *
 * - Records must have parameters that are considered fields, similar to fields in a class.
 * - Record fields are immutable by default, meaning they are final and cannot be changed.
 * - You cannot create mutable fields (i.e., non-final and non-static fields) inside a record.
 * - Static methods can be defined within records.
 * - Records are implicitly final, so they cannot be extended by other classes. However, they can implement interfaces.
 * - A record automatically provides a canonical constructor that initializes all fields, so there’s no need for an explicit constructor declaration.
 * - You can create an additional constructor with the same arguments to perform validations, if necessary.
 * - Note that records do not support no-argument constructors unless the record itself has no fields.
 */
