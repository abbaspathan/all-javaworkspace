package com.capgemini.spring.mvc.model.entity;

public class Person {

		private int PersonId;
		private String personName;
		public Person() {
			super();
			
		}
		public Person(int personId, String personName) {
			super();
			PersonId = personId;
			this.personName = personName;
		}
		public int getPersonId() {
			return PersonId;
		}
		public void setPersonId(int personId) {
			PersonId = personId;
		}
		public String getPersonName() {
			return personName;
		}
		public void setPersonName(String personName) {
			this.personName = personName;
		}
}
