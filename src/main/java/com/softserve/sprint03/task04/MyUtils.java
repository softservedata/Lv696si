package com.softserve.sprint03.task04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyUtils {
    // Code
    public Map<String, List<String>> createNotebook(Map<String, String> phones) {
        Map<String, List<String>> result = new HashMap<>();
        if (phones == null) {
            return result;
        }
        for (Map.Entry<String, String> entry : phones.entrySet()) {
            List<String> list = result.get(entry.getValue());
            if (list == null) {
                list = new ArrayList<>();
                result.put(entry.getValue(), list);
            }
            list.add(entry.getKey());
        }
        return result;
    }
}
