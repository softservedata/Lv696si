package com.softserve.sprint03.task02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyUtils {

    public static class ByLengthAndAbc implements Comparator<String> {
        @Override
        public int compare(String str1, String str2) {
            if ((str1 == null) && (str1 == null)) {
                return 0;
            }
            if (str1 == null) {
                return -1;
            }
            if (str2 == null) {
                return 1;
            }
            int result = str1.length() - str2.length();
            return result == 0 ? str1.compareTo(str2) : result;
        }
    }

    public List<String> strSort(List<String> originList) {
        List<String> result = new ArrayList<>();
        if (originList == null) {
            return result;
        }
        result.addAll(originList);
        Collections.sort(result, new ByLengthAndAbc());
        return result;
    }
}