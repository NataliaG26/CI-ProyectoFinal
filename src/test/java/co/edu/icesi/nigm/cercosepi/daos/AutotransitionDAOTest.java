package co.edu.icesi.nigm.cercosepi.daos;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

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
import co.edu.icesi.back.model.Autotransition;

@SpringBootTest
@ContextConfiguration(classes= RastreoCercosEpidemiologicosApplication.class)
@TestMethodOrder(OrderAnnotation.class)
public class AutotransitionDAOTest {
	
	@Autowired
	private AutotransitionDAO autotranDao;
	
	private Autotransition autotran;
	
	private void setup1() {
		autotran = new Autotransition();
		autotran.setAutotranName("Autotransition 1");				
		autotran.setAutotranIsactive("Y");
		autotran.setAutotranLogicaloperand("OR");
	}
	
	@Test
	@Order(1)
	@DisplayName("Save")
	public void testDaoSaveAutotransition() {
		setup1();
		autotranDao.Save(autotran);
		assertEquals(1,autotranDao.findAll().size());
		
		Autotransition autotran2 = new Autotransition();
		autotran2.setAutotranName("Autotransition 2");				
		autotran2.setAutotranIsactive("N");
		autotran2.setAutotranLogicaloperand("AND");
		
		autotranDao.Save(autotran2);
		assertEquals(2,autotranDao.findAll().size());
	}
	
	@Test
	@Order(2)
	@DisplayName("Delete")
	public void testDaoDeleteAutotransition() {				
		autotranDao.Delete(autotranDao.findAll().get(0));
		assertEquals(0,autotranDao.findAll().size(),"");
	}
	
	@Test
	@Order(3)
	@DisplayName("Edit")
	public void testDaoEditAutotransition(){
		setup1();
		autotranDao.Save(autotran);
		assertEquals("Test",autotranDao.findById(2).getAutotranName());
		autotran.setAutotranName("TestNewName");
		autotranDao.Edit(autotran);
		assertEquals("TestNewName",autotranDao.findById(2).getAutotranName());
	}
	
	@Test
	@Order(4)
	@DisplayName("Find By Id")
	public void testDaoFindById() {
		long id = autotran.getAutotranId();
		assertNotNull(autotranDao.findById(id));
	}
	
	@Test
	@Order(5)
	@DisplayName("Find By Name")
	public void testDaoFindByName() {		
		assertNotNull(autotranDao.findByName("Autotransition 3"));
		assertEquals(1,autotranDao.findByName("Autotransition 3").size());
		assertEquals("Autotransition 3", autotranDao.findByName("Autotransition 3").get(0).getAutotranName());
	}
	
	@Test
	@Order(6)
	@DisplayName("Find By Is Active")
	public void testDaoFindByIsActive() {		
		assertNotNull(autotranDao.findByIsactive("Y"));
		assertEquals(1,autotranDao.findByIsactive("Y").size());
		assertEquals("Y", autotranDao.findByName("Y").get(0).getAutotranName());
	}
	
	@Test
	@Order(7)
	@DisplayName("Find By Is Active")
	public void testDaoFindByLogicOperand() {		
		assertNotNull(autotranDao.findByLogicOperand("AND"));
		assertEquals(1,autotranDao.findByLogicOperand("AND").size());
		assertEquals("AND", autotranDao.findByLogicOperand("AND").get(0).getAutotranName());
	}
	
}
