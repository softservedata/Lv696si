package com.softserve.sprint06.task02;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class ExperienceComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1 == null && o2 == null) {
            return 0;
        } else if (o1 == null) {
            return -1;
        } else if (o2 == null) {
            return 1;
        }
        return o1.getExperience() - o2.getExperience();
    }
}

class PaymentComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1 == null && o2 == null) {
            return 0;
        } else if (o1 == null) {
            return -1;
        } else if (o2 == null) {
            return 1;
        }
        return o1.getPayment().compareTo(o2.getPayment());
    }
}

public class MyUtils {
    public List<Employee> largest(List<Employee> result, List<Employee> workers, Comparator<Employee> comparator) {
        if (workers == null) {
            return null;
        }
        if (workers.size() == 0) {
            return result;
        }
        List<Employee> temp = new ArrayList<>(workers);
        Employee maxEmployee = Collections.max(temp, comparator);
        do {
            if (!result.contains(maxEmployee)) {
                // System.out.println("\n***result " + result);
                // System.out.println("***maxEmployee " + maxEmployee);
                result.add(maxEmployee);
            }
            temp.remove(maxEmployee);
            if (temp.size() > 0) {
                maxEmployee = Collections.max(temp, comparator);
            }
        } while ((temp.size() > 0) && (comparator.compare(result.get(result.size() - 1), maxEmployee) == 0));
        //
        return result;
    }

    public List<Employee> largestEmployees(List<Employee> workers) {
        List<Employee> result = new ArrayList<>();
        result = largest(result, workers, new ExperienceComparator());
        result = largest(result, workers, new PaymentComparator());
        return result;
    }
}