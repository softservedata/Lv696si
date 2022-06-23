package com.softserve.sprint03.task04;

import java.util.HashMap;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        MyUtils mu = new MyUtils();
        //
        Map<String, String> phones = new HashMap<>();
        phones.put("0967654321", "Petro");
        phones.put("0677654321", "Petro");
        phones.put("0501234567", "Ivan");
        phones.put("0970011223", "Stepan");
        phones.put("0631234567", "Ivan");
        phones.put(null, null);
        //
        System.out.println("result = " + mu.createNotebook(phones));
        //System.out.println("result = " + mu.createNotebook(null));
    }
}
