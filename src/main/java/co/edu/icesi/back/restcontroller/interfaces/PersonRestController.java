package co.edu.icesi.back.restcontroller.interfaces;

import org.springframework.web.bind.annotation.PathVariable;

import co.edu.icesi.back.model.Person;
import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.back.model.Institution;

public interface PersonRestController {
	
	public Iterable<Person> showAll();
	
	public Person showPerson(@PathVariable("id") long id) throws LogicalException;
	
	public Person savePerson(Person person, @PathVariable("instid") long instid) throws LogicalException;
	
	public void deletePerson(@PathVariable("id") long id) throws LogicalException;
	
	public void updatePerson(Person person, @PathVariable("instid") long instid) throws LogicalException;
	
	public void updateInstitution(@PathVariable("id") long id, Institution institution);

}
