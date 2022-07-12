package com.softserve.edu;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;


public class App {
    public static void main(String[] args) {
        LocalDateTime date = LocalDateTime.of(2017, 11, 26, 15, 38);
        Period period = Period.ofYears(1).ofMonths(2).ofDays(3);
        date = date.minus(period);
        System.out.println(date);


    }





    public static void writeFile(String filename, String text) {
        String result = "";
        for (int i = 0; i < text.length(); i++) {
            String txt = Integer.toBinaryString(text.charAt(i));
            for (int j = txt.length(); j < 7; j++) {
                txt = "0" + txt;
            }
            result += txt;
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
            writer.write(result);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//1001000110010111011001101100