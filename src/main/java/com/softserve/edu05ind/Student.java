package com.softserve.edu05ind;

import com.softserve.edu03.Person;

public class Student implements Comparable<Student> {

    private int id;
    private String name;
    //
    private static Index index = null;

    public Student() {
        id = -1; //   this.id
        name = "";
    }

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static void setIndex(Index index) {
        Student.index = index;
    }

    @Override
    public int compareTo(Student sudent) {
        if (Student.index == null) {
            // TODO Develop Custom Exception
            throw new RuntimeException("Index not found");
        }
        //System.out.println("compareTo()  from " + this + "  with obj = " + sudent);
        //return getName().compareTo(sudent.getName());
        //return getId() - person.getId();
        //
        return index.getIndex(getName()) - index.getIndex(sudent.getName());
    }

    @Override
    public String toString() {
        return "\n\tStudent [" +
                "id=" + id +
                ", name='" + name + '\'' +
                "]";
    }
}
