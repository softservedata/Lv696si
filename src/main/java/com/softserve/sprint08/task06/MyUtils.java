package com.softserve.sprint08.task06;

import java.util.function.BiFunction;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class MyUtils {
    public static int findMaxByCondition(List<Integer> numbers, Predicate<Integer> pr) {
        if (numbers == null) {
            return 0;
        }
        return numbers.stream().filter(pr).max((a,b)->a-b).orElse(0);
    }
}

class User {
    public final List<Integer> values = new ArrayList<Integer>();

    int getFilterdValue(BiFunction<List<Integer>, Predicate<Integer>, Integer> findMax,
                        Predicate<Integer> predicate) {
        return findMax.apply(values, predicate);
    }

    int getMaxValueByCondition(Predicate<Integer> predicate) {
        return getFilterdValue(MyUtils::findMaxByCondition,predicate);
    }
}

/*
@FunctionalInterface
interface IFindMax {
    int findMaxByCondition(List<Integer> numbers, Predicate<Integer> pr);
}

class User {
    public final List<Integer> values = new ArrayList<Integer>();

    int getFilterdValue(IFindMax findMax, Predicate<Integer> predicate) {
        return findMax.findMaxByCondition(values, predicate);
    }

    int getMaxValueByCondition(Predicate<Integer> predicate) {
        return getFilterdValue(MyUtils::findMaxByCondition,predicate);
    }
}
*/
