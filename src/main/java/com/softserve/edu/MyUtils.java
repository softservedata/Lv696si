package com.softserve.edu;

import java.util.function.Predicate;
import java.util.function.BiFunction;
import java.util.ArrayList;
import java.util.List;


class MyUtils {

    public static int findMaxByCondition(List<Integer> numbers, Predicate<Integer> pr) {
        int result = numbers.get(0);
        for (Integer number : numbers) {
            if (number > result && pr.test(number)) {
                result = number;
            }
        }
        return result;
    }
}

class User {
    public final List<Integer> values = new ArrayList<Integer>();

    int getFilterdValue(int maxByCondition, Predicate<Integer> predicate) {

        int result = maxByCondition;
        for (Integer value: values) {
            if (value == maxByCondition && predicate.test(value)) {
                result = value;
            }
        }
        return result;
    }

    int getMaxValueByCondition(Predicate<Integer> predicate) {

        // Write your code here
    return 0;
    }
}


