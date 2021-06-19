package co.edu.icesi.back.restcontroller.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	@GetMapping("/{id}")
	public Person showPerson(@PathVariable("id") long id) throws LogicalException {
		return personService.getPersonById(id);
	}

	@Override
	@PostMapping("/{instid}")
	public Person savePerson(@RequestBody Person person, @PathVariable(value="instid", required = true) long instid) throws LogicalException {
		System.out.println("back  "+person.getPersName());
		return personService.createPerson(person, instid);
	}

	@Override
	@DeleteMapping("/{id}")
	public void deletePerson(@PathVariable("id") long id) throws LogicalException {
		personService.delete(id);
	}

	@Override
	@PutMapping("/{instid}")
	public void updatePerson(@RequestBody Person person, @PathVariable(value="instid", required = true) long instid) throws LogicalException {
		personService.updatePerson(person, instid);
	}

	@Override
	public void updateInstitution(long id, Institution institution) {
		
		// Por Terminar
		
	}

		

}
