package co.edu.icesi.nigm.cercosepi;

import java.util.Date;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.edu.icesi.back.daos.interfaces.PersonautotranDAO;
import co.edu.icesi.back.model.Autotransition;
import co.edu.icesi.back.model.Person;
import co.edu.icesi.back.model.Personautotran;
import co.edu.icesi.back.repository.PersonautotranRepository;
import co.edu.icesi.back.service.implementation.PersonautotranServiceImpl;
import co.edu.icesi.back.service.interfaces.AutotransitionService;
import co.edu.icesi.back.service.interfaces.PersonService;
import co.edu.icesi.back.service.interfaces.PersonautotranService;
import lombok.extern.java.Log;

@Log
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PersonautotranUnitTest {
	
	@InjectMocks
	private static PersonautotranService personautotranService;
	
	@Mock
	private static PersonautotranRepository personautotranRepository;
	
	@Mock
	private static PersonService personService;
	
	@Mock
	private static AutotransitionService autotransitionService;
	
	@Mock 
	private static PersonautotranDAO personautotranDAO;
	
	private Optional<Person> personOpt;
	
	private Optional<Autotransition> autotransitionOpt;
	
	private Optional<Personautotran> personautotranOpt;
	
	private Person person;
	
	private Autotransition autotransition;
	
	private Personautotran personautotran;
	
	//Scenarios
	
	@SuppressWarnings("deprecation")
	public void sce_persautotran_allGood() {
		person = new Person();
		autotransition = new Autotransition();
		personOpt = Optional.of(person);
		autotransitionOpt = Optional.of(autotransition);
		personautotran.setPerson(person);
		personautotran.setAutotransition(autotransition);
		personautotran.setPerautDate(new Date("2/2/2021"));
	}
	
	public void sce_persautotran_null_person() {
		sce_persautotran_allGood();
		personautotran.setPerson(null);
	}
	
	public void sce_persautotran_null_autotransition() {
		sce_persautotran_allGood();
		personautotran.setAutotransition(null);
	}
	
	public void sce_persautotran_null_date() {
		sce_persautotran_allGood();
		personautotran.setPerautDate(null);
	}
	
	@SuppressWarnings("deprecation")
	public void sce_persautotran_after_date() {
		sce_persautotran_allGood();
		personautotran.setPerautDate(new Date("2/2/2022"));
	}
	
	public void sce_persautotran_null_personautotran() {
		personautotran = null;
		
	}
	
	@SuppressWarnings("deprecation")
	public void sce_persautotran_personautotran_forEdit() {
		sce_persautotran_allGood();
		Personautotran newPersonautotran = new Personautotran();
		newPersonautotran.setPerson(person);
		newPersonautotran.setAutotransition(autotransition);
		newPersonautotran.setPerautDate(new Date("2/2/2022"));
		personautotranOpt = Optional.of(newPersonautotran);
	}
	
	@BeforeAll
	public static void setUp() {
		personautotranService = new PersonautotranServiceImpl(personautotranRepository, personService, autotransitionService, personautotranDAO);
	}
	
	@Tag("Save")
	@Nested
	class SaveTest{
		
		
	}
	
	@Tag("Update")
	@Nested
	class UpdateTest{
		
		
	}

}
