package org.example;

import java.util.Calendar;
import java.util.Date;

/*•Implement class User with protected fields name, surname and public method getFullName() which returns name and
 surname with one space between them. Constructor of User define as public with two parameters – for initialization name and surname
•Implement also class Student that is inherited from User. This class must have integer protected field year – the year
of entering university, and public method getCourseNumber() – evaluates year of studying based on year property and current year:
the difference between years + 1. (If the value is not from the range from 1 to 6, the metod should return -1).
 of Student should be public and have 3 parameters: year, name and surname and pass name and surname to the base class.
 (year parameter should be the first.)*/

class User {

    protected String name;
    protected String surname;

    public String getFullName() {
        return name + " " + surname;
    }

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }
}
