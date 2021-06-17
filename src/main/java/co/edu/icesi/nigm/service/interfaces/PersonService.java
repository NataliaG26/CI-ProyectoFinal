package co.edu.icesi.nigm.service.interfaces;

import co.edu.icesi.nigm.exception.LogicalException;
import co.edu.icesi.nigm.model.Person;


public interface PersonService {
	
	public Person createPerson(Person person) throws LogicalException;
	
	public Person updatePerson(Person person) throws LogicalException;
	
	public Person getPersonById(long id) throws LogicalException;
	
	public Iterable<Person> findAll();
	
	public void delete(Person person);

}
