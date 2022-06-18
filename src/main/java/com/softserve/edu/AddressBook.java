package com.softserve.edu;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Objects;

public class AddressBook implements Iterable{
    private NameAddressPair[] addressBook;

    public NameAddressPair[] getAddressBook() {
        return addressBook;
    }

    private int counter = 0;

    public AddressBook(int capacity) {
        addressBook = new NameAddressPair[capacity];
    }

    public boolean create(String firstName, String lastName, String address) {
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].person.equals(new NameAddressPair.Person(firstName, lastName))) {
                addressBook[i].address = address;
                return false;
            }
        }
        NameAddressPair addressPair
                = new NameAddressPair(new NameAddressPair.Person(firstName, lastName), address);
        addressBook[counter] = addressPair;
        counter++;
        if (counter == addressBook.length) {
            NameAddressPair[] newAddressBook = new NameAddressPair[counter * 2];
            System.arraycopy(addressBook, 0, newAddressBook, 0, counter);
            addressBook = newAddressBook;
        }
        return true;
    }

    public String read(String firstName, String lastName) {
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].person.equals(new NameAddressPair.Person(firstName, lastName)))
                return addressBook[i].address;
        }
        return null;
    }

    public boolean update(String firstName, String lastName, String address) {
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].person.equals(new NameAddressPair.Person(firstName, lastName))) {
                addressBook[i].address = address;
                return true;
            }
        }
        return false;
    }

    public boolean delete(String firstName, String lastName) {
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].person.equals(new NameAddressPair.Person(firstName, lastName))) {
                addressBook[i] = null;
                NameAddressPair[] newAddressBook = new NameAddressPair[counter];
                int k = 0;
                for (int j = 0; j < counter; j++) {
                    if (addressBook[j] != null) {
                        newAddressBook[k] = addressBook[j];
                        k++;
                    }
                }
                addressBook = newAddressBook;
                counter--;
                return true;
            }
        }
        return false;
    }

    public int size() {
        return counter;
    }

    public void sortedBy(SortOrder order) {
        Arrays.sort(addressBook, new Comparator<NameAddressPair>() {
            @Override
            public int compare(NameAddressPair o1, NameAddressPair o2) {
                if (o1 == null || o2 == null) {
                    return 0;
                }
                if (order.equals(SortOrder.ASC)) {
                    if (o1.person.firstName.compareTo(o2.person.firstName) == 0) {
                        return o1.person.lastName.compareTo(o2.person.lastName);
                    } else return o1.person.firstName.compareTo(o2.person.firstName);
                }
                if (order.equals(SortOrder.DESC)) {
                    if (o1.person.firstName.compareTo(o2.person.firstName) == 0) {
                        return -o1.person.lastName.compareTo(o2.person.lastName);
                    } else return -o1.person.firstName.compareTo(o2.person.firstName);
                }
                return 0;
            }
        });
    }

    @Override
    public Iterator iterator() {
        return new AddressBookIterator();
    }


    private static class NameAddressPair {
        private Person person;
        private String address;

        private NameAddressPair(Person person, String address) {
            this.person = person;
            this.address = address;
        }

        private static class Person {
            private String firstName;
            private String lastName;

            private Person(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (!(o instanceof Person)) return false;
                Person person = (Person) o;
                return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
            }

            @Override
            public String toString() {
                return "Person{" +
                        "firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "NameAddressPair{" +
                    "person=" + person +
                    ", address='" + address + '\'' +
                    '}';
        }
    }

    enum SortOrder {
        ASC, DESC;
    }

    private class AddressBookIterator implements Iterator{
        private int counter = 0;
        @Override
        public boolean hasNext() {
            if (counter >=0 && counter < addressBook.length && addressBook[counter] != null){
                return true;
            }
            else return false;
        }

        @Override
        public String next() {
            NameAddressPair result = addressBook[counter];
            counter++;
            return "First name: " + result.person.firstName + ", Last name: " +
                    result.person.lastName + ", Address: " + result.address;
        }
    }

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook(2);
        addressBook.create("a", "c", "ffff");
        addressBook.create("a", "b", "ffff");
        addressBook.create("b", "b", "ffff");
        addressBook.create("a", "c", "ddd");
        addressBook.delete("a", "b");
        System.out.println(Arrays.toString(addressBook.getAddressBook()));
        addressBook.sortedBy(SortOrder.DESC);
        System.out.println(Arrays.toString(addressBook.getAddressBook()));
        System.out.println(addressBook.read("b","b"));
    }

    @Override
    public String toString() {
        return "AddressBook{" +
                "addressBook=" + Arrays.toString(addressBook) +
                '}';
    }
    enum directions {
        NORTH(1), SOuth(2);
        public int value;
        directions(int i) {
            this.value = i;
        }
    }
}
