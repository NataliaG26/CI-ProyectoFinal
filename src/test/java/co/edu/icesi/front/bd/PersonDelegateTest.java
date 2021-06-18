package co.edu.icesi.front.bd;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.front.bd.interfaces.PersonDelegate;
import co.edu.icesi.front.model.classes.Person;

@RunWith(MockitoJUnitRunner.class)
public class PersonDelegateTest {
	
	@Mock
	private RestTemplate restTemplate;
	
	@InjectMocks
	@Autowired
	private PersonDelegate personDelegate;
	
	final String SERVER="http://localhost:8080/api-rest/person/";
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testCreateAutotransition() {
		
		Person person = new Person();
		person.setPersContactnumber("1234567");
		person.setPersEmail("Email@Viejo.com");
		person.setPersId(123);
		person.setPersLastname("Naranjo - Gonzalez");
		person.setPersName("Juan Diego - Natalia");
		
		Mockito.when(restTemplate.postForEntity(SERVER + "add/", person, Person.class))
		.thenReturn(new ResponseEntity<Person>(person, HttpStatus.OK));
		Mockito.when(restTemplate.getForObject(SERVER + "show/" + person.getPersId(), Person.class)).thenReturn(person);
		
		try {
			personDelegate.createPerson(person);
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
		person.setPersContactnumber("7654321");
		person.setPersEmail("Email@Nuevo.com");
		person.setPersId(123);
		person.setPersLastname("Gonzalez");
		person.setPersName("Natalia");
		
		Mockito.when(restTemplate.postForEntity(SERVER + "add/", person, Person.class))
		.thenReturn(new ResponseEntity<Person>(person, HttpStatus.OK));
		Mockito.doNothing().when(restTemplate).put(SERVER + "update/" + person.getPersId(), person2, Person.class);
		Mockito.when(restTemplate.getForObject(SERVER + "show/" + person.getPersId(), Person.class))
		.thenReturn(person2);
		
		try {
			
			personDelegate.createPerson(person);
			personDelegate.updatePerson(person2);
			
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
		
		Mockito.when(restTemplate.postForEntity(SERVER + "add/", person, Person.class))
		.thenReturn(new ResponseEntity<Person>(person, HttpStatus.OK));

		Mockito.when(restTemplate.getForObject(SERVER + "show/" + person.getPersId(), Person.class)).thenReturn(person);

		try {
			
			personDelegate.createPerson(person);
			
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
		person.setPersContactnumber("1234567");
		person.setPersEmail("Email@Viejo.com");
		person.setPersId(2);
		person.setPersLastname("Naranjo");
		person.setPersName("Juan Diego");
		
		Person person2 = new Person();
		person.setPersContactnumber("7654321");
		person.setPersEmail("Email@Nuevo.com");
		person.setPersId(3);
		person.setPersLastname("Gonzalez");
		person.setPersName("Natalia");
		
		Person[] people = {person, person1, person2};
		
		Mockito.when(restTemplate.getForObject(SERVER, Person[].class))
		.thenReturn(new ResponseEntity<Person[]>(people, HttpStatus.OK).getBody());
		Mockito.when(restTemplate.postForEntity(SERVER + "add/", person, Person.class))
		.thenReturn(new ResponseEntity<Person>(person, HttpStatus.OK));
		Mockito.when(restTemplate.postForEntity(SERVER + "add/", person1, Person.class))
		.thenReturn(new ResponseEntity<Person>(person1, HttpStatus.OK));
		Mockito.when(restTemplate.postForEntity(SERVER + "add/", person2, Person.class))
		.thenReturn(new ResponseEntity<Person>(person2, HttpStatus.OK));

		try {
			
			personDelegate.createPerson(person);
			personDelegate.createPerson(person1);
			personDelegate.createPerson(person2);
			
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
		
		Mockito.when(restTemplate.postForEntity(SERVER + "add/", person, Person.class))
		.thenReturn(new ResponseEntity<Person>(person, HttpStatus.ACCEPTED));
		
		try {
			
			personDelegate.createPerson(person);
			
			Mockito.doNothing().when(restTemplate).delete(SERVER + person.getPersId());
			personDelegate.delete(person.getPersId());

			Mockito.when(restTemplate.getForObject(SERVER + "show/" + person.getPersId(), null))
					.thenReturn(new ResponseEntity(null, HttpStatus.OK).getBody());
			assertNull(personDelegate.getPersonById(person.getPersId()));
			
		} catch (LogicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
