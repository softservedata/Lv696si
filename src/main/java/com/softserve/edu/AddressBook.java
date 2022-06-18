package com.softserve.edu;

import java.util.Objects;

public class AddressBook {
    private NameAddressPair[] addressBook;
    private int counter = 0;

    public AddressBook(int capacity) {
        addressBook = new NameAddressPair[capacity];
    }


    public boolean create(String firstName, String lastName,String address) {
        for (int i = 0; i < counter; i++) {
            if (addressBook[i].person.equals(new NameAddressPair.Person(firstName, lastName))) {
                addressBook[i].address = address;
                return false;
            }
        }
        NameAddressPair addressPair
                = new NameAddressPair(new NameAddressPair.Person(firstName,lastName), address);
        addressBook [counter] = addressPair;
        counter++;
        if (counter == addressBook.length) {
            NameAddressPair[] newAddressBook = new NameAddressPair[counter * 2];
            for (int i = 0; i < counter; i++) {
                newAddressBook[i] = addressBook[i];
            }
            addressBook = newAddressBook;
        }
        return true;
    }



    private static class NameAddressPair{
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

        }
    }
}
