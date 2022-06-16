package com.softserve.edu.practice03;

import java.util.Arrays;
import java.util.List;

public class Task2 {
    private List<String> originalList;

    public Task2(List<String> originalList) {
        this.originalList = originalList;
    }

    public List<String> strSort() {
        List<String> originList = this.originalList;
        // Code
        String[] arr = originList.toArray(new String[originList.size()]);

        for(int i = 0; i< arr.length; i++){
            for(int j = 0; j< arr.length - i - 1; j++){
                String upper = arr[j];
                String lower = arr[j+1];
                if (arr[j].length() == arr[j+1].length()){
                    if(upper.compareTo(lower) > 0){
                        String temp = arr[j];
                        arr[j] = arr[j+1];
                        arr[j+1] = temp;
                    }
                } else if(arr[j].length() > arr[j+1].length()){
                    String temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }

        return Arrays.asList(arr);
    }
}
