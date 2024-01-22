package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.example.Employee.Comparator;

public class Main {
    public static <List> void main(String[] args) {
        Employee employee_00 = new Employee("Ivan Petrov",
                "DevOps",
                "+79998887766",
                BigDecimal.valueOf(100_000),
                LocalDate.of(1988, 9, 21));

        Employee employee_01 = new Employee("Vasiliy Petrov",
                "Programmer",
                "+79998887767",
                BigDecimal.valueOf(30_000),
                LocalDate.of(1991, 3, 14));

        Employee employee_02 = new Employee("Ivan Ivanov",
                "Engineer",
                "+79998887768",
                BigDecimal.valueOf(50_000),
                LocalDate.of(1985, 3, 13));

        Employee employee_03 = new Employee("Alexey Sidorov",
                "analyst",
                "+79998887769",
                BigDecimal.valueOf(70_000),
                LocalDate.of(1989, 3, 13));

        Employee employee_04 = new Employee("Petr Petrov",
                "team leader",
                "+79998887765",
                BigDecimal.valueOf(250_000),
                LocalDate.of(1975, 3, 13));

        Managers managers_00 = new Managers("John Dow",
                "Manager",
                "+79998887765",
                BigDecimal.valueOf(300_000),
                LocalDate.of(1970, 12, 31));

        java.util.List<Employee> employees = new ArrayList<>(Arrays.asList(
                employee_00, employee_01, employee_02, employee_03, employee_04, managers_00
        ));

        for (Employee employee : employees) {
            employee.printInfo();
        }

        salaryIncreaseForEmployees(employees, 45, 30_000);
        System.out.println();

        for (Employee employee : employees) {
            employee.printInfo();
        }


        System.out.println(getAverage(employees));


        // Задание № 1
        System.out.println(Comparator(employee_00.getBirthdate(), employee_01.getBirthdate()));
        System.out.println(Comparator(employee_01.getBirthdate(), employee_00.getBirthdate()));

        // Задание № 2
        System.out.println(getAverageSalaryAndAge(employees));
    }

    public static void salaryIncreaseForEmployees(List<Employee> employees, int ageOlder, int bonusValue) {
        for (Employee employee : employees) {
            if (employee.getAge() > ageOlder) {
                Managers.increaseSalary(employee, bonusValue);
            }
        }
    }

    public static String getAverageSalaryAndAge(List<Employee> employees) {
        double averageSalaries = employees.
                stream().
                mapToDouble(x -> x.getSalary().doubleValue()).
                average().
                orElseThrow();
        int averageAge = (int) employees.stream().mapToInt(Employee::getAge).average().orElseThrow();


        return String.format("Average salary: %s,\n" +
                "Average age: %s",
                averageSalaries, averageAge);
    }

    public static AverageResponseDTO getAverage(List<Employee> employees) {
        return AverageResponseDTO.builder()
                .averageAge(employees.stream().mapToInt(Employee::getAge).average().orElseThrow())
                .averageSalary(employees.stream().mapToDouble(x -> x.getSalary().doubleValue()).average().orElseThrow())
                .averageLettersInName((int) employees.stream().mapToInt(x -> x.getName().length()).average().orElseThrow())
                .build();
    }


}