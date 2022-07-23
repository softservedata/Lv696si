package com.softserve.edu;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyUtils {
    public Stream<String> nameList(Map<String, Stream<String>> map) {
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Stream<String>> entry : map.entrySet()) {
            if (entry.getValue() == null) {
                continue;
            }
            List<String> temp;
            temp = entry.getValue().collect(Collectors.toList());
            for (String name: temp) {
                if (name == null) {
                    continue;
                }
                name = name.replaceAll(" ", "").toLowerCase();
                if (name.isEmpty()) {
                    continue;
                }

                name = name.substring(0, 1).toUpperCase() + name.substring(1);
                result.add(name);
            }
        }
        return result.stream().distinct().sorted(String::compareTo);
    }

    public static void main(String[] args) {
        MyUtils myUtils = new MyUtils();
        List<String> list1 = Arrays.asList(" iVan", "PeTro ", " Ira ");
        List<String> list2 = Arrays.asList("STepan", "ira ", " Andriy ", "an na");
        List<String> list3 = Arrays.asList(null, "Anna");
        Map<String , Stream<String>> map = new HashMap<>();
        map.put("1", list1.stream());
        map.put("2", list2.stream());
        map.put("3", list3.stream());
        Stream<String> str = myUtils.nameList(map);
        str.forEach(System.out::println);
    }
}
