package co.edu.icesi.nigm.cercosepi;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.edu.icesi.back.daos.interfaces.InstitutionDAO;
import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.back.model.Institution;
import co.edu.icesi.back.repository.InstitutionRepository;
import co.edu.icesi.back.service.implementation.InstitutionServiceImpl;
import co.edu.icesi.back.service.interfaces.InstitutionService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class InstitutionUnitTest {
	
	@InjectMocks
	private static InstitutionService institutionService;
	
	@Mock
	private static InstitutionRepository institutionRepository;
	
	@Mock 
	private static InstitutionDAO institutionDAO;
	
	private Optional<Institution> institutionOpt;
	
	private Institution institution;
	
	/// Scenarios
	
	public void sce_inst_allGood() {
		institution = new Institution();
		//institution.setInstId(2);
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
	
	public void sce_inst_noName() {
		sce_inst_allGood();
		institution.setInstId(2);
		institution.setInstName("");
	}
	
	public void sce_inst_nullName() {
		sce_inst_allGood();
		institution.setInstId(2);
		institution.setInstName(null);
	}
	
	public void sce_inst_invalid_instAcademicserverurl() {
		sce_inst_allGood();
		institution.setInstId(2);
		institution.setInstAcademicserverurl("Hola/https");
	}
	
	public void sce_inst_null_instAcademicserverurl() {
		sce_inst_allGood();
		institution.setInstId(2);
		institution.setInstAcademicserverurl(null);
	}
	
	public void sce_inst_invalid_instAcadextradataurl() {
		sce_inst_allGood();
		institution.setInstId(2);
		institution.setInstAcadextradataurl("Hola/https");
	}
	
	public void sce_inst_null_instAcadextradataurl() {
		sce_inst_allGood();
		institution.setInstId(2);
		institution.setInstAcadextradataurl(null);
	}
	
	public void sce_inst_invalid_instAcadloginurl() {
		sce_inst_allGood();
		institution.setInstId(2);
		institution.setInstAcadloginurl("Hola/https");
	}
	
	public void sce_inst_null_instAcadloginurl() {
		sce_inst_allGood();
		institution.setInstId(2);
		institution.setInstAcadloginurl(null);
	}
	
	public void sce_inst_invalid_instAcadpersoninfodocurl() {
		sce_inst_allGood();
		institution.setInstId(2);
		institution.setInstAcadpersoninfodocurl("Hola/https");
	}
	
	public void sce_inst_null_instAcadpersoninfodocurl() {
		sce_inst_allGood();
		institution.setInstId(2);
		institution.setInstAcadpersoninfodocurl(null);
	}
	
	public void sce_inst_invalid_instAcadpersoninfoidurl() {
		sce_inst_allGood();
		institution.setInstId(2);
		institution.setInstAcadpersoninfoidurl("Hola/https");
	}
	
	public void sce_inst_null_instAcadpersoninfoidurl() {
		sce_inst_allGood();
		institution.setInstId(2);
		institution.setInstAcadpersoninfoidurl(null);
	}
	
	public void sce_inst_invalid_instAcadphysicalspacesurl() {
		sce_inst_allGood();
		institution.setInstId(2);
		institution.setInstAcadphysicalspacesurl("Hola/https");
	}
	
	public void sce_inst_null_instAcadphysicalspacesurl() {
		sce_inst_allGood();
		institution.setInstId(2);
		institution.setInstAcadphysicalspacesurl(null);
	}
	
	public void sce_inst_invalid_instAcadprogrammedcoursesurl() {
		sce_inst_allGood();
		institution.setInstId(2);
		institution.setInstAcadprogrammedcoursesurl("Hola/https");
	}
	
	public void sce_inst_null_instAcadprogrammedcoursesurl() {
		sce_inst_allGood();
		institution.setInstId(2);
		institution.setInstAcadprogrammedcoursesurl(null);
	}
	
	public void sce_inst_invalid_instLdapurl() {
		sce_inst_allGood();
		institution.setInstId(2);
		institution.setInstLdapurl("Hola/https");
	}
	
	public void sce_inst_null_instLdapurl() {
		sce_inst_allGood();
		institution.setInstId(2);
		institution.setInstLdapurl(null);
	}
	
	public void sce_inst_null() {
		institution = null;
	}
	
	public void sce_inst_allGodd_for_edit() {
		Institution newInstitution = new Institution();
		newInstitution.setInstId(2);
		newInstitution.setInstName("Universidad Icesi");
		newInstitution.setInstAcademicserverurl("https://www.icesi.edu.co/es/");
		newInstitution.setInstAcadextradataurl("https://www.icesi.edu.co/es/");
		newInstitution.setInstAcadloginurl("https://www.icesi.edu.co/es/");
		newInstitution.setInstAcadpersoninfodocurl("https://www.icesi.edu.co/es/");
		newInstitution.setInstAcadpersoninfoidurl("https://www.icesi.edu.co/es/");
		newInstitution.setInstAcadphysicalspacesurl("https://www.icesi.edu.co/es/");
		newInstitution.setInstAcadprogrammedcoursesurl("https://www.icesi.edu.co/es/");
		newInstitution.setInstLdapurl("https://www.icesi.edu.co/es/");	
		institutionOpt = Optional.of(newInstitution);
	}
	
	public void sce_inst_optional_null() {
		institutionOpt = Optional.of(null);
	}
	
	
	@BeforeAll
	public static void setUp() {
		institutionService = new InstitutionServiceImpl(institutionRepository, institutionDAO);
	}
	
	@Tag("Save")
	@Nested
	class SaveTest{
		
		@Tag("INST_SAVE_001")
		@Test
		void save_institution_allGood() {
			sce_inst_allGood();
			try {
				when(institutionService.createInstitution(institution)).thenReturn(institution);
				assertTrue(true);
				verify(institutionRepository).save(institution);
				verifyNoMoreInteractions(institutionRepository);
			} catch (LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Tag("INST_SAVE_002")
		@Test
		void save_institution_noName() {
			sce_inst_noName();
			assertThrows(LogicalException.class, 
					()-> when(institutionService.createInstitution(institution)).thenReturn(institution));
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_SAVE_003")
		@Test
		void save_institution_nullName() {
			sce_inst_nullName();
			assertThrows(LogicalException.class, 
					()-> when(institutionService.createInstitution(institution)).thenReturn(institution));
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_SAVE_004")
		@Test
		void save_institution_invalid_instAcademicserverurl() {
			sce_inst_invalid_instAcademicserverurl();
			assertThrows(LogicalException.class, 
					()-> when(institutionService.createInstitution(institution)).thenReturn(institution));
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_SAVE_005")
		@Test
		void save_institution_null_instAcademicserverurl() {
			sce_inst_null_instAcademicserverurl();
			assertThrows(LogicalException.class, 
					()-> when(institutionService.createInstitution(institution)).thenReturn(institution));
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_SAVE_006")
		@Test
		void save_institution_invalid_instAcadextradataurl() {
			sce_inst_invalid_instAcadextradataurl();
			assertThrows(LogicalException.class, 
					()-> when(institutionService.createInstitution(institution)).thenReturn(institution));
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_SAVE_007")
		@Test
		void save_institution_null_instAcadextradataurl() {
			sce_inst_null_instAcadextradataurl();
			assertThrows(LogicalException.class, 
					()-> when(institutionService.createInstitution(institution)).thenReturn(institution));
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_SAVE_008")
		@Test
		void save_institution_invalid_instAcadloginurl() {
			sce_inst_invalid_instAcadloginurl();
			assertThrows(LogicalException.class, 
					()-> when(institutionService.createInstitution(institution)).thenReturn(institution));
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_SAVE_009")
		@Test
		void save_institution_null_instAcadloginurl() {
			sce_inst_null_instAcadloginurl();
			assertThrows(LogicalException.class, 
					()-> when(institutionService.createInstitution(institution)).thenReturn(institution));
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_SAVE_010")
		@Test
		void save_institution_invalid_instAcadpersoninfodocurl() {
			sce_inst_invalid_instAcadpersoninfodocurl();
			assertThrows(LogicalException.class, 
					()-> when(institutionService.createInstitution(institution)).thenReturn(institution));
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_SAVE_011")
		@Test
		void save_institution_null_instAcadpersoninfodocurl() {
			sce_inst_null_instAcadpersoninfodocurl();
			assertThrows(LogicalException.class, 
					()-> when(institutionService.createInstitution(institution)).thenReturn(institution));
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_SAVE_012")
		@Test
		void save_institution_invalid_instAcadpersoninfoidurl() {
			sce_inst_invalid_instAcadpersoninfoidurl();
			assertThrows(LogicalException.class, 
					()-> when(institutionService.createInstitution(institution)).thenReturn(institution));
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_SAVE_013")
		@Test
		void save_institution_null_instAcadpersoninfoidurl() {
			sce_inst_null_instAcadpersoninfoidurl();
			assertThrows(LogicalException.class, 
					()-> when(institutionService.createInstitution(institution)).thenReturn(institution));
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_SAVE_014")
		@Test
		void save_institution_invalid_instAcadphysicalspacesurl() {
			sce_inst_invalid_instAcadphysicalspacesurl();
			assertThrows(LogicalException.class, 
					()-> when(institutionService.createInstitution(institution)).thenReturn(institution));
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_SAVE_015")
		@Test
		void save_institution_null_instAcadphysicalspacesurl() {
			sce_inst_null_instAcadphysicalspacesurl();
			assertThrows(LogicalException.class, 
					()-> when(institutionService.createInstitution(institution)).thenReturn(institution));
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_SAVE_016")
		@Test
		void save_institution_invalid_instAcadprogrammedcoursesurl() {
			sce_inst_invalid_instAcadprogrammedcoursesurl();
			assertThrows(LogicalException.class, 
					()-> when(institutionService.createInstitution(institution)).thenReturn(institution));
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_SAVE_017")
		@Test
		void save_institution_null_instAcadprogrammedcoursesurl() {
			sce_inst_null_instAcadprogrammedcoursesurl();
			assertThrows(LogicalException.class, 
					()-> when(institutionService.createInstitution(institution)).thenReturn(institution));
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_SAVE_018")
		@Test
		void save_institution_invalid_instLdapurl() {
			sce_inst_invalid_instLdapurl();
			assertThrows(LogicalException.class, 
					()-> when(institutionService.createInstitution(institution)).thenReturn(institution));
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_SAVE_019")
		@Test
		void save_institution_null_instLdapurl() {
			sce_inst_null_instLdapurl();
			assertThrows(LogicalException.class, 
					()-> when(institutionService.createInstitution(institution)).thenReturn(institution));
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_SAVE_020")
		@Test
		void save_institution_null() {
			sce_inst_null();
			assertThrows(LogicalException.class, 
					()-> when(institutionService.createInstitution(institution)).thenReturn(institution));
			verifyNoMoreInteractions(institutionRepository);
		}

	}
	
	
	
	@Tag("Update")
	@Nested
	class UpdateTest{
		
		@Tag("INST_EDIT_001")
		@Test
		void edit_institution_allGood() {
			sce_inst_allGood();
			sce_inst_allGodd_for_edit();
			long id = institution.getInstId();			
			when(institutionRepository.findById(id)).thenReturn(institutionOpt);
			try {
				when(institutionService.updateInstitution(institution)).thenReturn(institution);
				assertTrue(true);
			} catch (LogicalException e) {
				assertTrue(false);
			}
			Institution inst = institutionRepository.findById(id).get();
			verify(institutionRepository).findById(id);
			verify(institutionRepository).save(inst);
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_EDIT_002")
		@Test
		void edit_institution_noName() {
			sce_inst_noName();
			sce_inst_allGodd_for_edit();
			long id = institution.getInstId();			
			when(institutionRepository.findById(id)).thenReturn(institutionOpt);
			assertThrows(LogicalException.class, 
					()-> when(institutionService.updateInstitution(institution)).thenReturn(institution));
			verify(institutionRepository).findById(id);
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_EDIT_003")
		@Test
		void edit_institution_nullName() {
			sce_inst_nullName();
			sce_inst_allGodd_for_edit();
			long id = institution.getInstId();			
			when(institutionRepository.findById(id)).thenReturn(institutionOpt);
			assertThrows(LogicalException.class, 
					()-> when(institutionService.updateInstitution(institution)).thenReturn(institution));
			verify(institutionRepository).findById(id);
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_EDIT_004")
		@Test
		void edit_institution_invalid_instAcademicserverurl() {
			sce_inst_invalid_instAcademicserverurl();
			sce_inst_allGodd_for_edit();
			long id = institution.getInstId();			
			when(institutionRepository.findById(id)).thenReturn(institutionOpt);
			assertThrows(LogicalException.class, 
					()-> when(institutionService.updateInstitution(institution)).thenReturn(institution));
			verify(institutionRepository).findById(id);
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_EDIT_005")
		@Test
		void edit_institution_null_instAcademicserverurl() {
			sce_inst_null_instAcademicserverurl();
			sce_inst_allGodd_for_edit();
			long id = institution.getInstId();			
			when(institutionRepository.findById(id)).thenReturn(institutionOpt);
			assertThrows(LogicalException.class, 
					()-> when(institutionService.updateInstitution(institution)).thenReturn(institution));
			verify(institutionRepository).findById(id);
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_EDIT_006")
		@Test
		void edit_institution_invalid_instAcadextradataurl() {
			sce_inst_invalid_instAcadextradataurl();
			sce_inst_allGodd_for_edit();
			long id = institution.getInstId();			
			when(institutionRepository.findById(id)).thenReturn(institutionOpt);
			assertThrows(LogicalException.class, 
					()-> when(institutionService.updateInstitution(institution)).thenReturn(institution));
			verify(institutionRepository).findById(id);
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_EDIT_007")
		@Test
		void edit_institution_null_instAcadextradataurl() {
			sce_inst_null_instAcadextradataurl();
			sce_inst_allGodd_for_edit();
			long id = institution.getInstId();			
			when(institutionRepository.findById(id)).thenReturn(institutionOpt);
			assertThrows(LogicalException.class, 
					()-> when(institutionService.updateInstitution(institution)).thenReturn(institution));
			verify(institutionRepository).findById(id);
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_EDIT_008")
		@Test
		void edit_institution_invalid_instAcadloginurl() {
			sce_inst_invalid_instAcadloginurl();
			sce_inst_allGodd_for_edit();
			long id = institution.getInstId();			
			when(institutionRepository.findById(id)).thenReturn(institutionOpt);
			assertThrows(LogicalException.class, 
					()-> when(institutionService.updateInstitution(institution)).thenReturn(institution));
			verify(institutionRepository).findById(id);
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_EDIT_009")
		@Test
		void edit_institution_null_instAcadloginurl() {
			sce_inst_null_instAcadloginurl();
			sce_inst_allGodd_for_edit();
			long id = institution.getInstId();			
			when(institutionRepository.findById(id)).thenReturn(institutionOpt);
			assertThrows(LogicalException.class, 
					()-> when(institutionService.updateInstitution(institution)).thenReturn(institution));
			verify(institutionRepository).findById(id);
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_EDIT_010")
		@Test
		void edit_institution_invalid_instAcadpersoninfodocurl() {
			sce_inst_invalid_instAcadpersoninfodocurl();
			sce_inst_allGodd_for_edit();
			long id = institution.getInstId();			
			when(institutionRepository.findById(id)).thenReturn(institutionOpt);
			assertThrows(LogicalException.class, 
					()-> when(institutionService.updateInstitution(institution)).thenReturn(institution));
			verify(institutionRepository).findById(id);
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_EDIT_011")
		@Test
		void edit_institution_null_instAcadpersoninfodocurl() {
			sce_inst_null_instAcadpersoninfodocurl();
			sce_inst_allGodd_for_edit();
			long id = institution.getInstId();			
			when(institutionRepository.findById(id)).thenReturn(institutionOpt);
			assertThrows(LogicalException.class, 
					()-> when(institutionService.updateInstitution(institution)).thenReturn(institution));
			verify(institutionRepository).findById(id);
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_EDIT_012")
		@Test
		void edit_institution_invalid_instAcadpersoninfoidurl() {
			sce_inst_invalid_instAcadpersoninfoidurl();
			sce_inst_allGodd_for_edit();
			long id = institution.getInstId();			
			when(institutionRepository.findById(id)).thenReturn(institutionOpt);
			assertThrows(LogicalException.class, 
					()-> when(institutionService.updateInstitution(institution)).thenReturn(institution));
			verify(institutionRepository).findById(id);
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_EDIT_013")
		@Test
		void edit_institution_null_instAcadpersoninfoidurl() {
			sce_inst_null_instAcadpersoninfoidurl();
			sce_inst_allGodd_for_edit();
			long id = institution.getInstId();			
			when(institutionRepository.findById(id)).thenReturn(institutionOpt);
			assertThrows(LogicalException.class, 
					()-> when(institutionService.updateInstitution(institution)).thenReturn(institution));
			verify(institutionRepository).findById(id);
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_EDIT_014")
		@Test
		void edit_institution_invalid_instAcadphysicalspacesurl() {
			sce_inst_invalid_instAcadphysicalspacesurl();
			sce_inst_allGodd_for_edit();
			long id = institution.getInstId();			
			when(institutionRepository.findById(id)).thenReturn(institutionOpt);
			assertThrows(LogicalException.class, 
					()-> when(institutionService.updateInstitution(institution)).thenReturn(institution));
			verify(institutionRepository).findById(id);
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_EDIT_015")
		@Test
		void edit_institution_null_instAcadphysicalspacesurl() {
			sce_inst_null_instAcadphysicalspacesurl();
			sce_inst_allGodd_for_edit();
			long id = institution.getInstId();			
			when(institutionRepository.findById(id)).thenReturn(institutionOpt);
			assertThrows(LogicalException.class, 
					()-> when(institutionService.updateInstitution(institution)).thenReturn(institution));
			verify(institutionRepository).findById(id);
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_EDIT_016")
		@Test
		void edit_institution_invalid_instAcadprogrammedcoursesurl() {
			sce_inst_null_instAcadprogrammedcoursesurl();
			sce_inst_allGodd_for_edit();
			long id = institution.getInstId();			
			when(institutionRepository.findById(id)).thenReturn(institutionOpt);
			assertThrows(LogicalException.class, 
					()-> when(institutionService.updateInstitution(institution)).thenReturn(institution));
			verify(institutionRepository).findById(id);
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_EDIT_017")
		@Test
		void edit_institution_null_instAcadprogrammedcoursesurl() {
			sce_inst_null_instAcadprogrammedcoursesurl();
			sce_inst_allGodd_for_edit();
			long id = institution.getInstId();			
			when(institutionRepository.findById(id)).thenReturn(institutionOpt);
			assertThrows(LogicalException.class, 
					()-> when(institutionService.updateInstitution(institution)).thenReturn(institution));
			verify(institutionRepository).findById(id);
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_EDIT_018")
		@Test
		void edit_institution_invalid_instLdapurl() {
			sce_inst_invalid_instLdapurl();
			sce_inst_allGodd_for_edit();
			long id = institution.getInstId();			
			when(institutionRepository.findById(id)).thenReturn(institutionOpt);
			assertThrows(LogicalException.class, 
					()-> when(institutionService.updateInstitution(institution)).thenReturn(institution));
			verify(institutionRepository).findById(id);
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_EDIT_019")
		@Test
		void edit_institution_null_instLdapurl() {
			sce_inst_null_instLdapurl();
			sce_inst_allGodd_for_edit();
			long id = institution.getInstId();			
			when(institutionRepository.findById(id)).thenReturn(institutionOpt);
			assertThrows(LogicalException.class, 
					()-> when(institutionService.updateInstitution(institution)).thenReturn(institution));
			verify(institutionRepository).findById(id);
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_EDIT_020")
		@Test
		void edit_institution_null() {
			sce_inst_null();
			sce_inst_allGodd_for_edit();
			assertThrows(LogicalException.class, 
					()-> when(institutionService.updateInstitution(institution)).thenReturn(institution));
			verifyNoMoreInteractions(institutionRepository);
		}
		
		@Tag("INST_EDIT_021")
		@Test
		void edit_institution_notFound() {
			sce_inst_allGood();
			sce_inst_optional_null();
			long id = institution.getInstId();			
			when(institutionRepository.findById(id)).thenReturn(institutionOpt);
			assertThrows(LogicalException.class, 
					()-> when(institutionService.updateInstitution(institution)).thenReturn(institution));
			verify(institutionRepository).findById(id);
			verifyNoMoreInteractions(institutionRepository);
		}

	}
	

}
