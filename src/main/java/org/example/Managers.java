package org.example;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Managers extends Employee{
    private String name;
    private String position;
    private String phoneNumber;
    private BigDecimal salary;
    private LocalDate birthdate;

    public Managers(String name, String position, String phoneNumber, BigDecimal salary, LocalDate birthdate) {
        super(name, position, phoneNumber, salary, birthdate);
    }

    public static void increaseSalary(Employee employee, int value) {
        BigDecimal averageSalaries = BigDecimal.ZERO;
        if (employee.getPosition().equals("Manager"))
            return;
        averageSalaries = employee.getSalary();
        employee.setSalary(averageSalaries.add(BigDecimal.valueOf(value)));
    }
}