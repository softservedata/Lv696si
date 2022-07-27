package org.example;

/*Create classes Employee (fields String name, int experience and BigDecimal basePayment) and Manager (field double coefficient)
with methods which return the general working experience and payment for work done.
A getter methods of class Employee return value of all fields: getName(), getExperience() and getPayment().
Classes Manager is derived from class Employee and override getPayment() method to return multiplication of a coefficient and base payment.
Create a largestEmployees() method of the MyUtils class to return a List of unique employees with maximal working experience
and payment without duplicate objects.
The original list must be unchanged.
For example, for a given list
[Employee [name=Ivan, experience=10, basePayment=3000.00], Manager [name=Petro, experience=9, basePayment=3000.00, coefficient=1.5],
Employee [name=Stepan, experience=8, basePayment=4000.00], Employee [name=Andriy, experience=7, basePayment=3500.00],
Employee [name=Ihor, experience=5, basePayment=4500.00], Manager [name=Vasyl, experience=8, basePayment=2000.00, coefficient=2.0]]
you should get
[Employee [name=Ivan, experience=10, basePayment=3000.00],
Manager [name=Petro, experience=9, basePayment=3000.00, coefficient=1.5],
Employee [name=Ihor, experience=5, basePayment=4500.00]].*/

import java.math.BigDecimal;
import java.util.*;

public class EmployeeOld2 {

    private String name;
    private int experience;
    private BigDecimal basePayment;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public BigDecimal getPayment() {
        return basePayment;
    }

    public void setPayment(BigDecimal basePayment) {
        this.basePayment = basePayment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeOld2 employeeOld2 = (EmployeeOld2) o;
        return experience == employeeOld2.experience && Objects.equals(name, employeeOld2.name) && Objects.equals(basePayment, employeeOld2.basePayment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, experience, basePayment);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", experience=" + experience +
                ", basePayment=" + basePayment +
                '}';
    }

    public EmployeeOld2(String name, int experience, BigDecimal basePayment) {
        this.name = name;
        this.experience = experience;
        this.basePayment = basePayment;
    }
}
class Manager extends EmployeeOld2 {

    private double coefficient;

    public double getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(double coefficient) {
        this.coefficient = coefficient;
    }

    public BigDecimal getPayment() {
        return super.getPayment().multiply(BigDecimal.valueOf(coefficient));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Manager manager = (Manager) o;
        return Double.compare(manager.coefficient, coefficient) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(coefficient);
    }

    public Manager(String name, int experience, BigDecimal basePayment, double coefficient) {
        super(name, experience, basePayment);
        this.coefficient = coefficient;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", Manager coefficient=" + coefficient +
                '}';
    }
}
