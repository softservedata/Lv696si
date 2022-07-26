package com.softserve.edu;


import java.util.*;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyUtils {
    public int sumEven(Stream<IntStream> stream) {
        int result = 0;
        for (IntStream str : stream.collect(Collectors.toList())) {
            int sum = str.filter(new IntPredicate() {
                @Override
                public boolean test(int value) {
                    return value % 2 == 0 && value > 0;
                }
            }).sum();
        }
        return result;
    }

    public static void main(String[] args) {
        MyUtils myUtils = new MyUtils();

    }
}
