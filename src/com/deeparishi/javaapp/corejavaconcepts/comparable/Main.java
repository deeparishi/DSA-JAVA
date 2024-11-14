package com.deeparishi.javaapp.corejavaconcepts.comparable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<Employee> employees = new ArrayList<>();

        Employee e1 = new Employee("Rishi", 12, 1200);
        Employee e2 = new Employee("Muthu", 5, 5000);
        Employee e3 = new Employee("Buvi", 42, 8000);

        employees.add(e1);
        employees.add(e2);
        employees.add(e3);

//        Comparator<Employee> com = new Comparator<Employee>() {
//
//            @Override
//            public int compare(Employee e1, Employee e2) {
//                if(e1.getAge() < e2.getAge()) return 1;
//                if(e1.getAge() > e2.getAge()) return -1;
//                else return 0;
//            }
//        };

//        Comparator<Employee> com1 = ( Employee a ,Employee  b) ->  Integer.compare(b.getAge(), a.getAge());

        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                if(e1.getAge() > e2.getAge()) return 1;
                else if (e1.getAge() < e2.getAge()) return -1;

                if(e1.getSalary() > e2.getSalary()) return 1;
                if(e1.getSalary() < e2.getSalary()) return -1;

                return 0;
            }
        };

        Collections.sort(employees);


        System.out.println(employees);



    }
}


/** ABOUT COMPARATOR

 * The Comparator interface is a functional interface that allows us to define custom sorting logic.
 * This is especially useful when sorting complex objects based on specific attributes.
 * In this example, we create a comparator to sort Employee objects by age in descending order.
 * - Returning 1 indicates that the first argument is greater, so a swap will occur.
 * - Returning -1 indicates that the first argument is smaller, so no swap will occur.
 * - Returning 0 indicates that both arguments are equal, and no change in order is needed.
 * After defining the comparator, pass it to the Collections.sort() method to get the sorted output.
 * We can sort the collection on the basis of multiple elements such as name, age, salary etc
 * It doesn't affect the original class meaning actual class is not modified

    WAY 1:

     Comparator<Employee> com = new Comparator<Employee>() {

            @Override
            public int compare(Employee e1, Employee e2) {
                if(e1.getAge() < e2.getAge()) return 1;
                if(e1.getAge() > e2.getAge()) return -1;
                else return 0;
            }
        };

     Collections.sort(employees, com);

    WAY 2:

    Comparator<Employee> com1 = ( Employee a ,Employee  b) ->  Integer.compare(a.getAge(), b.getAge());


    COMPARISON WITH MORE THAN ONE FIELD IN OBJECT

    WAY 1:

    The below comparator will first compare the age, if age are equal then it'll proceed for salary
    or else it'll return where condition getting satisfies

    Comparator<Employee> comparator = new Comparator<Employee>() {
        @Override
        public int compare(Employee e1, Employee e2) {
            if(e1.getAge() > e2.getAge()) return 1;
            else if (e1.getAge() < e2.getAge()) return -1;

            if(e1.getSalary() > e2.getSalary()) return 1;
            if(e1.getSalary() < e2.getSalary()) return -1;

            return 0;
        }
    };

     Achieved the above functionality using Java 8
     Comparator<Employee> com = Comparator
                                  .comparingInt(Employee::getAge).reversed()
                                  .thenComparingInt(Employee::getSalary).reversed();

    WAY 2:

        Primary Comparison (age):
            If the ages are different, we compare them in descending order using
            Integer.compare(e2.getAge(), e1.getAge()).
        Secondary Comparison (salary):
            If the ages are the same, we compare salaries in descending order.

        Comparator<Employee> com = new Comparator<Employee>() {
            @Override
            public int compare(Employee e1, Employee e2) {
                if (e1.getAge() != e2.getAge()) {
                    return Integer.compare(e2.getAge(), e1.getAge());
                } else {
                    return Integer.compare(e2.getSalary(), e1.getSalary());
                }
            }
        };



 */

