package com.proquest.interview.phonebook;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

import com.proquest.interview.util.DatabaseUtil;


public class PhoneBookImpl implements PhoneBook {

    public List<Person> people = new ArrayList<>();

    public PhoneBookImpl() {
        super();
    }

    /**
     * @param newPerson
     */
    @Override
    public void addPerson(Person newPerson) {
        people.add(nonNull(newPerson) ? newPerson : null);
    }

    /**
     * @return
     */
    @Override
    public List<Person> allPerson() {
        return people.stream().collect(Collectors.toList());
    }

    /**
     * @param firstName
     * @param lastName
     * @return
     */
    @Override
    public Person findPerson(String firstName, String lastName) {

        if (isNull(firstName) || isNull(lastName)) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        final String name = firstName + " " + lastName;
        for (Person person : people) {
            if (person.getName().equals(name)) {
                return person;
            }
        }
        return null;
    }

    private void printPhoneBook() {
        for (Person person : this.people) {
            System.out.println(person);
        }
    }

    public static void main(String[] args) {
        DatabaseUtil.initDB();  //You should not remove this line, it creates the in-memory database

        /* create person objects and put them in the PhoneBook and database
         * John Smith, (248) 123-4567, 1234 Sand Hill Dr, Royal Oak, MI
         * Cynthia Smith, (824) 128-8758, 875 Main St, Ann Arbor, MI
         */
        PhoneBookImpl phoneBook = new PhoneBookImpl();
        Person firstPerson = new Person.PersonBuilder().name("John Smith").phoneNumber("(248) 123-4567").address("1234 Sand Hill Dr, Royal Oak, MI").build();
        Person secondPerson = new Person.PersonBuilder().name("Cynthia Smith").phoneNumber("(824) 128-8758").address("875 Main St, Ann Arbor, MI").build();
        phoneBook.addPerson(firstPerson);
        phoneBook.addPerson(secondPerson);

        //print the phone book out to System.out
        phoneBook.printPhoneBook();

        // find Cynthia Smith and print out just her entry
        Person cynthia = phoneBook.findPerson("Cynthia", "Smith");
        System.out.println(cynthia);

        // insert the new person objects into the database
        DatabaseUtil.addNewPersonToDB(firstPerson.getName(), firstPerson.getPhoneNumber(), firstPerson.getAddress());
        DatabaseUtil.addNewPersonToDB(secondPerson.getName(), secondPerson.getPhoneNumber(), secondPerson.getAddress());
    }
}
