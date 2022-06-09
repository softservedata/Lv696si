package com.softserve.edu03;

import java.util.Comparator;
import java.util.Objects;

public class Person implements Comparable<Person> {

    public static class ByDescName implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            if ((p1 == null) && (p2 == null)) {
                return 0;
            }
            if (p1 == null) {
                return -1;
            }
            if (p2 == null) {
                return 1;
            }
            return -p1.getName().compareTo(p2.getName());
        }
    }

    public class ById implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            if ((p1 == null) && (p2 == null)) {
                return 0;
            }
            if (p1 == null) {
                return -1;
            }
            if (p2 == null) {
                return 1;
            }
            return p1.getId() - p2.getId();
        }
    }

    public static class ByNameAndId implements Comparator<Person> {
        @Override
        public int compare(Person p1, Person p2) {
            if ((p1 == null) && (p2 == null)) {
                return 0;
            }
            if (p1 == null) {
                return -1;
            }
            if (p2 == null) {
                return 1;
            }
            int byName = p1.getName().compareTo(p2.getName());
            return byName == 0 ? p1.getId() - p2.getId() : byName;
        }
    }

    // --------------------------------------------------

    private int id;
    private String name;

    public Person() {
        id = -1; //   this.id
        name = "";
    }

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("\tpublic boolean equals(Object obj) running ...");
        /*
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Person person = (Person) obj;
        return id == person.id && Objects.equals(name, person.name);
        */
        if (this == obj) {
            return true;
        }
        if ((obj == null) || (getClass() != obj.getClass())) {
            return false;
        }
        Person other = (Person) obj;
        if ((id != other.id)
                || ((name == null) && (other.name != null))
                || ((name != null) && (other.name == null))) {
            return false;
        }
        if ((name == null) && (other.name == null)) {
            return true;
        }
        return name.equals(other.name);
    }

    @Override
    public int hashCode() {
        //return Objects.hash(id, name);
        final int prime = 31; // 2^5-1
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public int compareTo(Person person) {
        return getName().compareTo(person.getName());
        //return getId() - person.getId();
    }

    @Override
    public String toString() {
        return "\n\tPerson [" +
                "id=" + id +
                ", name='" + name + '\'' +
                "]";
    }
}

