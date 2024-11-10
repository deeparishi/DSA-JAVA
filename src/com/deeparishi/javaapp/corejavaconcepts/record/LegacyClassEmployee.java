package com.deeparishi.javaapp.corejavaconcepts.record;

import java.util.Objects;

public class LegacyClassEmployee {

    private final String employeeName;

    private final Integer employeeNumber;


    public LegacyClassEmployee(String employeeName, Integer employeeNumber) {
        this.employeeName = employeeName;
        this.employeeNumber = employeeNumber;
    }


    public String getEmployeeName() {
        return employeeName;
    }

    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LegacyClassEmployee that = (LegacyClassEmployee) o;
        return Objects.equals(employeeName, that.employeeName) && Objects.equals(employeeNumber, that.employeeNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(employeeName, employeeNumber);
    }

    @Override
    public String toString() {
        return "LegacyClassEmployee{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeNumber=" + employeeNumber +
                '}';
    }

}
