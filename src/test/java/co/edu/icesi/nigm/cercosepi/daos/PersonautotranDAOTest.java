package co.edu.icesi.nigm.cercosepi.daos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.math.BigDecimal;

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
public class PersonautotranDAOTest {
	
	@Autowired
	private PersonautotranDAO personautotranDAO;
	
	@Autowired
	private AutotransitionDAO autotranDAO;
	
	@Autowired
	private InstitutionDAO institutionDAO;
	
	@Autowired
	private PersonDAO personDAO;
	
	private Personautotran personautotran; 
	
	private Autotransition autotransition;
	
	private Person person;
	
	private Institution institution1;
	
	
	
	public void setup1() {
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
		personDAO.Save(person);
		
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
	public void testDaoSavePersonautotran() {
		assertEquals(0,personautotranDAO.findAll().size());
		setup1();
		personautotranDAO.Save(personautotran);
		assertEquals(1,personautotranDAO.findAll().size());
	}
	
	@Test
	@Order(2)
	@DisplayName("Find By Id")
	public void testDaoFindById() {
		long id = personautotran.getPerautId();
		assertNotNull(personautotranDAO.findById(id));
	}
	
	@Test
	@Order(3)
	@DisplayName("Edit")
	public void testDaoEditPersonautotran() {
		
	}
	
	@Test
	@Order(3)
	@DisplayName("Find By PersonId")
	public void testDaoFindByPersonId() {
		
	}
	@Test
	@Order(3)
	@DisplayName("Find By AutotranId")
	public void testDaoFindByAutotranId() {
		
	}
	@Test
	@Order(3)
	@DisplayName("FindByDate")
	public void testDaoFindByDate() {
		
	}
	@Test
	@Order(3)
	@DisplayName("Find By Data Range")
	public void testDaoFindByDataRange() {
		
	}
	
	@Test
	@Order(7)
	@DisplayName("Delete")
	public void testDaoDelete() {
		
	}
	
	
}
