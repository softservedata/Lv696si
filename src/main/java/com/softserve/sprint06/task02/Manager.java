package com.softserve.sprint06.task02;

import java.math.BigDecimal;
import java.util.Objects;

class Manager extends Employee {
    private double coefficient;

    public Manager(String name, int experience, BigDecimal basePayment, double coefficient) {
        super(name, experience, basePayment);
        this.coefficient = coefficient;
    }

    public double getCoefficient() {
        return coefficient;
    }

    @Override
    public BigDecimal getPayment() {
        //return super.getPayment();
        //return super.getPayment() * coefficient;
        return super.getPayment().multiply(BigDecimal.valueOf(getCoefficient())).setScale(2);
    }

    @Override
    public boolean equals(Object o) { // TODO Employee ****UPDATE
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Manager manager = (Manager) o;
        return Double.compare(manager.getCoefficient(), getCoefficient()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getCoefficient());
    }

    @Override
    public String toString() {
        return "Manager{" + " " + super.toString() +
                " coefficient=" + coefficient +
                '}';
    }

}