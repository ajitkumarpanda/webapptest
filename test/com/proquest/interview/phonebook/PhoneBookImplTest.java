package com.proquest.interview.phonebook;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PhoneBookImplTest {
	private PhoneBook phoneBook;

	@Before
	public void setUp() {
		phoneBook = new PhoneBookImpl();
		phoneBook.addPerson(new Person.PersonBuilder().name("Ajit Panda").phoneNumber("(44) 1234456789").address("1234 Leeds United Kingdom").build());
	}

	@Test
	public void checkEmptyPhoneBook() {
		phoneBook = new PhoneBookImpl();
		assertEquals(phoneBook.allPerson().size(), 0);
	}

	@Test
	public void addPerson() {
		int personCount = phoneBook.allPerson().size();
		phoneBook.addPerson(new Person.PersonBuilder().name("test name").phoneNumber("(44) 1234456789").address("1234 Test Address").build());
		assertEquals(phoneBook.allPerson().size(), personCount + 1);
	}

	@Test(expected=IllegalArgumentException.class)
	public void addNullPerson(){
		phoneBook.addPerson(null);
	}

	@Test
	public void validFindPerson() {
		assertNotNull(phoneBook.findPerson("Ajit", "Panda"));
	}

	@Test
	public void noSuchPersonTest() {
		assertNull(phoneBook.findPerson("Ajit", "Kumar"));
	}


	@Test(expected = IllegalArgumentException.class)
	public void findNullFirstNameTest() {
		phoneBook.findPerson(null, "Panda");
	}

	@Test(expected = IllegalArgumentException.class)
	public void findNullLastNameTest() {
		phoneBook.findPerson("Ajit", null);
	}
}
