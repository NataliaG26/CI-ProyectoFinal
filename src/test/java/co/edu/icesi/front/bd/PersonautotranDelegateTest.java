package co.edu.icesi.front.bd;

//import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

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
import co.edu.icesi.back.model.Autotransition;
import co.edu.icesi.front.bd.impl.PersonautoranDelegateImpl;
import co.edu.icesi.front.bd.interfaces.PersonautotranDelegate;
import co.edu.icesi.front.model.classes.Person;
import co.edu.icesi.front.model.classes.Personautotran;

@ContextConfiguration(classes = {PersistenceContext.class})
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PersonautotranDelegateTest {
	
	@Mock
	private RestTemplate restTemplate;
	
	@InjectMocks
	private static PersonautotranDelegate personautotranDelegate;
	
	final String SERVER="http://localhost:8080/api-rest/personautotran/";
	
	@BeforeAll
	public static void setUp() {
		personautotranDelegate = new PersonautoranDelegateImpl();
	}
	
	@Test
	public void testCreateAutotransition() {
		
		Personautotran personautotran = new Personautotran();
		personautotran.setPerautDate(LocalDate.of(2000, 06, 12));
		personautotran.setPerautId(123);
		
		Autotransition autotran = new Autotransition();
		autotran.setAutotranId(12);
		
		Person person = new Person();
		person.setInstid(6);
		
		personautotran.setAutotranId(autotran.getAutotranId());
		personautotran.setPersonId(person.getPersId());
		
		Mockito.when(restTemplate.postForEntity(SERVER+person.getPersId()+"/"+autotran.getAutotranId(), personautotran, Personautotran.class))
		.thenReturn(new ResponseEntity<Personautotran>(personautotran, HttpStatus.OK));
		Mockito.when(restTemplate.getForObject(SERVER + personautotran.getPerautId(), Personautotran.class)).thenReturn(personautotran);
		
		try {
			personautotranDelegate.createPersonautotran(personautotran, person.getPersId(), autotran.getAutotranId());
			Personautotran personautotran2 = personautotranDelegate.getPersonautotranById(personautotran.getPerautId());
			assertTrue(personautotran.equals(personautotran2));
		} catch (LogicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testUpdateAutotransition() {
		
		Personautotran personautotran = new Personautotran();
		personautotran.setPerautDate(LocalDate.of(2000, 06, 12));
		personautotran.setPerautId(123);
		
		Personautotran newPersonautotran = new Personautotran();
		newPersonautotran.setPerautDate(LocalDate.of(1999, 04, 27));
		newPersonautotran.setPerautId(123);
		
		Autotransition autotran = new Autotransition();
		autotran.setAutotranId(12);
		
		Person person = new Person();
		person.setPersId(6);
		
		Autotransition newAutotran = new Autotransition();
		autotran.setAutotranId(6);
		
		Person newPerson = new Person();
		person.setPersId(12);
		
		personautotran.setAutotranId(autotran.getAutotranId());
		personautotran.setPersonId(person.getPersId());
		
		newPersonautotran.setAutotranId(newAutotran.getAutotranId());
		newPersonautotran.setPersonId(newPerson.getPersId());
		
		Mockito.when(restTemplate.postForEntity(SERVER+person.getPersId()+"/"+autotran.getAutotranId(), personautotran, Personautotran.class))
		.thenReturn(new ResponseEntity<Personautotran>(personautotran, HttpStatus.OK));
		Mockito.doNothing().when(restTemplate).put(SERVER + personautotran.getPerautId(), newPersonautotran, Personautotran.class);
		Mockito.when(restTemplate.getForObject(SERVER + personautotran.getPerautId(), Personautotran.class))
		.thenReturn(newPersonautotran);
		
		try {
			
			personautotranDelegate.createPersonautotran(personautotran, person.getPersId(), autotran.getAutotranId());
			personautotranDelegate.updatePersonautotran(newPersonautotran);
			
			Personautotran personautotranProve = personautotranDelegate.getPersonautotranById(personautotran.getPerautId());
			
			assertEquals(newPersonautotran.getPerautDate(), personautotranProve.getPerautDate());
			
		} catch (LogicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testGetAutotransitionById() {
		
		Personautotran personautotran = new Personautotran();
		personautotran.setPerautDate(LocalDate.of(2000, 06, 12));
		personautotran.setPerautId(123);
		
		Autotransition autotran = new Autotransition();
		autotran.setAutotranId(12);
		
		Person person = new Person();
		person.setPersId(6);
		
		personautotran.setAutotranId(autotran.getAutotranId());
		personautotran.setPersonId(person.getPersId());
		
		Mockito.when(restTemplate.postForEntity(SERVER+person.getPersId()+"/"+autotran.getAutotranId(), personautotran, Personautotran.class))
		.thenReturn(new ResponseEntity<Personautotran>(personautotran, HttpStatus.OK));

		Mockito.when(restTemplate.getForObject(SERVER + personautotran.getPerautId(), Personautotran.class)).thenReturn(personautotran);

		try {
			
			personautotranDelegate.createPersonautotran(personautotran, person.getPersId(), autotran.getAutotranId());
			
			Personautotran personautotranById = personautotranDelegate.getPersonautotranById(personautotran.getPerautId());
			
			assertTrue(personautotranById.getPerautDate().equals(personautotran.getPerautDate()));
			
		} catch (LogicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void testfindAll() {
		
		Personautotran personautotran1 = new Personautotran();
		personautotran1.setPerautDate(LocalDate.of(2000, 06, 12));
		personautotran1.setPerautId(1);
		
		Personautotran personautotran2 = new Personautotran();
		personautotran2.setPerautDate(LocalDate.of(1999, 04, 27));
		personautotran2.setPerautId(2);
		
		Personautotran personautotran3 = new Personautotran();
		personautotran3.setPerautDate(LocalDate.of(1964, 03, 9));
		personautotran3.setPerautId(3);
		
		Autotransition autotran = new Autotransition();
		autotran.setAutotranId(12);
		
		Person person = new Person();
		person.setPersId(6);
		
		Autotransition autotran2 = new Autotransition();
		autotran.setAutotranId(6);
		
		Person person2 = new Person();
		person.setPersId(12);
		
		Autotransition autotran3 = new Autotransition();
		autotran.setAutotranId(27);
		
		Person person3 = new Person();
		person.setPersId(4);
		
		personautotran1.setAutotranId(autotran.getAutotranId());
		personautotran1.setPersonId(person.getPersId());
		
		personautotran2.setAutotranId(autotran2.getAutotranId());
		personautotran2.setPersonId(person2.getPersId());
		
		personautotran3.setAutotranId(autotran2.getAutotranId());
		personautotran3.setPersonId(person2.getPersId());
		
		Personautotran[] personautotrans = {personautotran1, personautotran2, personautotran3};
		
		Mockito.when(restTemplate.getForObject(SERVER, Personautotran[].class))
		.thenReturn(new ResponseEntity<Personautotran[]>(personautotrans, HttpStatus.OK).getBody());
		Mockito.when(restTemplate.postForEntity(SERVER+person.getPersId()+"/"+autotran.getAutotranId(), personautotran1, Personautotran.class))
		.thenReturn(new ResponseEntity<Personautotran>(personautotran1, HttpStatus.OK));
		Mockito.when(restTemplate.postForEntity(SERVER+person2.getPersId()+"/"+autotran2.getAutotranId(), personautotran2, Personautotran.class))
		.thenReturn(new ResponseEntity<Personautotran>(personautotran2, HttpStatus.OK));
		Mockito.when(restTemplate.postForEntity(SERVER+person3.getPersId()+"/"+autotran3.getAutotranId(), personautotran3, Personautotran.class))
		.thenReturn(new ResponseEntity<Personautotran>(personautotran3, HttpStatus.OK));

		try {
			
			personautotranDelegate.createPersonautotran(personautotran1, person.getPersId(), autotran.getAutotranId());
			personautotranDelegate.createPersonautotran(personautotran2, person2.getPersId(), autotran2.getAutotranId());
			personautotranDelegate.createPersonautotran(personautotran3, person3.getPersId(), autotran3.getAutotranId());
			
			Iterable<Personautotran> personautotranAll = personautotranDelegate.findAll();
			
			assertTrue(personautotranAll.iterator().next().equals(personautotran1));
			
		} catch (LogicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testDelete() {
		
		Personautotran personautotran = new Personautotran();
		personautotran.setPerautDate(LocalDate.of(2000, 06, 12));
		personautotran.setPerautId(123);
		
		Autotransition autotran = new Autotransition();
		autotran.setAutotranId(12);
		
		Person person = new Person();
		person.setPersId(6);
		
		personautotran.setAutotranId(autotran.getAutotranId());
		personautotran.setPersonId(person.getPersId());
		
		Mockito.when(restTemplate.postForEntity(SERVER+person.getPersId()+"/"+autotran.getAutotranId(), personautotran, Personautotran.class))
		.thenReturn(new ResponseEntity<Personautotran>(personautotran, HttpStatus.ACCEPTED));
		
		try {
			
			personautotranDelegate.createPersonautotran(personautotran, person.getPersId(), autotran.getAutotranId());
			
			Mockito.doNothing().when(restTemplate).delete(SERVER + personautotran.getPerautId());
			personautotranDelegate.delete(personautotran.getPerautId());

			Mockito.when(restTemplate.getForObject(SERVER + personautotran.getPerautId(), null))
					.thenReturn(new ResponseEntity(null, HttpStatus.OK).getBody());
			assertNull(personautotranDelegate.getPersonautotranById(personautotran.getPerautId()));
			
		} catch (LogicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
