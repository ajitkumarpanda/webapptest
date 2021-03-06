package com.proquest.interview.phonebook;

import java.util.List;

public interface PhoneBook {
	/**
	 * @param firstName
	 * @param lastName
	 * @return
	 */
	Person findPerson(String firstName, String lastName);

	/**
	 * @param newPerson
	 */
	void addPerson(Person newPerson);

	/**
	 * @return
	 */
	List<Person> allPerson();
}
