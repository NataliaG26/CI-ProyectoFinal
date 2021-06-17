package co.edu.icesi.back.restcontroller.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.back.model.Person;
import co.edu.icesi.back.model.Institution;
import co.edu.icesi.back.restcontroller.interfaces.PersonRestController;
import co.edu.icesi.back.service.interfaces.PersonService;

@RestController
@RequestMapping("/api-rest/person")
public class PersonRestControllerImpl implements PersonRestController {
	
	@Autowired
	private PersonService personService;

	@Override
	@GetMapping("/")
	public Iterable<Person> showAll() {
		return personService.findAll();
	}

	@Override
	@GetMapping("show/{id}")
	public Person showPerson(@PathVariable("id") long id) throws LogicalException {
		return personService.getPersonById(id);
	}

	@Override
	@PostMapping("/add")
	public Person savePerson(Person person) throws LogicalException {
		return personService.createPerson(person);
	}

	@Override
	@DeleteMapping("/del/{id}")
	public void deletePerson(@PathVariable("id") long id) throws LogicalException {
		personService.delete(id);
	}

	@Override
	@PutMapping("/update")
	public void updatePerson(Person person) throws LogicalException {
		personService.updatePerson(person);
	}

	@Override
	public void updateInstitution(long id, Institution institution) {
		
		// Por Terminar
		
	}

		

}
