package co.edu.icesi.front.bd;

//import static org.junit.Assert.assertNull;
//import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import javax.persistence.PersistenceContext;

import co.edu.icesi.front.model.classes.Autotransition;
import co.edu.icesi.front.bd.impl.AutotransitionDelegateImpl;
import co.edu.icesi.front.bd.interfaces.AutotransitionDelegate;

@ContextConfiguration(classes = {PersistenceContext.class})
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class AutotransitionDelegateTest {
	
	@Mock
	private RestTemplate restTemplate;
	
	@InjectMocks
	private static AutotransitionDelegate autotransitionDelegate;
	
	final String SERVER="http://localhost:8080/api-rest/autotransition/";

	@BeforeAll
	public static void setUp() {
		autotransitionDelegate = new AutotransitionDelegateImpl();
	}
	
	@Test
	public void testCreateAutotransition() {
		
		Autotransition autotransition = new Autotransition();
		autotransition.setAutotranId(123);
		autotransition.setAutotranIsactive("Is Active");
		autotransition.setAutotranName("Autotransition Test");
		
		Mockito.when(restTemplate.postForEntity(SERVER, autotransition, Autotransition.class))
		.thenReturn(new ResponseEntity<Autotransition>(autotransition, HttpStatus.OK));
		Mockito.when(restTemplate.getForObject(SERVER + autotransition.getAutotranId(), Autotransition.class)).thenReturn(autotransition);

		autotransitionDelegate.createAutotransition(autotransition);
		
		Autotransition newAutotransition = autotransitionDelegate.getAutotransitionById(autotransition.getAutotranId());
		
		assertTrue(autotransition.equals(newAutotransition));
		
	}
	
	@Test
	public void testUpdateAutotransition() {
		
		Autotransition autotransition = new Autotransition();
		autotransition.setAutotranId(123);
		autotransition.setAutotranIsactive("Is Active");
		autotransition.setAutotranName("Autotransition Test");
		
		Autotransition newAutotransition = new Autotransition();
		newAutotransition.setAutotranId(123);
		newAutotransition.setAutotranIsactive("Is Not Active");
		newAutotransition.setAutotranName("New Autotransition Test");
		
		Mockito.when(restTemplate.postForEntity(SERVER, autotransition, Autotransition.class))
		.thenReturn(new ResponseEntity<Autotransition>(autotransition, HttpStatus.OK));
		Mockito.doNothing().when(restTemplate).put(SERVER + autotransition.getAutotranId(), newAutotransition, Autotransition.class);
		Mockito.when(restTemplate.getForObject(SERVER + autotransition.getAutotranId(), Autotransition.class))
		.thenReturn(newAutotransition);
		
		autotransitionDelegate.createAutotransition(autotransition);
		autotransitionDelegate.updateAutotransition(newAutotransition);
		
		Autotransition autotransitionProve = autotransitionDelegate.getAutotransitionById(autotransition.getAutotranId());
		
		assertEquals(newAutotransition.getAutotranIsactive(), autotransitionProve.getAutotranIsactive());
		assertEquals(newAutotransition.getAutotranName(), autotransitionProve.getAutotranName());
		
	}
	
	@Test
	public void testGetAutotransitionById() {
		
		Autotransition autotransition = new Autotransition();
		autotransition.setAutotranId(123);
		autotransition.setAutotranIsactive("Is Active");
		autotransition.setAutotranName("Autotransition Test");
		
		Mockito.when(restTemplate.postForEntity(SERVER, autotransition, Autotransition.class))
		.thenReturn(new ResponseEntity<Autotransition>(autotransition, HttpStatus.OK));

		Mockito.when(restTemplate.getForObject(SERVER + autotransition.getAutotranId(), Autotransition.class)).thenReturn(autotransition);

		autotransitionDelegate.createAutotransition(autotransition);
		
		Autotransition autotransitionById = autotransitionDelegate.getAutotransitionById(autotransition.getAutotranId());
		
		assertTrue(autotransitionById.getAutotranName().equals(autotransition.getAutotranName()));
		
	}
	
	@Test
	public void testfindAll() {
		
		Autotransition autotransition1 = new Autotransition();
		autotransition1.setAutotranId(1);
		autotransition1.setAutotranIsactive("Is Active");
		autotransition1.setAutotranName("Autotransition #1 Test");
		
		Autotransition autotransition2 = new Autotransition();
		autotransition2.setAutotranId(2);
		autotransition2.setAutotranIsactive("Is Not Active");
		autotransition2.setAutotranName("Autotransition #2 Test");
		
		Autotransition autotransition3 = new Autotransition();
		autotransition3.setAutotranId(3);
		autotransition3.setAutotranIsactive("Is Active");
		autotransition3.setAutotranName("Autotransition #3 Test");
		
		Autotransition[] autotransitions = {autotransition1, autotransition2, autotransition3};
		
		Mockito.when(restTemplate.getForObject(SERVER, Autotransition[].class))
		.thenReturn(new ResponseEntity<Autotransition[]>(autotransitions, HttpStatus.OK).getBody());
		Mockito.when(restTemplate.postForEntity(SERVER, autotransition1, Autotransition.class))
		.thenReturn(new ResponseEntity<Autotransition>(autotransition1, HttpStatus.OK));
		Mockito.when(restTemplate.postForEntity(SERVER, autotransition2, Autotransition.class))
		.thenReturn(new ResponseEntity<Autotransition>(autotransition2, HttpStatus.OK));
		Mockito.when(restTemplate.postForEntity(SERVER, autotransition3, Autotransition.class))
		.thenReturn(new ResponseEntity<Autotransition>(autotransition3, HttpStatus.OK));

		autotransitionDelegate.createAutotransition(autotransition1);
		autotransitionDelegate.createAutotransition(autotransition2);
		autotransitionDelegate.createAutotransition(autotransition3);
		
		Iterable<Autotransition> autotransitionsAll = autotransitionDelegate.findAll();
		
		assertTrue(autotransitionsAll.iterator().next().equals(autotransition1));
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testDelete() {
		
		Autotransition autotransition = new Autotransition();
		autotransition.setAutotranId(123);
		autotransition.setAutotranIsactive("Is Active");
		autotransition.setAutotranName("Autotransition Test");
		
		Mockito.when(restTemplate.postForEntity(SERVER, autotransition, Autotransition.class))
		.thenReturn(new ResponseEntity<Autotransition>(autotransition, HttpStatus.ACCEPTED));
		
		autotransitionDelegate.createAutotransition(autotransition);
		
		Mockito.doNothing().when(restTemplate).delete(SERVER + autotransition.getAutotranId());
		autotransitionDelegate.delete(autotransition.getAutotranId());

		Mockito.when(restTemplate.getForObject(SERVER + autotransition.getAutotranId(), null))
				.thenReturn(new ResponseEntity(null, HttpStatus.OK).getBody());
		assertNull(autotransitionDelegate.getAutotransitionById(autotransition.getAutotranId()));
		
	}

}
