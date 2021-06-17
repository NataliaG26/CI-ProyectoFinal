package co.edu.icesi.front.bd.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.front.bd.interfaces.PersonDelegate;
import co.edu.icesi.front.model.classes.Person;

@Component
public class PersonDelegateImpl implements PersonDelegate{
	
	RestTemplate restTemplate;
	final String SERVER="http://localhost:8080/api-rest/person/";
	
	public PersonDelegateImpl() {
		this.restTemplate = new RestTemplate();
	}

	@Override
	public Person createPerson(Person person) throws LogicalException {
		return restTemplate.postForEntity(SERVER + "add/", person, Person.class).getBody();
	}

	@Override
	public void updatePerson(Person person) throws LogicalException {
		restTemplate.put(SERVER + "update/", person, Person.class);
	}

	@Override
	public Person getPersonById(long id) throws LogicalException {
		return restTemplate.getForObject(SERVER + "showPerson/" + id, Person.class);
	}

	@Override
	public Iterable<Person> findAll() {
		Person[] people = restTemplate.getForObject(SERVER, Person[].class);
		List<Person> at;
		try {
			at = Arrays.asList(people);
			return at;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void delete(long id) {
		restTemplate.delete(SERVER + "del/" + id);
	}
}
