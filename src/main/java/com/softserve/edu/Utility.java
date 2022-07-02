package com.softserve.edu;
import java.util.Arrays;
import java.util.Comparator;

class PersonComparator<Type extends Person> implements Comparator<Type>{
    @Override
    public int compare(Type o1, Type o2) {
         if (o1.getName().compareTo(o2.getName()) == 0) {
             return o1.getAge() - o2.getAge();
         }
         else return o1.getName().compareTo(o2.getName());
    }
}
class EmployeeComparator<Type extends Person> extends PersonComparator<Type> implements Comparator<Type> {
    @Override
    public int compare(Type o1, Type o2) {
        if (super.compare(o1, o2)==0) {
            return Double.compare(((Employee) o2).getSalary(), ((Employee) o1).getSalary());
        }
        else return super.compare(o1, o2);
    }
}
class DeveloperComparator<Type extends Person> extends EmployeeComparator<Type> implements Comparator<Type> {
    @Override
    public int compare(Type o1, Type o2) {
        if (super.compare(o1, o2)==0) {
            return ((Developer)o1).getLevel().toString().compareTo(((Developer)o2).getLevel().toString());
        }
        else return super.compare(o1, o2);
    }
}
public class Utility {
    public static void sortPeople(Person[] persons, Comparator comparator){
        Arrays.sort(persons, comparator);
    }

    public static void main(String[] args) {
        Person[] persons = {new Person("First", 42),
                new Employee("First", 25, 250.0),
        new Developer("Third", 32, 240.0, Level.MIDDLE),
                new Developer("AThird", 32, 240.0, Level.JUNIOR),
                new Developer("AThird", 32, 240.0, Level.SENIOR)};

        sortPeople(persons, new DeveloperComparator<Person>());
        System.out.println(Arrays.toString(persons));
    }
}

class Person {
    String name;
    int age;
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    @Override
    public String toString() {
        return "Name='" + name + ", Age=" + age;
    }
}
class Employee extends Person{
    private double salary;
    public Employee(String name, int age, double salary) {
        super(name, age);
        this.salary = salary;
    }
    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return  super.toString() + ", Salary=" + salary;
    }
}
class Developer extends Employee{
    private Level level;
    public Developer(String name, int age, double salary, Level level) {
        super(name, age, salary);
        this.level = level;
    }
    public Level getLevel() {
        return level;
    }

    @Override
    public String toString() {
        return super.toString() + ", Level=" + level.name();
    }
}
enum Level {
    JUNIOR, MIDDLE, SENIOR
}