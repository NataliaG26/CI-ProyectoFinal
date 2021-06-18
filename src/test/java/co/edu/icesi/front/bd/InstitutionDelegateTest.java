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

import co.edu.icesi.front.model.classes.Institution;
import co.edu.icesi.front.bd.interfaces.InstitutionDelegate;

@RunWith(MockitoJUnitRunner.class)
public class InstitutionDelegateTest {
	
	@Mock
	private RestTemplate restTemplate;
	
	@InjectMocks
	@Autowired
	private InstitutionDelegate institutionDelegate;
	
	final String SERVER="http://localhost:8080/api-rest/institution/";
	
	@SuppressWarnings("deprecation")
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testCreateAutotransition() {
		
		Institution institution = new Institution();
		institution.setInstId(123);
		institution.setInstAcadloginpassword("loginPassword");
		institution.setInstAcadloginusername("loginUsername");
		institution.setInstName("Test institution");
		
		Mockito.when(restTemplate.postForEntity(SERVER + "add/", institution, Institution.class))
		.thenReturn(new ResponseEntity<Institution>(institution, HttpStatus.OK));
		Mockito.when(restTemplate.getForObject(SERVER + "show/" + institution.getInstId(), Institution.class)).thenReturn(institution);

		institutionDelegate.createInstitution(institution);
		
		Institution newInstitution = institutionDelegate.getInstitutionById(institution.getInstId());
		
		assertTrue(institution.equals(newInstitution));
		
	}
	
	@Test
	public void testUpdateAutotransition() {
		
		Institution institution = new Institution();
		institution.setInstId(123);
		institution.setInstAcadloginpassword("loginPassword");
		institution.setInstAcadloginusername("loginUsername");
		institution.setInstName("Test institution");
		
		Institution newInstitution = new Institution();
		newInstitution.setInstId(123);
		newInstitution.setInstAcadloginpassword("loginPassword2");
		newInstitution.setInstAcadloginusername("loginUsername2");
		newInstitution.setInstName("Test institution #2");
		
		Mockito.when(restTemplate.postForEntity(SERVER + "add/", institution, Institution.class))
		.thenReturn(new ResponseEntity<Institution>(institution, HttpStatus.OK));
		Mockito.doNothing().when(restTemplate).put(SERVER + "update/" + institution.getInstId(), newInstitution, Institution.class);
		Mockito.when(restTemplate.getForObject(SERVER + "show/" + institution.getInstId(), Institution.class))
		.thenReturn(newInstitution);
		
		institutionDelegate.createInstitution(institution);
		institutionDelegate.updateInstitution(newInstitution);
		
		Institution institutionProve = institutionDelegate.getInstitutionById(institution.getInstId());
		
		assertEquals(newInstitution.getInstAcadloginpassword(), institutionProve.getInstAcadloginpassword());
		assertEquals(newInstitution.getInstAcadloginusername(), institutionProve.getInstAcadloginusername());
		assertEquals(newInstitution.getInstName(), institutionProve.getInstName());
		
	}
	
	@Test
	public void testGetAutotransitionById() {
		
		Institution institution = new Institution();
		institution.setInstId(123);
		institution.setInstAcadloginpassword("loginPassword");
		institution.setInstAcadloginusername("loginUsername");
		institution.setInstName("Test institution");
		
		Mockito.when(restTemplate.postForEntity(SERVER + "add/", institution, Institution.class))
		.thenReturn(new ResponseEntity<Institution>(institution, HttpStatus.OK));

		Mockito.when(restTemplate.getForObject(SERVER + "show/" + institution.getInstId(), Institution.class)).thenReturn(institution);

		institutionDelegate.createInstitution(institution);
		
		Institution institutionById = institutionDelegate.getInstitutionById(institution.getInstId());
		
		assertTrue(institutionById.getInstName().equals(institution.getInstName()));
		
	}
	
	@Test
	public void testfindAll() {
		
		Institution institution1 = new Institution();
		institution1.setInstId(1);
		institution1.setInstAcadloginpassword("loginPassword");
		institution1.setInstAcadloginusername("loginUsername");
		institution1.setInstName("Test institution");
		
		Institution institution2 = new Institution();
		institution2.setInstId(2);
		institution2.setInstAcadloginpassword("loginPassword2");
		institution2.setInstAcadloginusername("loginUsername2");
		institution2.setInstName("Test institution2");
		
		Institution institution3 = new Institution();
		institution3.setInstId(3);
		institution3.setInstAcadloginpassword("loginPassword3");
		institution3.setInstAcadloginusername("loginUsername3");
		institution3.setInstName("Test institution3");
		
		Institution[] institutions = {institution1, institution2, institution3};
		
		Mockito.when(restTemplate.getForObject(SERVER, Institution[].class))
		.thenReturn(new ResponseEntity<Institution[]>(institutions, HttpStatus.OK).getBody());
		Mockito.when(restTemplate.postForEntity(SERVER + "add/", institution1, Institution.class))
		.thenReturn(new ResponseEntity<Institution>(institution1, HttpStatus.OK));
		Mockito.when(restTemplate.postForEntity(SERVER + "add/", institution2, Institution.class))
		.thenReturn(new ResponseEntity<Institution>(institution2, HttpStatus.OK));
		Mockito.when(restTemplate.postForEntity(SERVER + "add/", institution3, Institution.class))
		.thenReturn(new ResponseEntity<Institution>(institution3, HttpStatus.OK));

		institutionDelegate.createInstitution(institution1);
		institutionDelegate.createInstitution(institution2);
		institutionDelegate.createInstitution(institution3);
		
		Iterable<Institution> institutionAll = institutionDelegate.findAll();
		
		assertTrue(institutionAll.iterator().next().equals(institution1));
		
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test
	public void testDelete() {
		
		Institution institution = new Institution();
		institution.setInstId(123);
		institution.setInstAcadloginpassword("loginPassword");
		institution.setInstAcadloginusername("loginUsername");
		institution.setInstName("Test institution");
		
		Mockito.when(restTemplate.postForEntity(SERVER + "add/", institution, Institution.class))
		.thenReturn(new ResponseEntity<Institution>(institution, HttpStatus.ACCEPTED));
		
		institutionDelegate.createInstitution(institution);
		
		Mockito.doNothing().when(restTemplate).delete(SERVER + institution.getInstId());
		institutionDelegate.delete(institution.getInstId());

		Mockito.when(restTemplate.getForObject(SERVER + "show/" + institution.getInstId(), null))
				.thenReturn(new ResponseEntity(null, HttpStatus.OK).getBody());
		assertNull(institutionDelegate.getInstitutionById(institution.getInstId()));
		
	}

}
