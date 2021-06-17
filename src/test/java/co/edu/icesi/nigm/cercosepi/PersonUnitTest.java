package co.edu.icesi.nigm.cercosepi;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.edu.icesi.nigm.exception.LogicalException;
import co.edu.icesi.nigm.model.Institution;
import co.edu.icesi.nigm.model.Person;
import co.edu.icesi.nigm.repository.PersonRepository;
import co.edu.icesi.nigm.service.interfaces.InstitutionService;
import co.edu.icesi.nigm.service.interfaces.PersonService;
import co.edu.icesi.nigm.service.implementation.PersonServiceImpl;
import co.edu.icesi.nigm.daos.interfaces.PersonDAO;

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
	
	private Optional<Person> personOpt;
	
	private Institution institution;
	
	private Person person;
	
	
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
		personOpt = Optional.of(newperson);
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
				when(institutionService.getInstitutionById(instId)).thenReturn(institution);
				when(personService.createPerson(person)).thenReturn(person);
				assertTrue(true);
				verify(personRepository).save(person);
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(personRepository);
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
						()-> when(personService.createPerson(person)).thenReturn(person));
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(institutionService);
				verifyNoInteractions(personRepository);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void save_persinst_null_inst() {
			sce_persinst_null_inst();
			assertThrows(LogicalException.class,
					()-> when(personService.createPerson(person)).thenReturn(person));
			verifyNoInteractions(institutionService);
			verifyNoInteractions(personRepository);
		}
		
		@Test
		public void save_persinst_noName() {
			sce_persinst_noName();
			try {
				long instId = person.getInstitution().getInstId();
				when(institutionService.getInstitutionById(instId)).thenThrow(LogicalException.class);
				assertThrows(LogicalException.class,
						()-> when(personService.createPerson(person)).thenReturn(person));
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(institutionService);
				verifyNoInteractions(personRepository);
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
						()-> when(personService.createPerson(person)).thenReturn(person));
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(institutionService);
				verifyNoInteractions(personRepository);
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
						()-> when(personService.createPerson(person)).thenReturn(person));
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(institutionService);
				verifyNoInteractions(personRepository);
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
						()-> when(personService.createPerson(person)).thenReturn(person));
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(institutionService);
				verifyNoInteractions(personRepository);
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
						()-> when(personService.createPerson(person)).thenReturn(person));
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(institutionService);
				verifyNoInteractions(personRepository);
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
						()-> when(personService.createPerson(person)).thenReturn(person));
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(institutionService);
				verifyNoInteractions(personRepository);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void save_persinst_null_person() {
			sce_persinst_null_person();
			assertThrows(LogicalException.class,
					()-> when(personService.createPerson(person)).thenReturn(person));
			verifyNoInteractions(institutionService);
			verifyNoInteractions(personRepository);
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
				when(personRepository.findById(persId)).thenReturn(personOpt);
				when(personService.updatePerson(person)).thenReturn(person);
				assertTrue(true);
				verify(personRepository).findById(persId);
				verify(personRepository).save(person);
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(personRepository);
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
				when(personRepository.findById(persId)).thenReturn(personOpt);
				assertThrows(LogicalException.class,
						()-> when(personService.updatePerson(person)).thenReturn(person));
				verify(personRepository).findById(persId);
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(institutionService);
				verifyNoMoreInteractions(personRepository);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void edit_persinst_null_inst() {
			sce_persinst_null_inst();
			sce_persinst_allGood_for_Edit();
			long persId = person.getPersId();
			when(personRepository.findById(persId)).thenReturn(personOpt);
			assertThrows(LogicalException.class,
					()-> when(personService.updatePerson(person)).thenReturn(person));
			verify(personRepository).findById(persId);
			verifyNoInteractions(institutionService);
			verifyNoMoreInteractions(personRepository);
		}
		
		@Test
		public void edit_persinst_noName() {
			sce_persinst_noName();
			sce_persinst_allGood_for_Edit();
			try {
				long instId = person.getInstitution().getInstId();
				long persId = person.getPersId();
				when(institutionService.getInstitutionById(instId)).thenReturn(institution);
				when(personRepository.findById(persId)).thenReturn(personOpt);
				assertThrows(LogicalException.class,
						()-> when(personService.updatePerson(person)).thenReturn(person));
				verify(personRepository).findById(persId);
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(institutionService);
				verifyNoMoreInteractions(personRepository);
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
				when(personRepository.findById(persId)).thenReturn(personOpt);
				assertThrows(LogicalException.class,
						()-> when(personService.updatePerson(person)).thenReturn(person));
				verify(personRepository).findById(persId);
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(institutionService);
				verifyNoMoreInteractions(personRepository);
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
				when(personRepository.findById(persId)).thenReturn(personOpt);
				assertThrows(LogicalException.class,
						()-> when(personService.updatePerson(person)).thenReturn(person));
				verify(personRepository).findById(persId);
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(institutionService);
				verifyNoMoreInteractions(personRepository);
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
				when(personRepository.findById(persId)).thenReturn(personOpt);
				assertThrows(LogicalException.class,
						()-> when(personService.updatePerson(person)).thenReturn(person));
				verify(personRepository).findById(persId);
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(institutionService);
				verifyNoMoreInteractions(personRepository);
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
				when(personRepository.findById(persId)).thenReturn(personOpt);
				assertThrows(LogicalException.class,
						()-> when(personService.updatePerson(person)).thenReturn(person));
				verify(personRepository).findById(persId);
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(institutionService);
				verifyNoMoreInteractions(personRepository);
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
				when(personRepository.findById(persId)).thenReturn(personOpt);
				assertThrows(LogicalException.class,
						()-> when(personService.updatePerson(person)).thenReturn(person));
				verify(personRepository).findById(persId);
				verify(institutionService).getInstitutionById(instId);
				verifyNoMoreInteractions(institutionService);
				verifyNoMoreInteractions(personRepository);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void edit_persinst_null_person() {
			sce_persinst_null_person();
			assertThrows(LogicalException.class,
					()-> when(personService.updatePerson(person)).thenReturn(person));
			verifyNoInteractions(institutionService);
			verifyNoInteractions(personRepository);
		}
		
		@Test
		public void edit_persinst_noFound_person() {
			sce_persinst_allGood();
			sce_persinst_allGood_for_Edit();
				long persId = person.getPersId();
				when(personRepository.findById(persId)).thenThrow(NoSuchElementException.class);
				assertThrows(LogicalException.class,
						()-> when(personService.updatePerson(person)).thenReturn(person));
				verify(personRepository).findById(persId);
				verifyNoInteractions(institutionService);
				verifyNoMoreInteractions(personRepository);
		}
		
	}
	
	
	
	
}
