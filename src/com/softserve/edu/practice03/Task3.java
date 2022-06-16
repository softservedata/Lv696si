package com.softserve.edu.practice03;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Task3 {
    private List<String> list;
    private Map<String, String> map;

    public Task3(List<String> list, Map<String, String> map) {
        this.list = list;
        this.map = map;
    }

    public boolean listMapCompare() {
        List<String> list = this.list;
        Map<String, String> map = this.map;
        List<String> newList = new ArrayList<>(map.values());
        return list.containsAll(newList);
    }
}
