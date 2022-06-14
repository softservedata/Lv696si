package com.softserve.edu;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
    }
}

class User {
    protected String  name, surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getFullName() {
        return  name + " " + surname;
    }
}
class Student extends User {
    protected int year;

    public Student(int year, String name, String surname) {
        super(name, surname);
        this.year = year;
    }

    public int getCourseNumber() {
        int result = Calendar.YEAR - year + 1;
        if (result > 6)
            return -1;
        else return result;
    }

}

