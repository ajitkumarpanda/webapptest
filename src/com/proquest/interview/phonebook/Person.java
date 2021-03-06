package com.proquest.interview.phonebook;

import java.util.Objects;

/**
 *
 */
public class Person {
	private String name;
	private String phoneNumber;
	private String address;

	public String getName() {
		return name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getAddress() {
		return address;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Person person = (Person) o;
		return name.equals(person.name) &&
				phoneNumber.equals(person.phoneNumber) &&
				address.equals(person.address);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, phoneNumber, address);
	}

	@Override
	public String toString() {
		return "Person{" +
				"name='" + name + '\'' +
				", phoneNumber='" + phoneNumber + '\'' +
				", address='" + address + '\'' +
				'}';
	}

	private Person(PersonBuilder builder) {
		this.name = builder.name;
		this.phoneNumber = builder.phoneNumber;
		this.address = builder.address;
	}

	public static class PersonBuilder{
		private String name;
		private String phoneNumber;
		private String address;



		public PersonBuilder name(String name) {
			this.name = name;
			return this;
		}

		public PersonBuilder phoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
			return this;
		}

		public PersonBuilder address(String address) {
			this.address = address;
			return this;
		}

		public Person build(){
			return new Person(this);
		}

	}

}
