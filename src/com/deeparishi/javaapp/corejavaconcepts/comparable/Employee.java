package com.deeparishi.javaapp.corejavaconcepts.comparable;

public class Employee implements Comparable<Employee> {

    private String name;

    private int age;

    private int salary;

    public Employee(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }


    @Override
    public int compareTo(Employee employee) {
        if (this.age > employee.getAge()) return 1;
        else if (this.age < employee.getAge()) return -1;
        return 0;
    }
}

/**
 * ABOUT COMPARABLE
 * - We can sort a collection based on a single field, such as age, name, or salary.
 * - Implementing Comparable affects the original class by imposing a "natural ordering" on its instances.
 * - It provides the `compareTo` method to define the order for sorting the collection.
 * - Classes that implement Comparable are typically sorted in ascending order by default,
 *   unless the `compareTo` method is customized to provide a different order.
 * - Only one `compareTo` method can be implemented, so only one natural ordering is possible.
 * - Comparable is used primarily when we want a default sorting behavior and expect
 *   the class itself to dictate the order (e.g., sorting by name in alphabetical order for a Employee class).
 * - Example: `class Employee implements Comparable<Employee> { ... }`
 */
