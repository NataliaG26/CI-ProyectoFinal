package co.edu.icesi.nigm.cercosepi.daos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import co.edu.icesi.RastreoCercosEpidemiologicosApplication;
import co.edu.icesi.back.daos.interfaces.AutotransitionDAO;
import co.edu.icesi.back.daos.interfaces.InstitutionDAO;
import co.edu.icesi.back.daos.interfaces.PersonDAO;
import co.edu.icesi.back.daos.interfaces.PersonautotranDAO;
import co.edu.icesi.back.model.Autotransition;
import co.edu.icesi.back.model.Eventstatus;
import co.edu.icesi.back.model.Institution;
import co.edu.icesi.back.model.Person;
import co.edu.icesi.back.model.Personautotran;

@SpringBootTest
@ContextConfiguration(classes= RastreoCercosEpidemiologicosApplication.class)
@TestMethodOrder(OrderAnnotation.class)
public class PersonDAOTest {
	
	@Autowired
	private PersonDAO personDAO;
	
	@Autowired
	private InstitutionDAO institutionDAO;
	
	@Autowired
	private AutotransitionDAO autotranDAO;
	
	@Autowired
	private PersonautotranDAO personautotranDAO;
	
	private Person person;
	
	private Institution institution1;
	
	private Autotransition autotransition;
	
	public void setUp1() {
		institution1 = new Institution();
		institution1 = new Institution();
		institution1.setInstName("Universidad Icesi");
		institution1.setInstAcademicserverurl("https://www.icesi.edu.co/es/");
		institution1.setInstAcadextradataurl("https://www.icesi.edu.co/es/");
		institution1.setInstAcadloginurl("https://www.icesi.edu.co/es/");
		institution1.setInstAcadpersoninfodocurl("https://www.icesi.edu.co/es/");
		institution1.setInstAcadpersoninfoidurl("https://www.icesi.edu.co/es/");
		institution1.setInstAcadphysicalspacesurl("https://www.icesi.edu.co/es/");
		institution1.setInstAcadprogrammedcoursesurl("https://www.icesi.edu.co/es/");
		institution1.setInstLdapurl("https://www.icesi.edu.co/es/");
		institutionDAO.Save(institution1);
		
		person = new Person();
		person.setInstitution(institution1);
		person.setPersName("Natalia Isabel");
		person.setPersLastname("Gonzalez Murillo");
		person.setPersEmail("natalia.isa@gmail.com");
		person.setPersIddocument("1144109775");
	}
	
	public void setUp2() {
		Institution institution2 = new Institution();
		institution2 = new Institution();
		institution2.setInstName("Universidad Icesi 2");
		institution2.setInstAcademicserverurl("https://www.icesi.edu.co/es/");
		institution2.setInstAcadextradataurl("https://www.icesi.edu.co/es/");
		institution2.setInstAcadloginurl("https://www.icesi.edu.co/es/");
		institution2.setInstAcadpersoninfodocurl("https://www.icesi.edu.co/es/");
		institution2.setInstAcadpersoninfoidurl("https://www.icesi.edu.co/es/");
		institution2.setInstAcadphysicalspacesurl("https://www.icesi.edu.co/es/");
		institution2.setInstAcadprogrammedcoursesurl("https://www.icesi.edu.co/es/");
		institution2.setInstLdapurl("https://www.icesi.edu.co/es/");
		institutionDAO.Save(institution2);
	}
	
	public void setUp3() {
		Eventstatus eventstatus1  = new Eventstatus();
		eventstatus1.setEvestatId(1);
		Eventstatus eventstatus2 = new Eventstatus();
		eventstatus2.setEvestatId(2);
		autotransition = new Autotransition();
		autotransition.setInstInstId(new BigDecimal(1));
		autotransition.setEventstatus1(eventstatus1);
		autotransition.setEventstatus2(eventstatus2);
		autotransition.setAutotranIsactive("Y");
		autotransition.setAutotranName("Autotransition 1");
		autotransition.setAutotranLogicaloperand("AND");
		autotranDAO.Save(autotransition);
		
		Autotransition autotransition2 = new Autotransition();
		autotransition2.setInstInstId(new BigDecimal(1));
		autotransition2.setEventstatus1(eventstatus1);
		autotransition2.setEventstatus2(eventstatus2);
		autotransition2.setAutotranIsactive("Y");
		autotransition2.setAutotranName("Autotransition 2");
		autotransition2.setAutotranLogicaloperand("AND");
		autotranDAO.Save(autotransition2);
		
		Personautotran personautotran = new Personautotran();
		personautotran.setPerson(person);
		personautotran.setAutotransition(autotransition);
		personautotranDAO.Save(personautotran);
		
		Personautotran personautotran2 = new Personautotran();
		personautotran2.setPerson(person);
		personautotran2.setAutotransition(autotransition2);
		personautotranDAO.Save(personautotran2);
	}
	
	@Test
	@Order(1)
	@DisplayName("Save")
	public void testDaoSavePerson() {
		assertEquals(0, personDAO.findAll().size());
		personDAO.Save(person);
		assertEquals(1, personDAO.findAll().size());
		Person person2 = new Person();
		person2.setInstitution(institution1);
		person2.setPersName("Isabel");
		person2.setPersLastname("Murillo");
		person2.setPersEmail("isa@gmail.com");
		person2.setPersIddocument("34552431");
		personDAO.Save(person2);
		assertEquals(2, personDAO.findAll().size());
	}
	
	@Test
	@Order(2)
	@DisplayName("Find By Id")
	public void testDaoFindById() {
		long id = person.getPersId();
		String name = person.getPersName();
		assertNotNull(personDAO.findById(id).getPersName());
		assertEquals(name, personDAO.findById(id).getPersName());
	}
	
	@Test
	@Order(3)
	@DisplayName("Edit")
	public void testDaoEditPerson() {
		String newName = "Isabel";
		person.setPersName(newName);
		personDAO.Edit(person);
		long id = person.getPersId();
		assertEquals(newName, personDAO.findById(id).getPersName());
	}
	
	@Test
	@Order(4)
	@DisplayName("Find By Id Document")
	public void testDaoFindByIdDoc() {
		String doc = person.getPersIddocument();
		assertNotNull(personDAO.findByIdDoc(doc));
		assertEquals(1, personDAO.findByIdDoc(doc).size());
		assertEquals(person.getPersName(), personDAO.findByIdDoc(doc).get(0).getPersName());
	}
	
	@Test
	@Order(5)
	@DisplayName("Find By Id Institution")
	public void testDaoFindByInstitution() {
		setUp2();
		long idInst = institution1.getInstId();
		assertEquals(2, personDAO.findByInstitution(idInst).size());
	}
	
	@Test
	@Order(6)
	@DisplayName("Find Autotran Active In Date Range")
	public void testDaoFindAutotranActiveInDateRange() {
		setUp3();
		List<Person> persons = personDAO.findAutotranActiveInDateRange(2, "11/05/2020", "05/05/2021");
		assertEquals(1, persons.size());
		long id = person.getPersId();
		assertEquals(id, persons.get(0).getPersId());
	}
	
	@Test
	@Order(7)
	@DisplayName("Delete")
	public void testDaoDelete() {
		assertEquals(1, personDAO.findAll().size());
		personDAO.Delete(person);
		assertEquals(0, personDAO.findAll().size());
	}
	

}
