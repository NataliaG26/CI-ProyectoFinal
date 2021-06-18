package co.edu.icesi.front.bd;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

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
import co.edu.icesi.front.bd.interfaces.PersonautotranDelegate;
import co.edu.icesi.front.model.classes.Personautotran;

@RunWith(MockitoJUnitRunner.class)
public class PersonautotranDelegateTest {
	
	@Mock
	private RestTemplate restTemplate;
	
	@InjectMocks
	@Autowired
	private PersonautotranDelegate personautotranDelegate;
	
	final String SERVER="http://localhost:8080/api-rest/personautotran/";
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testCreateAutotransition() {
		
		Personautotran personautotran = new Personautotran();
		personautotran.setPerautDate(new Date(12, 06, 2000));
		personautotran.setPerautId(123);
		
		Mockito.when(restTemplate.postForEntity(SERVER + "add/", personautotran, Personautotran.class))
		.thenReturn(new ResponseEntity<Personautotran>(personautotran, HttpStatus.OK));
		Mockito.when(restTemplate.getForObject(SERVER + "show/" + personautotran.getPerautId(), Personautotran.class)).thenReturn(personautotran);
		
		try {
			personautotranDelegate.createPersonautotran(personautotran);
			Personautotran personautotran2 = personautotranDelegate.getPersonautotranById(personautotran.getPerautId());
			assertTrue(personautotran.equals(personautotran2));
		} catch (LogicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testUpdateAutotransition() {
		
		Personautotran personautotran = new Personautotran();
		personautotran.setPerautDate(new Date(12, 06, 2000));
		personautotran.setPerautId(123);
		
		Personautotran newPersonautotran = new Personautotran();
		newPersonautotran.setPerautDate(new Date(27, 04, 1999));
		newPersonautotran.setPerautId(123);
		
		Mockito.when(restTemplate.postForEntity(SERVER + "add/", personautotran, Personautotran.class))
		.thenReturn(new ResponseEntity<Personautotran>(personautotran, HttpStatus.OK));
		Mockito.doNothing().when(restTemplate).put(SERVER + "update/" + personautotran.getPerautId(), newPersonautotran, Personautotran.class);
		Mockito.when(restTemplate.getForObject(SERVER + "show/" + personautotran.getPerautId(), Personautotran.class))
		.thenReturn(newPersonautotran);
		
		try {
			
			personautotranDelegate.createPersonautotran(personautotran);
			personautotranDelegate.updatePersonautotran(newPersonautotran);
			
			Personautotran personautotranProve = personautotranDelegate.getPersonautotranById(personautotran.getPerautId());
			
			assertEquals(newPersonautotran.getPerautDate(), personautotranProve.getPerautDate());
			
		} catch (LogicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testGetAutotransitionById() {
		
		Personautotran personautotran = new Personautotran();
		personautotran.setPerautDate(new Date(12, 06, 2000));
		personautotran.setPerautId(123);
		
		Mockito.when(restTemplate.postForEntity(SERVER + "add/", personautotran, Personautotran.class))
		.thenReturn(new ResponseEntity<Personautotran>(personautotran, HttpStatus.OK));

		Mockito.when(restTemplate.getForObject(SERVER + "show/" + personautotran.getPerautId(), Personautotran.class)).thenReturn(personautotran);

		try {
			
			personautotranDelegate.createPersonautotran(personautotran);
			
			Personautotran personautotranById = personautotranDelegate.getPersonautotranById(personautotran.getPerautId());
			
			assertTrue(personautotranById.getPerautDate().equals(personautotran.getPerautDate()));
			
		} catch (LogicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testfindAll() {
		
		Personautotran personautotran1 = new Personautotran();
		personautotran1.setPerautDate(new Date(12, 06, 2000));
		personautotran1.setPerautId(1);
		
		Personautotran personautotran2 = new Personautotran();
		personautotran2.setPerautDate(new Date(27, 04, 1999));
		personautotran2.setPerautId(2);
		
		Personautotran personautotran3 = new Personautotran();
		personautotran3.setPerautDate(new Date(9, 03, 1964));
		personautotran3.setPerautId(3);
		
		Personautotran[] personautotrans = {personautotran1, personautotran2, personautotran3};
		
		Mockito.when(restTemplate.getForObject(SERVER, Personautotran[].class))
		.thenReturn(new ResponseEntity<Personautotran[]>(personautotrans, HttpStatus.OK).getBody());
		Mockito.when(restTemplate.postForEntity(SERVER + "add/", personautotran1, Personautotran.class))
		.thenReturn(new ResponseEntity<Personautotran>(personautotran1, HttpStatus.OK));
		Mockito.when(restTemplate.postForEntity(SERVER + "add/", personautotran2, Personautotran.class))
		.thenReturn(new ResponseEntity<Personautotran>(personautotran2, HttpStatus.OK));
		Mockito.when(restTemplate.postForEntity(SERVER + "add/", personautotran3, Personautotran.class))
		.thenReturn(new ResponseEntity<Personautotran>(personautotran3, HttpStatus.OK));

		try {
			
			personautotranDelegate.createPersonautotran(personautotran1);
			personautotranDelegate.createPersonautotran(personautotran2);
			personautotranDelegate.createPersonautotran(personautotran3);
			
			Iterable<Personautotran> personautotranAll = personautotranDelegate.findAll();
			
			assertTrue(personautotranAll.iterator().next().equals(personautotran1));
			
		} catch (LogicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes", "deprecation" })
	@Test
	public void testDelete() {
		
		Personautotran personautotran = new Personautotran();
		personautotran.setPerautDate(new Date(12, 06, 2000));
		personautotran.setPerautId(123);
		
		Mockito.when(restTemplate.postForEntity(SERVER + "add/", personautotran, Personautotran.class))
		.thenReturn(new ResponseEntity<Personautotran>(personautotran, HttpStatus.ACCEPTED));
		
		try {
			
			personautotranDelegate.createPersonautotran(personautotran);
			
			Mockito.doNothing().when(restTemplate).delete(SERVER + personautotran.getPerautId());
			personautotranDelegate.delete(personautotran.getPerautId());

			Mockito.when(restTemplate.getForObject(SERVER + "show/" + personautotran.getPerautId(), null))
					.thenReturn(new ResponseEntity(null, HttpStatus.OK).getBody());
			assertNull(personautotranDelegate.getPersonautotranById(personautotran.getPerautId()));
			
		} catch (LogicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
