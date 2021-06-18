package co.edu.icesi.nigm.cercosepi.daos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import co.edu.icesi.RastreoCercosEpidemiologicosApplication;
import co.edu.icesi.back.daos.interfaces.InstitutionDAO;
import co.edu.icesi.back.model.Institution;

@SpringBootTest
@ContextConfiguration(classes= RastreoCercosEpidemiologicosApplication.class)
@TestMethodOrder(OrderAnnotation.class)
public class InstitutionDAOTest {
	
	@Autowired
	private InstitutionDAO institutionDAO; 
	
	private Institution institution;

	private void setUp1() {
		Institution institution = new Institution();
		institution = new Institution();
		institution.setInstName("Universidad Icesi");
		institution.setInstAcademicserverurl("https://www.icesi.edu.co/es/");
		institution.setInstAcadextradataurl("https://www.icesi.edu.co/es/");
		institution.setInstAcadloginurl("https://www.icesi.edu.co/es/");
		institution.setInstAcadpersoninfodocurl("https://www.icesi.edu.co/es/");
		institution.setInstAcadpersoninfoidurl("https://www.icesi.edu.co/es/");
		institution.setInstAcadphysicalspacesurl("https://www.icesi.edu.co/es/");
		institution.setInstAcadprogrammedcoursesurl("https://www.icesi.edu.co/es/");
		institution.setInstLdapurl("https://www.icesi.edu.co/es/");
	}
	
	@Test
	@Order(1)
	@DisplayName("Save")
	public void testDaoSaveInstitution() {
		setUp1();
		institutionDAO.Save(institution);
		assertEquals(1, institutionDAO.findAll());
		
	}
	
	@Test
	@Order(2)
	@DisplayName("Find By Id")
	public void testDaoFindById(){
		long id = institution.getInstId();
		assertNotNull(institutionDAO.findById(id));
		assertNull(institutionDAO.findById(2));
	}
	
	@Test
	@Order(3)
	@DisplayName("Edit")
	public void testDaoEditInstitution(){
		institution.setInstName("Institution 1");
		institutionDAO.Edit(institution);
		assertEquals("Institution 1", institutionDAO.findById(institution.getInstId()).getInstName());
	}
	
	@Test
	@Order(4)
	@DisplayName("Delete")
	public void testDaoDeleteInstitution(){
		institutionDAO.Delete(institution);
		assertEquals(0, institutionDAO.findAll().size());		
	}
	
	
	
}
