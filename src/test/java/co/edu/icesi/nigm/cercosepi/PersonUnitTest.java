package co.edu.icesi.nigm.cercosepi;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.edu.icesi.back.daos.interfaces.PersonDAO;
import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.back.model.Institution;
import co.edu.icesi.back.model.Person;
import co.edu.icesi.back.repository.PersonRepository;
import co.edu.icesi.back.service.implementation.PersonServiceImpl;
import co.edu.icesi.back.service.interfaces.InstitutionService;
import co.edu.icesi.back.service.interfaces.PersonService;

@ContextConfiguration(classes = {PersistenceContext.class})
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PersonUnitTest {
	
	@InjectMocks
	private static PersonService personService;
	
	@Mock
	private static PersonRepository personRepository;
	
	@Mock
	private static InstitutionService institutionService;
	
	@Mock
	private static PersonDAO personDAO;
	
	private Person personOpt;
	
	private Institution institution;
	
	private Person person;
	
	private List<Person> persons;
	
	//Scenarios
	
	public void sce_persinst_allGood() {
		institution = new Institution();
		institution.setInstId(1);
		person =  new Person();
		person.setPersId(1);
		person.setInstitution(institution);
		person.setPersName("Natalia Isabel");
		person.setPersLastname("Gonzalez Murillo");
		person.setPersEmail("natalia.isa@gmail.com");
	}
		
	public void sce_persinst_null_inst() {
		sce_persinst_allGood();
		person.setInstitution(null);
	}
	
	public void sce_persinst_noName() {
		sce_persinst_allGood();
		person.setPersName("");
	}
	
	public void sce_persinst_null_name() {
		sce_persinst_allGood();
		person.setPersName(null);
	}
	
	public void sce_persinst_noLastname() {
		sce_persinst_allGood();
		person.setPersLastname("");
	}
	
	public void sce_persinst_null_lastname() {
		sce_persinst_allGood();
		person.setPersLastname(null);
	}
	
	public void sce_persinst_short_email() {
		sce_persinst_allGood();
		person.setPersEmail("nat");
	}
	
	public void sce_persinst_null_email() {
		sce_persinst_allGood();
		person.setPersEmail(null);
	}
	
	public void sce_persinst_null_person() {
		person = null;
	}

	public void sce_persinst_allGood_for_Edit() {
		Person newperson =  new Person();
		newperson.setPersId(1);
		newperson.setInstitution(institution);
		newperson.setPersName("Natalia Isabel");
		newperson.setPersLastname("Gonzalez Murillo");
		newperson.setPersEmail("natalia.isa@gmail.com");
		personOpt = newperson;
	}
	
	public void sce_pers_createList() {
		persons = new ArrayList<Person>();
		
		Person newperson =  new Person();
		newperson.setPersId(1);
		newperson.setInstitution(institution);
		newperson.setPersName("Natalia Isabel");
		newperson.setPersLastname("Gonzalez Murillo");
		newperson.setPersEmail("natalia.isa@gmail.com");
		
		persons.add(newperson);
		
		Person newperson2 =  new Person();
		newperson2.setPersId(2);
		newperson2.setInstitution(institution);
		newperson2.setPersName("Isabel");
		newperson2.setPersLastname("Murillo");
		newperson2.setPersEmail("isa@gmail.com");
		
		persons.add(newperson2);
	}
	
	@BeforeAll
	public static void setUp() {
		personService = new PersonServiceImpl(personRepository, institutionService, personDAO);
	}
	
	
	@Tag("Save")
	@Nested
	class SaveTest{
		
		@Test
		public void save_persinst_allGood() {
			sce_persinst_allGood();
			try {
				long instId = person.getInstitution().getInstId();
				long personId = person.getPersId();
				when(institutionService.getInstitutionById(instId)).thenReturn(institution);
				personService.createPerson(person, personId);
				assertTrue(true);
				verify(personDAO).Save(person);
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(personDAO);
				verifyNoMoreInteractions(institutionService);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void save_persinst_noFound_inst() {
			sce_persinst_allGood();
			try {
				long instId = person.getInstitution().getInstId();
				when(institutionService.getInstitutionById(instId)).thenThrow(LogicalException.class);
				assertThrows(LogicalException.class,
						()-> personService.createPerson(person, instId));
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(institutionService);
				verifyNoInteractions(personDAO);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void save_persinst_null_inst() {
			sce_persinst_null_inst();
			long instId = 10;
			assertThrows(LogicalException.class,
					()-> personService.createPerson(person, instId));
			verifyNoInteractions(institutionService);
			verifyNoInteractions(personDAO);
		}
		
		@Test
		public void save_persinst_noName() {
			sce_persinst_noName();
			try {
				long instId = person.getInstitution().getInstId();
				when(institutionService.getInstitutionById(instId)).thenThrow(LogicalException.class);
				assertThrows(LogicalException.class,
						()-> personService.createPerson(person, instId));
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(institutionService);
				verifyNoInteractions(personDAO);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void save_persinst_null_name() {
			sce_persinst_null_name();
			try {
				long instId = person.getInstitution().getInstId();
				when(institutionService.getInstitutionById(instId)).thenThrow(LogicalException.class);
				assertThrows(LogicalException.class,
						()-> personService.createPerson(person, instId));
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(institutionService);
				verifyNoInteractions(personDAO);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void save_persinst_noLastname() {
			sce_persinst_noLastname();
			try {
				long instId = person.getInstitution().getInstId();
				when(institutionService.getInstitutionById(instId)).thenThrow(LogicalException.class);
				assertThrows(LogicalException.class,
						()-> personService.createPerson(person, instId));
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(institutionService);
				verifyNoInteractions(personDAO);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void save_persinst_null_lastname() {
			sce_persinst_null_lastname();
			try {
				long instId = person.getInstitution().getInstId();
				when(institutionService.getInstitutionById(instId)).thenThrow(LogicalException.class);
				assertThrows(LogicalException.class,
						()-> personService.createPerson(person, instId));
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(institutionService);
				verifyNoInteractions(personDAO);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void save_persinst_short_email() {
			sce_persinst_short_email();
			try {
				long instId = person.getInstitution().getInstId();
				when(institutionService.getInstitutionById(instId)).thenThrow(LogicalException.class);
				assertThrows(LogicalException.class,
						()-> personService.createPerson(person, instId));
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(institutionService);
				verifyNoInteractions(personDAO);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void save_persinst_null_email() {
			sce_persinst_null_email();
			try {
				long instId = person.getInstitution().getInstId();
				when(institutionService.getInstitutionById(instId)).thenThrow(LogicalException.class);
				assertThrows(LogicalException.class,
						()-> personService.createPerson(person, instId));
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(institutionService);
				verifyNoInteractions(personDAO);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void save_persinst_null_person() {
			sce_persinst_null_person();
			long instId = 10;
			assertThrows(LogicalException.class,
					()-> personService.createPerson(person, instId));
			verifyNoInteractions(institutionService);
			verifyNoInteractions(personDAO);
		}
	
	}
	
	@Tag("Update")
	@Nested
	class UpdateTest{
		
		@Test
		public void edit_persinst_allGood() {
			sce_persinst_allGood();
			sce_persinst_allGood_for_Edit();
			
			try {
				long instId = person.getInstitution().getInstId();
				long persId = person.getPersId();
				when(institutionService.getInstitutionById(instId)).thenReturn(institution);
				when(personDAO.findById(persId)).thenReturn(personOpt);
				Person pers = personService.updatePerson(person, instId);
				assertTrue(true);
				verify(personDAO).findById(persId);
				verify(personDAO).Edit(pers);
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(personDAO);
				verifyNoMoreInteractions(institutionService);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void edit_persinst_noFound_inst() {
			sce_persinst_allGood();
			sce_persinst_allGood_for_Edit();
			try {
				long instId = person.getInstitution().getInstId();
				long persId = person.getPersId();
				when(institutionService.getInstitutionById(instId)).thenThrow(LogicalException.class);
				when(personDAO.findById(persId)).thenReturn(personOpt);
				assertThrows(LogicalException.class,
						()-> personService.updatePerson(person, instId));
				verify(personDAO).findById(persId);
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(institutionService);
				verifyNoMoreInteractions(personDAO);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void edit_persinst_null_inst() {
			sce_persinst_null_inst();
			sce_persinst_allGood_for_Edit();
			long instId = 1;
			long persId = person.getPersId();
			when(personDAO.findById(persId)).thenReturn(personOpt);
			assertThrows(LogicalException.class,
					()-> personService.updatePerson(person, instId));
			verify(personDAO).findById(persId);
			verifyNoInteractions(institutionService);
			verifyNoMoreInteractions(personDAO);
		}
		
		@Test
		public void edit_persinst_noName() {
			sce_persinst_noName();
			sce_persinst_allGood_for_Edit();
			try {
				long instId = person.getInstitution().getInstId();
				long persId = person.getPersId();
				when(institutionService.getInstitutionById(instId)).thenReturn(institution);
				when(personDAO.findById(persId)).thenReturn(personOpt);
				assertThrows(LogicalException.class,
						()-> personService.updatePerson(person, instId));
				verify(personDAO).findById(persId);
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(institutionService);
				verifyNoMoreInteractions(personDAO);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void edit_persinst_null_name() {
			sce_persinst_null_name();
			sce_persinst_allGood_for_Edit();
			try {
				long instId = person.getInstitution().getInstId();
				long persId = person.getPersId();
				when(institutionService.getInstitutionById(instId)).thenReturn(institution);
				when(personDAO.findById(persId)).thenReturn(personOpt);
				assertThrows(LogicalException.class,
						()-> personService.updatePerson(person, instId));
				verify(personDAO).findById(persId);
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(institutionService);
				verifyNoMoreInteractions(personDAO);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void edit_persinst_noLastname() {
			sce_persinst_noLastname();
			sce_persinst_allGood_for_Edit();
			try {
				long instId = person.getInstitution().getInstId();
				long persId = person.getPersId();
				when(institutionService.getInstitutionById(instId)).thenReturn(institution);
				when(personDAO.findById(persId)).thenReturn(personOpt);
				assertThrows(LogicalException.class,
						()-> personService.updatePerson(person, instId));
				verify(personDAO).findById(persId);
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(institutionService);
				verifyNoMoreInteractions(personDAO);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void edit_persinst_null_lastname() {
			sce_persinst_null_lastname();
			sce_persinst_allGood_for_Edit();
			try {
				long instId = person.getInstitution().getInstId();
				long persId = person.getPersId();
				when(institutionService.getInstitutionById(instId)).thenReturn(institution);
				when(personDAO.findById(persId)).thenReturn(personOpt);
				assertThrows(LogicalException.class,
						()-> personService.updatePerson(person, instId));
				verify(personDAO).findById(persId);
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(institutionService);
				verifyNoMoreInteractions(personDAO);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void edit_persinst_short_email() {
			sce_persinst_short_email();
			sce_persinst_allGood_for_Edit();
			try {
				long instId = person.getInstitution().getInstId();
				long persId = person.getPersId();
				when(institutionService.getInstitutionById(instId)).thenReturn(institution);
				when(personDAO.findById(persId)).thenReturn(personOpt);
				assertThrows(LogicalException.class,
						()-> personService.updatePerson(person, instId));
				verify(personDAO).findById(persId);
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(institutionService);
				verifyNoMoreInteractions(personDAO);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void edit_persinst_null_email() {
			sce_persinst_null_email();
			sce_persinst_allGood_for_Edit();
			try {
				long instId = person.getInstitution().getInstId();
				long persId = person.getPersId();
				when(institutionService.getInstitutionById(instId)).thenReturn(institution);
				when(personDAO.findById(persId)).thenReturn(personOpt);
				assertThrows(LogicalException.class,
						()-> personService.updatePerson(person, instId));
				verify(personDAO).findById(persId);
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(institutionService);
				verifyNoMoreInteractions(personDAO);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void edit_persinst_null_person() {
			sce_persinst_null_person();
			long instId = 1;
			assertThrows(LogicalException.class,
					()-> personService.updatePerson(person, instId));
			verifyNoInteractions(institutionService);
			verifyNoInteractions(personDAO);
		}
		
		@Test
		public void edit_persinst_noFound_person() {
			sce_persinst_allGood();
			sce_persinst_allGood_for_Edit();
			long instId = person.getInstitution().getInstId();
				long persId = person.getPersId();
				when(personDAO.findById(persId)).thenThrow(NoSuchElementException.class);
				assertThrows(LogicalException.class,
						()-> personService.updatePerson(person, instId));
				verify(personDAO).findById(persId);
				verifyNoInteractions(institutionService);
				verifyNoMoreInteractions(personDAO);
		}
		
	}
	
	@Tag("Delete")
	@Nested
	class DeleteTest{
		
		@Test
		public void delete_allGood() {
			sce_persinst_allGood();
			long persId = person.getPersId();
			when(personDAO.findById(persId)).thenReturn(person);
			try {
				personService.delete(persId);
			} catch (LogicalException e) {
				assertTrue(false);
			}
			verify(personDAO).Delete(person);
			verify(personDAO).findById(persId);
			verifyNoInteractions(institutionService);
			verifyNoMoreInteractions(personDAO);
		}
	}
	
	@Tag("Show")
	@Nested
	class ShowTest{
		
		@Test
		public void show_byID_allGood() {
			sce_persinst_allGood();
			long persId = person.getPersId();
			when(personDAO.findById(persId)).thenReturn(person);
			Person per = null;
			try {
				per = personService.getPersonById(persId);
			} catch (LogicalException e) {
				assertTrue(false);
			}
			assertEquals(per, person);
			verify(personDAO).findById(persId);
			verifyNoInteractions(institutionService);
			verifyNoMoreInteractions(personDAO);
		}
		
		@Test
		public void show_list_allGood() {
			sce_pers_createList();
			when(personDAO.findAll()).thenReturn(persons);
			Iterable<Person> persons2 = personService.findAll();
			//Iterable<Person> personsAdd = persons;
			assertIterableEquals(persons, persons2);
			verify(personDAO).findAll();
			verifyNoInteractions(institutionService);
			verifyNoMoreInteractions(personDAO);
		}
		
	}
	
	
	
}
