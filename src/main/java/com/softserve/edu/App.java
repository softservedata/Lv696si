package com.softserve.edu;

import java.io.*;


public class App {
    public static void main(String[] args) {
        System.out.println(readFile("1.txt"));

    }

    public static String readFile(String filename) {
        String result = "";
        String text = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            while (reader.ready()) {
                text += reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (int i = 0; i < text.length() - 7; i+=7) {
            int charCode = Integer.parseInt(text.substring(i, i + 7));
            result += new Character((char)charCode).toString();
        }
        return result;
    }
}
//10001011111000110000111011011110000110110011001010100000110111111001100100000111010011001011111000111010001000001100110110111111100100100000111010011001011110011111010001000001100011110000111100111100101010000001000110110001

//0100010101111000011000010110110101110000011011000110010100100000011011110110011000100000011101000110010101111000011101000010000001100110011011110111001000100000011101000110010101110011011101000010000001100011011000010111001101100101001000000010001100110001
//
//
