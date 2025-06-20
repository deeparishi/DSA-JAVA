package com.deeparishi.javaapp.corejavaconcepts.streams;

import com.deeparishi.javaapp.corejavaconcepts.streams.utils.Employee;
import com.deeparishi.javaapp.corejavaconcepts.streams.utils.Players;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;


public class GroupingBy {

    public static void main(String[] args) {

        employee();
        players();
        firstNonRepeatedCharacter("Java articles are Awesome");
        countOfEachElement(Arrays.asList("AA", "BB", "AA", "CC"));
    }

    private static void countOfEachElement(List<String> elements) {

        Map<String, Long> elementCountMap =
                elements.stream()
                        .collect(Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        ));
        System.out.println(elementCountMap);

        Map<Character, Long> charCountMap =
                elements.stream()
                        .map(Object::toString)
                        .flatMap(str -> str.chars().mapToObj(s -> (char) s))
                        .collect(Collectors.groupingBy(
                                Character::charValue,
                                Collectors.counting()
                        ));

        System.out.println(charCountMap);



    }


    public static void employee() {

        Employee employee = new Employee();
        employee.init();


        Map<String, Optional<Employee>> topSalariesFromDeptWthEmployee = employee.employees.stream()
                .collect(Collectors.groupingBy(
                        emp -> emp.dept,
                        Collectors.maxBy(Comparator.comparingLong(emp -> emp.salary))
                ));

        System.out.println();
        System.out.println("Brute Force");
        topSalariesFromDeptWthEmployee.forEach((key, value) -> System.out.println(key + " " + value));

        // Optimal
        Map<String, Long> topSalariesFromDept = employee.employees.stream()
                .collect(Collectors.groupingBy(
                        emp -> emp.dept,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingLong(emp -> emp.salary)),
//                                 emp -> emp.get().salary
                                emp -> emp.map(e -> e.salary).orElse(0L)
                        )
                ));

        Map<String, Long> deptWiseTotalSalary = employee.employees.stream()
                .collect(Collectors.groupingBy(
                        emp -> emp.dept,
                        Collectors.summingLong(emp -> emp.salary)
                ));

        Map<String, List<String>> deptWiseEmployeeName = employee.employees.stream()
                .collect(Collectors.groupingBy(
                                emp -> emp.dept,
                                Collectors.mapping(emp -> emp.name, Collectors.toList())
                        )
                );

        Map<String, Double> avgSalaryByDept = employee.employees.stream()
                .collect(Collectors.groupingBy(
                        emp -> emp.dept,
                        Collectors.averagingLong(emp -> emp.salary)
                ));

        int MAX_SALARY = 177980;
        Map<String, String> maxSalaryByDeptAndUsers = employee.employees.stream()
                .filter(emp -> emp.salary > MAX_SALARY)
                .collect(Collectors.groupingBy(
                        emp -> emp.dept,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingLong(emp -> emp.salary)),
                                emp -> emp.map(e -> e.name).orElse(null)
                        )
                ));

        List<Employee> HREmployees = employee.employees.stream()
                .filter(emp -> emp.age > 23 && emp.dept.equals("IT"))
                .toList();

        Map<String, Long> employeeCountEachDept = employee.employees.stream()
                .collect(Collectors.groupingBy(
                        emp -> emp.dept,
                        Collectors.counting()
                ));

        Employee highestPaidEmp = employee.employees.stream()
                .max(Comparator.comparingLong(emp -> emp.salary))
                .stream().findFirst().orElse(null);

        Employee lowestPaidEmp = employee.employees.stream()
                .min(Comparator.comparingLong(emp -> emp.salary))
                .stream().findFirst().orElse(null);


        System.out.println();
        System.out.println();
        System.out.println("Top Salaries From Dept " + topSalariesFromDept);
        System.out.println("Dept Wise Total Salary " + deptWiseTotalSalary);
        System.out.println("Dept Wise EmpName " + deptWiseEmployeeName);
        System.out.println("Avg Salary by dept " + avgSalaryByDept);
        System.out.println("Max salary by dept user " + maxSalaryByDeptAndUsers);
        HREmployees.forEach(emp -> System.out.print(emp.name + " "));
        System.out.println("Employee Count in Each Dept " + employeeCountEachDept);
        System.out.println("Highest Paid Emp " + highestPaidEmp.toString());
        System.out.println("Lowest Paid Emp " + lowestPaidEmp.toString());
        System.out.println("Salary By Descending Order ");
    }

    public static void players() {

        Players player = new Players();



        Map<String, Long> playerMap = player.getPlayers().stream()
                .collect(Collectors.groupingBy(
                        Players::getTeamName,
                        Collectors.summingLong(Players::getScore)
                ));

        String val = playerMap.entrySet().stream()
                .max(Comparator.comparingLong(Map.Entry<String, Long>::getValue))
                .map(Map.Entry::getKey)
                .orElse(null);

        System.out.println(playerMap);
        System.out.println(val);

    }

    private static void firstNonRepeatedCharacter(String str) {

        // Brute Force Approach
        char ch = '\0';
        for (int i = 0; i < str.length(); i++) {

            char x = str.charAt(i);
            boolean present = false;

            for (int j = 0; j < str.length(); j++) {
                if (i != j && str.charAt(i) == str.charAt(j)) {
                    present = true;
                    break;
                }
            }

            if (!present) {
                ch = x;
                break;
            }
        }
        System.out.println(ch);


        // First non-Repeating Character
        Character ch2 = str.chars()
                .mapToObj(s -> (char) s)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(c -> c.getValue() == 1)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);

        // First Repeating Character
        Character ch3 = str.chars()
                .mapToObj(s -> (char) s)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        LinkedHashMap::new,
                        Collectors.counting()
                ))
                .entrySet()
                .stream()
                .filter(c -> c.getValue() > 1)
                .findFirst()
                .map(Map.Entry::getKey)
                .orElse(null);


        System.out.println(ch2);
        System.out.println(ch3);
    }
}
