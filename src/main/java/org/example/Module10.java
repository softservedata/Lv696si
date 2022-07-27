package org.example;

import java.util.Arrays;
import java.util.Comparator;

/* Create a Wrapper generic class with generic private field of type T named value.

Also in the Wrapper class define a parametrized public constructor and access methods with setValue and getValue name.*/
class M10Task1 <T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public M10Task1(T value) {
        this.value = value;
    }
}

/* In the class ArrayUtil write a public static generic method named "setAndReturn(...)" to modify and return
the element in an array from the given position.
*/

class M10Task2 {
    public static <T> T setAndReturn(T[] arr, T setValue, int position) {
        arr[position] = setValue;
        return setValue;
    }
}

/* In the class ArrayUtil write static method named "averageValue(...)" that takes an object of Array type as input,
and returns the average value its elements.

The given method should returns value of double type and take any array, whose elements extends Number type */

class M10Task4 {
    public static double averageValue(Array<? extends Number> arr) {
        double sum = 0;
        for (int i = 0; i < arr.length(); i++) {
            sum = sum + arr.get(i).doubleValue();
        }
        return sum/arr.length();
    }
}

/* Create classes with name PersonComparator, EmployeeComparator, DeveloperComparator that implenent the
Comparator<Type> generic interface.

In the Utility class create public static method named sortPeople(...) that takes an array of Person
type and derivative from it types, and comparator as input, and returns the value of void type.

Also, as second argument the method sortPeople(...) can takes generic comparator for elements of Object type.

The sortPeople(...) method should sorted records by ascending. At first by name, then by age, then by salary,
and then by Level (JUNIOR < MIDDLE < SENIOR) */

class PersonComparator implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        if (o1.getName().compareTo(o2.getName()) == 0) {
            return o1.getAge() - o2.getAge();
        } else {
            return o1.getName().compareTo(o2.getName());
        }
    }
}

class EmployeeComparator implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        if (o1.getName().compareTo(o2.getName()) == 0) {
            if (o1.getAge() - o2.getAge() == 0) {
                return Double.compare(o1.getSalary(), o2.getSalary());
            } else {
                return o1.getAge() - o2.getAge();
            }
        } else {
            return o1.getName().compareTo(o2.getName());
        }
    }
}

class DeveloperComparator implements Comparator<Developer> {

    @Override
    public int compare(Developer o1, Developer o2) {
        if (o1.getName().compareTo(o2.getName()) == 0) {
            if (o1.getAge() - o2.getAge() == 0) {
                if (Double.compare(o1.getSalary(), o2.getSalary()) == 0) {
                    return o1.getLevel().compareTo(o2.getLevel());
                } else {
                    return Double.compare(o1.getSalary(), o2.getSalary());
                }
            } else {
                return o1.getAge() - o2.getAge();
            }
        } else {
            return o1.getName().compareTo(o2.getName());
        }
    }
}

class M10Task5 {

    public static <T extends Person> void sortPeople(T[] people, Comparator<? super T> comparator) {
        Arrays.sort(people, comparator);
    }
}