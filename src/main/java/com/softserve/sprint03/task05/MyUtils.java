package com.softserve.sprint03.task05;


import java.util.*;

public class MyUtils {
    public static class Student {
        private int id;
        private String name;

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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Student student = (Student) o;
            return getId() == student.getId() && Objects.equals(getName(), student.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }

    public Set<Student> commonStudents(List<Student> list1, List<Student> list2) {
        if (list1 == null) {
            list1 = new ArrayList<>();
        }
        if (list2 == null) {
            list2 = new ArrayList<>();
        }
        Set<Student> s1 = new HashSet<>(list1);
        Set<Student> s2 = new HashSet<>(list2);
        s1.retainAll(s2);
        return s1;
    }
}