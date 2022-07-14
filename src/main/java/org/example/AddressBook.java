package org.example;

import java.util.*;

public class AddressBook implements Iterable {

    private NameAddressPair[] addressBook;
    private int counter = 0;

    private class AddressBookIterator implements Iterator {
        private int counter = -1;

        public boolean hasNext() {
            return addressBook.length > (counter + 1);
        }

        public String next() {
            counter++;
            return addressBook[counter].toString();
        }

        @Override
        public void remove() {
        }
    }
    private static class NameAddressPair {
        private final Person person;
        private String address;

        private NameAddressPair(Person person, String address) {
            this.address = address;
            this.person = person;
        }

        @Override
        public String toString() {
            return "First name: " + this.person.firstName + ", Last name: " +
                    this.person.lastName + ", Address: " + this.address;
        }

        private static final class Person {
            private final String firstName;
            private final String lastName;

            private Person(String firstName, String lastName) {
                this.firstName = firstName;
                this.lastName = lastName;
            }

            @Override
            public boolean equals(Object o) {
                if (this == o) return true;
                if (o == null || getClass() != o.getClass()) return false;
                Person person = (Person) o;
                return Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName);
            }

            @Override
            public int hashCode() {
                return Objects.hash(firstName, lastName);
            }

            @Override
            public String toString() {
                return "Person{" +
                        "firstName='" + firstName + '\'' +
                        ", lastName='" + lastName + '\'' +
                        '}';
            }
        }
    }

    public Iterator iterator() {
        return new AddressBookIterator();
    }

    public AddressBook(int capacity) {
        addressBook = new NameAddressPair[capacity];
    }

    public boolean create(String firstName, String lastName, String address) {
        NameAddressPair.Person testPerson = new NameAddressPair.Person(firstName, lastName);
        for (NameAddressPair nap : addressBook) {
            if (nap == null)
                continue;
            if(nap.person.equals(testPerson))
                return false;
        }
        if(counter == addressBook.length)
            addressBook = Arrays.copyOf(addressBook, addressBook.length*2);
        addressBook[counter] = new NameAddressPair(testPerson, address);
        counter++;
        return true;
    }

    public String read(String firstName, String lastName) {
        NameAddressPair.Person testPerson = new NameAddressPair.Person(firstName, lastName);
        for (NameAddressPair nap : addressBook) {
            if (nap == null)
                continue;
            if (nap.person.equals(testPerson))
                return nap.address;
        }
        return null;
    }

    public boolean update(String firstName, String lastName, String address) {
        NameAddressPair.Person testPerson = new NameAddressPair.Person(firstName, lastName);
        for (NameAddressPair nap : addressBook) {
            if (nap == null)
                continue;
            if (nap.person.equals(testPerson)) {
                nap.address = address;
                return true;
            }
        }
        return false;
    }

    public boolean delete(String firstName, String lastName) {
        NameAddressPair.Person testPerson = new NameAddressPair.Person(firstName, lastName);
        for (int index = 0; index < addressBook.length; index++) {
            NameAddressPair nap = addressBook[index];
            if (nap == null)
                continue;
            if (nap.person.equals(testPerson)) {
                addressBook[index] = null;
                ArrayList<NameAddressPair> arr = new ArrayList<>(Arrays.asList(addressBook));
                arr.remove(index);
                addressBook = arr.toArray(new NameAddressPair[0]);
                return true;
            }
        }
        return false;
    }

    public int size() {
        int count = 0;
        for (NameAddressPair nap : addressBook) {
            if (nap != null)
                count++;
        }
        return count;
    }

    class sortByFirstName implements Comparator<NameAddressPair> {
        public int compare(NameAddressPair a, NameAddressPair b) {
            int firstNameComparisonResult = a.person.firstName.compareTo(b.person.firstName);
            int lastNameComparisonResult = a.person.lastName.compareTo(b.person.lastName);
            if (firstNameComparisonResult == 0) {
                return lastNameComparisonResult;
            }
            return firstNameComparisonResult;
        }
    }

    public void sortedBy(SortOrder order) {
        switch (order) {
            case ASC:
                Arrays.sort(addressBook, new sortByFirstName());
                break;
            case DESC:
                Arrays.sort(addressBook, Collections.reverseOrder(new sortByFirstName()));
                break;
        }
    }
}

enum SortOrder {
    ASC, DESC
}
