package co.edu.icesi.front.bd;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import javax.persistence.PersistenceContext;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.RestTemplate;

import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.back.model.Institution;
import co.edu.icesi.front.bd.impl.PersonDelegateImpl;
import co.edu.icesi.front.bd.interfaces.PersonDelegate;
import co.edu.icesi.front.model.classes.Person;

@ContextConfiguration(classes = {PersistenceContext.class})
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PersonDelegateTest {
	
	@Mock
	private RestTemplate restTemplate;
	
	@InjectMocks
	private static PersonDelegate personDelegate;
	
	final String SERVER="http://localhost:8080/api-rest/person/";
	
	@BeforeAll
	public static void setUp() {
		personDelegate = new PersonDelegateImpl();
	}
	
	@Test
	public void testCreateAutotransition() {
		
		Person person = new Person();
		person.setPersContactnumber("1234567");
		person.setPersEmail("Email@Viejo.com");
		person.setPersId(123);
		person.setPersLastname("Naranjo - Gonzalez");
		person.setPersName("Juan Diego - Natalia");
		
		Institution inst = new Institution();
		inst.setInstId(12);
		
		person.setInstid(inst.getInstId());
		
		when(restTemplate.postForEntity(SERVER + inst.getInstId(), person, Person.class))
		.thenReturn(new ResponseEntity<>(person, HttpStatus.OK));
		Mockito.when(restTemplate.getForObject(SERVER + person.getPersId(), Person.class)).thenReturn(person);
		
		try {
			personDelegate.createPerson(person, inst.getInstId());
			Person newPerson = personDelegate.getPersonById(person.getPersId());
			assertTrue(person.equals(newPerson));
		} catch (LogicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testUpdateAutotransition() {
		
		Person person = new Person();
		person.setPersContactnumber("1234567");
		person.setPersEmail("Email@Viejo.com");
		person.setPersId(123);
		person.setPersLastname("Naranjo");
		person.setPersName("Juan Diego");
		
		Person person2 = new Person();
		person2.setPersContactnumber("7654321");
		person2.setPersEmail("Email@Nuevo.com");
		person2.setPersId(123);
		person2.setPersLastname("Gonzalez");
		person2.setPersName("Natalia");
		
		Institution inst = new Institution();
		inst.setInstId(12);
		
		person.setInstid(inst.getInstId());
		
		Institution inst2 = new Institution();
		inst.setInstId(6);
		
		person2.setInstid(inst2.getInstId());
		
		Mockito.when(restTemplate.postForEntity(SERVER + inst.getInstId(), person, Person.class))
		.thenReturn(new ResponseEntity<Person>(person, HttpStatus.OK));
		Mockito.doNothing().when(restTemplate).put(SERVER + person.getPersId(), person2, Person.class);
		Mockito.when(restTemplate.getForObject(SERVER + person.getPersId(), Person.class))
		.thenReturn(person2);
		
		try {
			
			personDelegate.createPerson(person, inst.getInstId());
			personDelegate.updatePerson(person2, inst2.getInstId());
			
			Person personProve = personDelegate.getPersonById(person.getPersId());
			
			assertEquals(person2.getPersContactnumber(), personProve.getPersContactnumber());
			assertEquals(person2.getPersEmail(), personProve.getPersEmail());
			assertEquals(person2.getPersName(), personProve.getPersName());
			assertEquals(person2.getPersLastname(), personProve.getPersLastname());
			
		} catch (LogicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testGetAutotransitionById() {
		
		Person person = new Person();
		person.setPersContactnumber("1234567");
		person.setPersEmail("Email@Viejo.com");
		person.setPersId(123);
		person.setPersLastname("Naranjo - Gonzalez");
		person.setPersName("Juan Diego - Natalia");
		
		Institution inst = new Institution();
		inst.setInstId(12);
		
		person.setInstid(inst.getInstId());
		
		Mockito.when(restTemplate.postForEntity(SERVER + inst.getInstId(), person, Person.class))
		.thenReturn(new ResponseEntity<Person>(person, HttpStatus.OK));

		Mockito.when(restTemplate.getForObject(SERVER + person.getPersId(), Person.class)).thenReturn(person);

		try {
			
			personDelegate.createPerson(person, inst.getInstId());
			
			Person personById = personDelegate.getPersonById(person.getPersId());
			
			assertTrue(personById.getPersName().equals(person.getPersName()));
			
		} catch (LogicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testfindAll() {
		
		Person person = new Person();
		person.setPersContactnumber("2468101");
		person.setPersEmail("Email@Junto.com");
		person.setPersId(1);
		person.setPersLastname("Naranjo - Gonzalez");
		person.setPersName("Juan Diego - Natalia");
		
		Person person1 = new Person();
		person1.setPersContactnumber("1234567");
		person1.setPersEmail("Email@Viejo.com");
		person1.setPersId(2);
		person1.setPersLastname("Naranjo");
		person1.setPersName("Juan Diego");
		
		Person person2 = new Person();
		person2.setPersContactnumber("7654321");
		person2.setPersEmail("Email@Nuevo.com");
		person2.setPersId(3);
		person2.setPersLastname("Gonzalez");
		person2.setPersName("Natalia");
		
		Institution inst = new Institution();
		inst.setInstId(12);
		
		person.setInstid(inst.getInstId());
		
		Institution inst2 = new Institution();
		inst2.setInstId(12);
		
		person1.setInstid(inst2.getInstId());
		
		Institution inst3 = new Institution();
		inst3.setInstId(12);
		
		person2.setInstid(inst3.getInstId());
		
		Person[] people = {person, person1, person2};
		
		Mockito.when(restTemplate.getForObject(SERVER, Person[].class))
		.thenReturn(new ResponseEntity<Person[]>(people, HttpStatus.OK).getBody());
		Mockito.when(restTemplate.postForEntity(SERVER + inst.getInstId(), person, Person.class))
		.thenReturn(new ResponseEntity<Person>(person, HttpStatus.OK));
		Mockito.when(restTemplate.postForEntity(SERVER + inst2.getInstId(), person1, Person.class))
		.thenReturn(new ResponseEntity<Person>(person1, HttpStatus.OK));
		Mockito.when(restTemplate.postForEntity(SERVER + inst3.getInstId(), person2, Person.class))
		.thenReturn(new ResponseEntity<Person>(person2, HttpStatus.OK));

		try {
			
			personDelegate.createPerson(person, inst.getInstId());
			personDelegate.createPerson(person1, inst2.getInstId());
			personDelegate.createPerson(person2, inst3.getInstId());
			
			Iterable<Person> personAll = personDelegate.findAll();
			
			assertTrue(personAll.iterator().next().equals(person));
			
		} catch (LogicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testDelete() {
		
		Person person = new Person();
		person.setPersContactnumber("1234567");
		person.setPersEmail("Email@Viejo.com");
		person.setPersId(123);
		person.setPersLastname("Naranjo - Gonzalez");
		person.setPersName("Juan Diego - Natalia");
		
		Institution inst = new Institution();
		inst.setInstId(12);
		
		person.setInstid(inst.getInstId());
		
		Mockito.when(restTemplate.postForEntity(SERVER + inst.getInstId(), person, Person.class))
		.thenReturn(new ResponseEntity<Person>(person, HttpStatus.ACCEPTED));
		
		try {
			
			personDelegate.createPerson(person, inst.getInstId());
			
			Mockito.doNothing().when(restTemplate).delete(SERVER + person.getPersId());
			personDelegate.delete(person.getPersId());

			Mockito.when(restTemplate.getForObject(SERVER + person.getPersId(), null))
					.thenReturn(new ResponseEntity(person, HttpStatus.OK).getBody());
			assertNull(personDelegate.getPersonById(person.getPersId()));
			
		} catch (LogicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
