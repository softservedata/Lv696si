package com.softserve.edu;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUtils {
    public Map<String, Stream<String>> phoneNumbers(List<Stream<String>> list) {
        Map<String, Stream<String>> result = new HashMap<>();
        Map<String, List<String>> previousResult = new HashMap<>();
        for (Stream<String> str: list) {
            List<String> temp = str.collect(Collectors.toList());
            for (String number: temp) {
                number = number.replaceAll("[()\\- ]", "");
                if (number.length() == 10) {
                    if (previousResult.containsKey(number.substring(0,3))) {
                        List<String> list1 = previousResult.get(number.substring(0,3));
                        list1.add(number.substring(3));
                    }
                    else {
                        List<String> list1 = new LinkedList<>();
                        list1.add(number.substring(3));
                        previousResult.put(number.substring(0,3), list1);
                    }
                }
                if (number.length() == 7) {
                    if (previousResult.containsKey("loc")) {
                        List<String> list1 = previousResult.get(number.substring(0,3));
                        list1.add(number);
                    }
                    else {
                        List<String> list1 = new LinkedList<>();
                        list1.add(number);
                        previousResult.put("loc", list1);
                    }
                }
                if (number.length() != 7 && number.length() != 7) {
                    if (previousResult.containsKey("err")) {
                        List<String> list1 = previousResult.get(number.substring(0,3));
                        list1.add(number);
                    }
                    else {
                        List<String> list1 = new LinkedList<>();
                        list1.add(number);
                        previousResult.put("err", list1);
                    }
                }

            }
        }
        for (Map.Entry<String, List<String>> entry : previousResult.entrySet()) {
            result.put(entry.getKey(), entry.getValue().stream());
        }
        return result;
    }

    public static void main(String[] args) {
        MyUtils myUtils = new MyUtils();
        List<String> list1 = Arrays.asList("093 987 65 43", "(050)1234567", "12-345");
        List<String> list2 = Arrays.asList("067-21-436-57", "050-2345678", "0939182736", "224-19-28");
        List<String> list3 = Arrays.asList("(093)-11-22-334", "044 435-62-18", "721-73-45");
        List<Stream<String>> list = new LinkedList<>();
        list.add(list1.stream());
        list.add(list2.stream());
        list.add(list3.stream());
        Map<String, Stream<String>> result = myUtils.phoneNumbers(list);

        for (Map.Entry<String, Stream<String>> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().collect(Collectors.toList()));
        }

    }
}
