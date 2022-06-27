package com.softserve.sprint03.task03;

import java.util.*;

public class MyUtils {
    // Code
    public boolean listMapCompare(List<String> list, Map<String, String> map) {
        Set<String> set1 = new HashSet<>(list);
        Set<String> set2 = new HashSet<>(map.values());
        return set1.equals(set2);
    }
}