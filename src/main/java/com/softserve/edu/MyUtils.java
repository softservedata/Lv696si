package com.softserve.edu;


import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class MyUtils {
    public static String getDateAfterToday(int years, int months, int days) {
        LocalDate localDate = LocalDate.now();
        localDate = localDate.plusDays(days).plusMonths(months).plusYears(years);
        return localDate.toString();
    }

    public static void main(String[] args) {
        System.out.println(getDateAfterToday(2, 1, 1));
    }
}
