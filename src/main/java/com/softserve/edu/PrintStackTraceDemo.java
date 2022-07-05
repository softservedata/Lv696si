package com.softserve.edu;

import java.io.IOException;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class PrintStackTraceDemo{
    public static void x(){
        try{
            throw new IOException();
        }
        catch (IOException ioe){ //this way of stack trace output is workaround for moodle
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream ps = new PrintStream(byteArrayOutputStream);
            ioe.printStackTrace(ps);
            System.out.println(byteArrayOutputStream);
        }
    }

    public static void t() throws IOException{
        throw new IOException();
    }

    static void a() throws IOException   {
        throw new IOException();
    }

    static void m() throws IOException   {
        throw new IOException();
    }

    public static void main(String[] args) {
        x();
    }
}