package org.example;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Period;
import static java.time.temporal.ChronoUnit.DAYS;

public class Employee {
    private String name;
    private String position;
    private String phoneNumber;
    private BigDecimal salary;
    private LocalDate birthdate;

    public Employee(String name, String position, String phoneNumber, BigDecimal salary, LocalDate birthdate) {
        this.name = name;
        this.position = position;
        this.phoneNumber = phoneNumber;
        this.salary = salary;
        this.birthdate = birthdate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public int getAge() {
        LocalDate currentDate = LocalDate.now();
        return Period.between(birthdate, currentDate).getYears();
    }


    @Override
    public String toString() {
        return String.format("""
                        Name: %s
                        position: %s
                        phone number: %s
                        salary: %s
                        birthdate: %s
                        age: %d
                        """
                , name, position, phoneNumber, salary, birthdate, this.getAge());
    }

    public void printInfo() {
        System.out.println(this);
    }




    /*
    Написать прототип компаратора - метод внутри класса сотрудника,
    сравнивающий две даты, представленные в виде трёх чисел гггг-мм-дд,
    без использования условного оператора.
    */
    public static int Comparator(LocalDate firstDate, LocalDate secondDate) {
        return (int) DAYS.between(firstDate, secondDate);
    }
}

