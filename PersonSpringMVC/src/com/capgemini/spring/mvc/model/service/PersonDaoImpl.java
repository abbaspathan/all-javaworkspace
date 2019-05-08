package com.capgemini.spring.mvc.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.capgemini.spring.mvc.model.entity.Person;

@Repository
public class PersonDaoImpl implements PersonDao {

	@Autowired
	private JdbcTemplate template;
	
	public void addNew(Person person) {
		template.update("INSERT INTO PERSON VALUES(?,?)",
		new Object[] {person.getPersonId(),person.getPersonName()});
	}

	public List<Person> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public void update(Person person) {
		// TODO Auto-generated method stub
		
	}

	public void delete(int personId) {
		// TODO Auto-generated method stub
		
	}

	public Person getPerson(int personId) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
