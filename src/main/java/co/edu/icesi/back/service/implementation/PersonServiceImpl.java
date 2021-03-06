package co.edu.icesi.back.service.implementation;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import co.edu.icesi.back.daos.interfaces.PersonDAO;
import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.back.model.Institution;
import co.edu.icesi.back.model.Person;
import co.edu.icesi.back.repository.PersonRepository;
import co.edu.icesi.back.service.interfaces.InstitutionService;
import co.edu.icesi.back.service.interfaces.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	
	private PersonRepository personRepository;
	
	private InstitutionService institutionService;
	
	private PersonDAO personDAO;
	
	@Autowired
	public PersonServiceImpl(PersonRepository personRep, InstitutionService institutionServ, PersonDAO personDAO) {
		this.personRepository = personRep;
		this.institutionService = institutionServ;
		this.personDAO = personDAO;
	}
	
	@Override
	@Transactional
	public Person createPerson(Person person, long instid) throws LogicalException {
		if(person == null) {
			throw new LogicalException("La persona a ingresar no puede ser null");
		}
//		else if(person.getInstitution() == null ) {
//			throw new LogicalException("La institución asociada a la persona no puede ser null");
//		}
		
		Institution inst = institutionService.getInstitutionById(instid);
		
//		if(person.getPersName() == null ) {
//			throw new LogicalException("El nombre de la persona no puede ser null");
//		}
//		else if(person.getPersName().equals("")) {
//			throw new LogicalException("El nombre de la persona no puede ser vacío");
//		}
//		else if(person.getPersLastname() == null) {
//			throw new LogicalException("El apellido de la persona no puede ser null");
//		}
//		else if(person.getPersLastname().equals("")) {
//			throw new LogicalException("El apellido de la persona no puede ser vacío");
//		}
//		else if(person.getPersEmail() == null) {
//			throw new LogicalException("El email de la persona no puede ser null");
//		}
//		else if(person.getPersEmail().length() < 6) {
//			throw new LogicalException("El email de la persona debe tener mínimo 6 caracteres");
//		}
//		else {
			//personRepository.save(person);
			person.setInstitution(inst);
			personDAO.Save(person);
			return person;
		//}
	}

	@Override
	@Transactional
	public Person updatePerson(Person person, long instid) throws LogicalException {
		if(person == null) {
			throw new LogicalException("La persona a ingresar no puede ser null");
		}
		
		Person existingPerson = getPersonById(person.getPersId());
		
//		if(person.getInstitution() == null ) {
//			throw new LogicalException("La institución asociada a la persona no puede ser null");
//		}
		
		Institution inst = institutionService.getInstitutionById(instid);
		
		if(person.getPersName() == null ) {
			throw new LogicalException("El nombre de la persona no puede ser null");
		}
		else if(person.getPersName().equals("")) {
			throw new LogicalException("El nombre de la persona no puede ser vacío");
		}
		else if(person.getPersLastname() == null) {
			throw new LogicalException("El apellido de la persona no puede ser null");
		}
		else if(person.getPersLastname().equals("")) {
			throw new LogicalException("El apellido de la persona no puede ser vacío");
		}
		else if(person.getPersEmail() == null) {
			throw new LogicalException("El email de la persona no puede ser null");
		}
		else if(person.getPersEmail().length() < 6) {
			throw new LogicalException("El email de la persona debe tener mínimo 6 caracteres");
		}
		else {
			existingPerson.setPersContactnumber(person.getPersContactnumber());
			existingPerson.setPersEmail(person.getPersEmail());
			existingPerson.setPersExtid(person.getPersExtid());
			existingPerson.setPersIddocument(person.getPersIddocument());
			existingPerson.setPersIsactive(person.getPersIsactive());
			existingPerson.setPersLastname(person.getPersLastname());
			existingPerson.setPersLatitude(person.getPersLatitude());
			existingPerson.setPersLocaldata(person.getPersLocaldata());
			existingPerson.setPersLongitude(person.getPersLongitude());
			existingPerson.setPersName(person.getPersName());
			existingPerson.setInstitution(inst);
			//personRepository.save(existingPerson);
			personDAO.Edit(existingPerson);
			return existingPerson;
		}
	}

	@Override
	@Transactional
	public Person getPersonById(long id) throws LogicalException {
		try {
			//Person person = personRepository.findById(id).get();
			Person person = personDAO.findById(id);
			return person;
		}catch(NoSuchElementException e) {
			throw new LogicalException("No se encontró la persona");
		}
	}
	
	@Override
	@Transactional
	public Iterable<Person> findAll(){
		//return personRepository.findAll();
		return personDAO.findAll();
	}
	
	@Override
	@Transactional
	public void delete(long id) throws LogicalException{
		//personRepository.delete(person);
		Person person = getPersonById(id);
		personDAO.Delete(person);
	}

}
