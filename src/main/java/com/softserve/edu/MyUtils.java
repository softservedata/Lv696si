package com.softserve.edu;

import java.util.HashSet;
import java.util.function.Predicate;
import java.util.Set;

class MyUtils {

    Predicate<Integer> getPredicateFromSet(Set<Predicate<Integer>> predicates) {
        if (predicates == null) return null;
        Predicate<Integer> result = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return true;
            }
        };
        for (Predicate<Integer> predicate: predicates) {
            result = result.and(predicate);
        }
        return result;
    }

    public static void main(String[] args) {
        Predicate<Integer> predicate1 = (i) -> i > 200;
        Predicate<Integer> predicate2 = (i) -> i < 400;
        Predicate<Integer> predicate3 = (i) -> i/80 != 3;
        Set<Predicate<Integer>> set = new HashSet<>();
        set.add(predicate1);
        set.add(predicate2);
        set.add(predicate3);
        System.out.println(new MyUtils().getPredicateFromSet(set).test(240));
        System.out.println(new MyUtils().getPredicateFromSet(null));
    }
}

