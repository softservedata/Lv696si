package org.example;
import java.util.*;


public class App
{
    public static void main(String[ ] args) {
        MyUtils utils = new MyUtils();

        List<MyUtils.Student> list1 = new ArrayList<>();
        list1.add(new MyUtils.Student(1, "Ivan"));
        list1.add(new MyUtils.Student(2, "Petro"));
        list1.add(new MyUtils.Student(3, "Stepan"));

        List<MyUtils.Student> list2 = new ArrayList<>();
        list2.add(new MyUtils.Student(1, "Ivan"));
        list2.add(new MyUtils.Student(4, "Andriy"));
        list2.add(new MyUtils.Student(3, "Stepan"));

        Set<MyUtils.Student> set1;
        set1 = utils.commonStudents(list1, list2);

        System.out.println(set1.toString());
    }
}
