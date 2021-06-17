package co.edu.icesi.back.service.interfaces;

import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.back.model.Person;


public interface PersonService {
	
	public Person createPerson(Person person) throws LogicalException;
	
	public Person updatePerson(Person person) throws LogicalException;
	
	public Person getPersonById(long id) throws LogicalException;
	
	public Iterable<Person> findAll();
	
	public void delete(long id) throws LogicalException;

}
