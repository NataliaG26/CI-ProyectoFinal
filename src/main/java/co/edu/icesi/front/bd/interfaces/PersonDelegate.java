package co.edu.icesi.front.bd.interfaces;

import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.front.model.classes.Person;

public interface PersonDelegate {
	
	public Person createPerson(Person person, long instid) throws LogicalException;
	
	public void updatePerson(Person person, long instid) throws LogicalException;
	
	public Person getPersonById(long id) throws LogicalException;
	
	public Iterable<Person> findAll();
	
	public void delete(long id);

}
