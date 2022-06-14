package com.softserve.edu;


import java.util.*;



public class App1 {
    public static void main(String[] args) {
        //List<String> list = Arrays.asList("aa", null, "cc");
        List<String> list = new ArrayList<>();
        Map<String, String> map = new HashMap<>();
        /*map.put("1", "aa");
        map.put("2", "dd");
        map.put("3", "cc");
        map.put("4", null);
        map.put(null, null);*/
        System.out.println(listMapCompare(list, map));
        System.out.println(listMapCompare1(list, map));
        System.out.println(listMapCompare1(null, null));

    }

    public static boolean listMapCompare(List<String> list, Map<String, String> map) {
        if (list.size() == 0 && map.size() == 0) {
            return true;
        }
        boolean result = false;
        for (String str : list) {
            for (Map.Entry<String, String> entrySet : map.entrySet()) {
                if (str == null && entrySet.getValue() == null) {
                    result = true;
                    break;
                }
                if ((str != null && entrySet.getValue() == null) || (str == null && entrySet.getValue() != null)) {
                    result = false;
                    continue;
                }
                if (str.equals(entrySet.getValue())) {
                    result = true;
                    break;
                } else {
                    result = false;
                }
            }
            if (result == false) {
                return false;
            }
        }
        return result;
    }
    public static boolean listMapCompare1(List<String> list, Map<String, String> map) {
        if (list == null && map == null) {
            return true;
        }
        HashSet<String> set1 = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
        for (String str : list) {
            set1.add(str);
        }
        for (Map.Entry<String, String> entrySet : map.entrySet()) {
            set2.add(entrySet.getValue());
        }
        return set2.containsAll(set1);
    }
}
