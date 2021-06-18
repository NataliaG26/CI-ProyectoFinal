package co.edu.icesi.nigm.cercosepi;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import co.edu.icesi.back.back.service.interfaces.AutotransitionDelegate;
import co.edu.icesi.back.daos.interfaces.AutotransitionDAO;
import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.back.model.Autotransition;
import co.edu.icesi.back.model.Eventstatus;
import co.edu.icesi.back.model.Institution;
import co.edu.icesi.back.repository.AutotransitionRepository;
import co.edu.icesi.back.service.implementation.AutotransitionServiceImpl;
<<<<<<< HEAD
=======
import co.edu.icesi.back.service.interfaces.AutotransitionService;
>>>>>>> 3e673c56906c6dfaede13c54d30b358835dcd430
import co.edu.icesi.back.service.interfaces.InstitutionService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class AutotransitionUnitTest {
	
	@InjectMocks
	private static AutotransitionService autotransitionService;
	
	@Mock
	private static InstitutionService institutionService;
	
	@Mock
	private static AutotransitionRepository autotransitionRepository;
	
	@Mock
	private static AutotransitionDAO autotransitionDAO;
	
	private Eventstatus eventstatus1;
	
	private Eventstatus eventstatus2;
	
	private Optional<Institution> institutionOpt;
	
	private Optional<Autotransition> autotransitionOpt;
	
	private Autotransition autotransition;
	
	@BeforeAll
	public static void setUp() {
		//institutionService = new InstitutionServiceImpl(institutionRepository);
		autotransitionService = new AutotransitionServiceImpl(autotransitionRepository, institutionService, autotransitionDAO);
	}
	
	//Scenearios
	
	public void sce_autotran_allGood1() {
		eventstatus1 = new Eventstatus();
		eventstatus1.setEvestatId(1);
		eventstatus2 = new Eventstatus();
		eventstatus2.setEvestatId(2);
		Institution inst = new Institution();
		inst.setInstId(1);
		institutionOpt = Optional.of(inst);
		autotransition = new Autotransition();
		autotransition.setInstInstId(new BigDecimal(1));
		autotransition.setAutotranId(1);
		autotransition.setEventstatus1(eventstatus1);
		autotransition.setEventstatus2(eventstatus2);
		autotransition.setAutotranIsactive("Y");
		autotransition.setAutotranName("Autotransition 1");
		autotransition.setAutotranLogicaloperand("AND");
	}
	
	public void sce_autotran_allGood2() {
		eventstatus1 = new Eventstatus();
		eventstatus1.setEvestatId(1);
		eventstatus2 = new Eventstatus();
		eventstatus2.setEvestatId(2);
		Institution inst = new Institution();
		inst.setInstId(1);
		institutionOpt = Optional.of(inst);
		autotransition = new Autotransition();
		autotransition.setInstInstId(new BigDecimal(1));
		autotransition.setAutotranId(1);
		autotransition.setEventstatus1(eventstatus1);
		autotransition.setEventstatus2(eventstatus2);
		autotransition.setAutotranIsactive("N");
		autotransition.setAutotranName("Autotransition 1");
		autotransition.setAutotranLogicaloperand("OR");
	}
	
	public void sce_autotran_null_eventstatus1() {
		sce_autotran_allGood1();
		autotransition.setEventstatus1(null);
	}
	
	public void sce_autotran_null_eventstatus2() {
		sce_autotran_allGood1();
		autotransition.setEventstatus2(null);
	}
	
	public void sce_autotran_notFound_inst() {
		sce_autotran_allGood1();
		//institutionOpt = Optional.of(null);
		autotransition.setInstInstId(new BigDecimal(2));
	}
	
	public void sce_autotran_invalid_autotranIsActive() {
		sce_autotran_allGood1();
		autotransition.setAutotranIsactive("Yes");
	}
	
	public void sce_autotran_null_autotranIsActive() {
		sce_autotran_allGood1();
		autotransition.setAutotranIsactive(null);
	}
	
	public void sce_autotran_noName() {
		sce_autotran_allGood1();
		autotransition.setAutotranName("");
	}
	
	public void sce_autotran_null_name() {
		sce_autotran_allGood1();
		autotransition.setAutotranName(null);
	}
	
	public void sce_autotran_invalid_autotranLogicaloperand() {
		sce_autotran_allGood1();
		autotransition.setAutotranLogicaloperand("AND/OR");
	}
	
	public void sce_autotran_null_autotranLogicaloperand() {
		sce_autotran_allGood1();
		autotransition.setAutotranLogicaloperand(null);
	}
	
	public void sce_autotran_allGood_forNoFoundAutotran() {
		sce_autotran_allGood1();
		//autotransitionOpt = Optional.of(null);
	}
	
	public void sce_autotran_null_autotran() {
		autotransition = null;
	}
	
	public void sce_autotran_allGood_for_edit() {
		Autotransition newautotransition = new Autotransition();
		newautotransition.setInstInstId(new BigDecimal(1));
		newautotransition.setAutotranId(1);
		newautotransition.setEventstatus1(eventstatus1);
		newautotransition.setEventstatus2(eventstatus2);
		newautotransition.setAutotranIsactive("Y");
		newautotransition.setAutotranName("Autotransition 1");
		newautotransition.setAutotranLogicaloperand("AND");
		autotransitionOpt = Optional.of(newautotransition);
	}
	
	@Tag("Save")
	@Nested
	class SaveTest{
		
		@Test
		public void save_autotran_good1() {
			sce_autotran_allGood1();
			try {
				long idInst = autotransition.getInstInstId().longValue();
				when(institutionService.getInstitutionById(idInst)).thenReturn(institutionOpt.get());
				when(autotransitionService.createAutotransition(autotransition)).thenReturn(autotransition);
				assertTrue(true);
				verify(institutionService).getInstitutionById(idInst);
				verify(autotransitionRepository).save(autotransition);
				verifyNoMoreInteractions(autotransitionRepository);
			}catch(LogicalException e) {
				assertTrue(false);
				
			}
		}
		
		@Test
		public void save_autotran_good2() {
			sce_autotran_allGood2();
			try {
				long idInst = autotransition.getInstInstId().longValue();
				when(institutionService.getInstitutionById(idInst)).thenReturn(institutionOpt.get());
				when(autotransitionService.createAutotransition(autotransition)).thenReturn(autotransition);
				assertTrue(true);
				verify(institutionService).getInstitutionById(idInst);
				verify(autotransitionRepository).save(autotransition);
				verifyNoMoreInteractions(autotransitionRepository);
				verifyNoMoreInteractions(institutionService);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void save_autotran_null_evenstatus1() {
			sce_autotran_null_eventstatus1();
			try {
				long idInst = autotransition.getInstInstId().longValue();
				when(institutionService.getInstitutionById(idInst)).thenReturn(institutionOpt.get());
				assertThrows(LogicalException.class, 
						()-> when(autotransitionService.createAutotransition(autotransition)).thenReturn(autotransition));
				verify(institutionService).getInstitutionById(idInst);
				verifyNoMoreInteractions(autotransitionRepository);
			} catch (LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void save_autotran_null_evenstatus2() {
			sce_autotran_null_eventstatus2();
			try {
				long idInst = autotransition.getInstInstId().longValue();
				when(institutionService.getInstitutionById(idInst)).thenReturn(institutionOpt.get());
				assertThrows(LogicalException.class, 
						()-> when(autotransitionService.createAutotransition(autotransition)).thenReturn(autotransition));
				verify(institutionService).getInstitutionById(idInst);
				verifyNoMoreInteractions(autotransitionRepository);
			} catch (LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void save_autotran_noFound_inst() {
			sce_autotran_notFound_inst();
			try {
				long idInst = autotransition.getInstInstId().longValue();
				when(institutionService.getInstitutionById(idInst)).thenThrow(LogicalException.class);
				assertThrows(LogicalException.class, 
						()-> when(autotransitionService.createAutotransition(autotransition)).thenReturn(autotransition));
				verifyNoMoreInteractions(autotransitionRepository);
			} catch (LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void save_autotran_invalid_autotranIsActive() {
			sce_autotran_invalid_autotranIsActive();
			try {
				long idInst = autotransition.getInstInstId().longValue();
				when(institutionService.getInstitutionById(idInst)).thenReturn(institutionOpt.get());
				assertThrows(LogicalException.class, 
						()-> when(autotransitionService.createAutotransition(autotransition)).thenReturn(autotransition));
				verify(institutionService).getInstitutionById(idInst);
				verifyNoMoreInteractions(autotransitionRepository);
			} catch (LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void save_autotran_null_autotranIsActive() {
			sce_autotran_null_autotranIsActive();
			try {
				long idInst = autotransition.getInstInstId().longValue();
				when(institutionService.getInstitutionById(idInst)).thenReturn(institutionOpt.get());
				assertThrows(LogicalException.class, 
						()-> when(autotransitionService.createAutotransition(autotransition)).thenReturn(autotransition));
				verify(institutionService).getInstitutionById(idInst);
				verifyNoMoreInteractions(autotransitionRepository);
			} catch (LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void save_autotran_noName() {
			sce_autotran_noName();
			try {
				long idInst = autotransition.getInstInstId().longValue();
				when(institutionService.getInstitutionById(idInst)).thenReturn(institutionOpt.get());
				assertThrows(LogicalException.class, 
						()-> when(autotransitionService.createAutotransition(autotransition)).thenReturn(autotransition));
				verify(institutionService).getInstitutionById(idInst);
				verifyNoMoreInteractions(autotransitionRepository);
			} catch (LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void save_autotran_null_name() {
			sce_autotran_null_name();
			try {
				
				long idInst = autotransition.getInstInstId().longValue();
				long  idAuto = autotransition.getAutotranId();
				when(institutionService.getInstitutionById(idInst)).thenReturn(institutionOpt.get());
				when(autotransitionRepository.findById(idAuto)).thenReturn(autotransitionOpt);
				assertThrows(LogicalException.class, 
						()-> when(autotransitionService.createAutotransition(autotransition)).thenReturn(autotransition));
				verify(institutionService).getInstitutionById(idInst);
				verifyNoMoreInteractions(autotransitionRepository);
				
			} catch (LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void save_autotran_invalid_autotranLogicaloperand() {
			sce_autotran_invalid_autotranLogicaloperand();
			try {
				long idInst = autotransition.getInstInstId().longValue();
				when(institutionService.getInstitutionById(idInst)).thenReturn(institutionOpt.get());
				assertThrows(LogicalException.class, 
						()-> when(autotransitionService.createAutotransition(autotransition)).thenReturn(autotransition));
				verify(institutionService).getInstitutionById(idInst);
				verifyNoMoreInteractions(autotransitionRepository);
			} catch (LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void save_autotran_null_autotranLogicaloperand() {
			sce_autotran_null_autotranLogicaloperand();
			try {
				long idInst = autotransition.getInstInstId().longValue();
				when(institutionService.getInstitutionById(idInst)).thenReturn(institutionOpt.get());
				assertThrows(LogicalException.class, 
						()-> when(autotransitionService.createAutotransition(autotransition)).thenReturn(autotransition));
				verify(institutionService).getInstitutionById(idInst);
				verifyNoMoreInteractions(autotransitionRepository);
			} catch (LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void save_autotran_null_autotran() {
			sce_autotran_null_autotran();
			assertThrows(LogicalException.class, 
					()-> when(autotransitionService.createAutotransition(autotransition)).thenReturn(autotransition));
			verifyNoMoreInteractions(institutionService);
			verifyNoMoreInteractions(autotransitionRepository);
		}
		
	}
	
	@Tag("Update")
	@Nested
	class UpdateTest{
		
		@Test
		public void edit_autotran_good1() {
			sce_autotran_allGood1();
			sce_autotran_allGood_for_edit();
			try {
				long idInst = autotransition.getInstInstId().longValue();
				long idAuto = autotransition.getAutotranId();
				when(institutionService.getInstitutionById(idInst)).thenReturn(institutionOpt.get());
				when(autotransitionRepository.findById(idAuto)).thenReturn(autotransitionOpt);
				when(autotransitionService.updateAutotransition(autotransition)).thenReturn(autotransition);
				assertTrue(true);
				verify(institutionService).getInstitutionById(idInst);
				verify(autotransitionRepository).findById(idAuto);
				verify(autotransitionRepository).save(autotransition);
				verifyNoMoreInteractions(autotransitionRepository);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void edit_autotran_good2() {
			sce_autotran_allGood2();
			sce_autotran_allGood_for_edit();
			try {
				long idInst = autotransition.getInstInstId().longValue();
				long idAuto = autotransition.getAutotranId();
				when(institutionService.getInstitutionById(idInst)).thenReturn(institutionOpt.get());
				when(autotransitionRepository.findById(idAuto)).thenReturn(autotransitionOpt);
				when(autotransitionService.updateAutotransition(autotransition)).thenReturn(autotransition);
				assertTrue(true);
				verify(institutionService).getInstitutionById(idInst);
				verify(autotransitionRepository).findById(idAuto);
				verify(autotransitionRepository).save(autotransition);
				verifyNoMoreInteractions(autotransitionRepository);
				verifyNoMoreInteractions(institutionService);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void edit_autotran_null_evenstatus1() {
			sce_autotran_null_eventstatus1();
			sce_autotran_allGood_for_edit();
			try {
				long idInst = autotransition.getInstInstId().longValue();
				long idAuto = autotransition.getAutotranId();
				when(institutionService.getInstitutionById(idInst)).thenReturn(institutionOpt.get());
				when(autotransitionRepository.findById(idAuto)).thenReturn(autotransitionOpt);
				assertThrows(LogicalException.class,
						()->when(autotransitionService.updateAutotransition(autotransition)).thenReturn(autotransition));
				verify(institutionService).getInstitutionById(idInst);
				verify(autotransitionRepository).findById(idAuto);
				verifyNoMoreInteractions(autotransitionRepository);
				verifyNoMoreInteractions(institutionService);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void edit_autotran_null_evenstatus2() {
			sce_autotran_null_eventstatus2();
			sce_autotran_allGood_for_edit();
			try {
				long idInst = autotransition.getInstInstId().longValue();
				long idAuto = autotransition.getAutotranId();
				when(institutionService.getInstitutionById(idInst)).thenReturn(institutionOpt.get());
				when(autotransitionRepository.findById(idAuto)).thenReturn(autotransitionOpt);
				assertThrows(LogicalException.class,
						()->when(autotransitionService.updateAutotransition(autotransition)).thenReturn(autotransition));
				verify(institutionService).getInstitutionById(idInst);
				verify(autotransitionRepository).findById(idAuto);
				verifyNoMoreInteractions(autotransitionRepository);
				verifyNoMoreInteractions(institutionService);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void edit_autotran_noFound_inst() {
			sce_autotran_notFound_inst();
			sce_autotran_allGood_for_edit();
			try {
				long idInst = autotransition.getInstInstId().longValue();
				long idAuto = autotransition.getAutotranId();
				when(institutionService.getInstitutionById(idInst)).thenThrow(LogicalException.class);
				when(autotransitionRepository.findById(idAuto)).thenReturn(autotransitionOpt);
				assertThrows(LogicalException.class,
						()->when(autotransitionService.updateAutotransition(autotransition)).thenReturn(autotransition));
				verify(institutionService).getInstitutionById(idInst);
				verify(autotransitionRepository).findById(idAuto);
				verifyNoMoreInteractions(autotransitionRepository);
				verifyNoMoreInteractions(institutionService);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void edit_autotran_invalid_autotranIsActive() {
			sce_autotran_invalid_autotranIsActive();
			sce_autotran_allGood_for_edit();
			try {
				long idInst = autotransition.getInstInstId().longValue();
				long idAuto = autotransition.getAutotranId();
				when(institutionService.getInstitutionById(idInst)).thenThrow(LogicalException.class);
				when(autotransitionRepository.findById(idAuto)).thenReturn(autotransitionOpt);
				assertThrows(LogicalException.class,
						()->when(autotransitionService.updateAutotransition(autotransition)).thenReturn(autotransition));
				verify(institutionService).getInstitutionById(idInst);
				verify(autotransitionRepository).findById(idAuto);
				verifyNoMoreInteractions(autotransitionRepository);
				verifyNoMoreInteractions(institutionService);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void edit_autotran_null_autotranIsActive() {
			sce_autotran_null_autotranIsActive();
			sce_autotran_allGood_for_edit();
			try {
				long idInst = autotransition.getInstInstId().longValue();
				long idAuto = autotransition.getAutotranId();
				when(institutionService.getInstitutionById(idInst)).thenThrow(LogicalException.class);
				when(autotransitionRepository.findById(idAuto)).thenReturn(autotransitionOpt);
				assertThrows(LogicalException.class,
						()->when(autotransitionService.updateAutotransition(autotransition)).thenReturn(autotransition));
				verify(institutionService).getInstitutionById(idInst);
				verify(autotransitionRepository).findById(idAuto);
				verifyNoMoreInteractions(autotransitionRepository);
				verifyNoMoreInteractions(institutionService);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void edit_autotran_noName() {
			sce_autotran_noName();
			sce_autotran_allGood_for_edit();
			try {
				long idInst = autotransition.getInstInstId().longValue();
				long idAuto = autotransition.getAutotranId();
				when(institutionService.getInstitutionById(idInst)).thenThrow(LogicalException.class);
				when(autotransitionRepository.findById(idAuto)).thenReturn(autotransitionOpt);
				assertThrows(LogicalException.class,
						()->when(autotransitionService.updateAutotransition(autotransition)).thenReturn(autotransition));
				verify(institutionService).getInstitutionById(idInst);
				verify(autotransitionRepository).findById(idAuto);
				verifyNoMoreInteractions(autotransitionRepository);
				verifyNoMoreInteractions(institutionService);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void edit_autotran_null_name() {
			sce_autotran_null_name();
			sce_autotran_allGood_for_edit();
			try {
				long idInst = autotransition.getInstInstId().longValue();
				long idAuto = autotransition.getAutotranId();
				when(institutionService.getInstitutionById(idInst)).thenThrow(LogicalException.class);
				when(autotransitionRepository.findById(idAuto)).thenReturn(autotransitionOpt);
				assertThrows(LogicalException.class,
						()->when(autotransitionService.updateAutotransition(autotransition)).thenReturn(autotransition));
				verify(institutionService).getInstitutionById(idInst);
				verify(autotransitionRepository).findById(idAuto);
				verifyNoMoreInteractions(autotransitionRepository);
				verifyNoMoreInteractions(institutionService);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void edit_autotran_invalid_autotranLogicaloperand() {
			sce_autotran_invalid_autotranLogicaloperand();
			sce_autotran_allGood_for_edit();
			try {
				long idInst = autotransition.getInstInstId().longValue();
				long idAuto = autotransition.getAutotranId();
				when(institutionService.getInstitutionById(idInst)).thenThrow(LogicalException.class);
				when(autotransitionRepository.findById(idAuto)).thenReturn(autotransitionOpt);
				assertThrows(LogicalException.class,
						()->when(autotransitionService.updateAutotransition(autotransition)).thenReturn(autotransition));
				verify(institutionService).getInstitutionById(idInst);
				verify(autotransitionRepository).findById(idAuto);
				verifyNoMoreInteractions(autotransitionRepository);
				verifyNoMoreInteractions(institutionService);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void edit_autotran_null_autotranLogicaloperand() {
			sce_autotran_null_autotranLogicaloperand();
			sce_autotran_allGood_for_edit();
			try {
				long idInst = autotransition.getInstInstId().longValue();
				long idAuto = autotransition.getAutotranId();
				when(institutionService.getInstitutionById(idInst)).thenThrow(LogicalException.class);
				when(autotransitionRepository.findById(idAuto)).thenReturn(autotransitionOpt);
				assertThrows(LogicalException.class,
						()->when(autotransitionService.updateAutotransition(autotransition)).thenReturn(autotransition));
				verify(institutionService).getInstitutionById(idInst);
				verify(autotransitionRepository).findById(idAuto);
				verifyNoMoreInteractions(autotransitionRepository);
				verifyNoMoreInteractions(institutionService);
			}catch(LogicalException e) {
				assertTrue(false);
			}
		}
		
		@Test
		public void edit_autotran_noFound_autotransiton() {
			sce_autotran_allGood_forNoFoundAutotran();
			long idAuto = autotransition.getAutotranId();
			when(autotransitionRepository.findById(idAuto)).thenThrow(NoSuchElementException.class);
			assertThrows(LogicalException.class,
					()->when(autotransitionService.updateAutotransition(autotransition)).thenReturn(autotransition));
			verify(autotransitionRepository).findById(idAuto);
			//verify(institutionSer)
			verifyNoMoreInteractions(autotransitionRepository);
			verifyNoMoreInteractions(institutionService);
		}
		
		@Test
		public void edit_autotran_null_autotran() {
			sce_autotran_null_autotran();
			sce_autotran_allGood_for_edit();
			assertThrows(LogicalException.class, 
					()-> when(autotransitionService.updateAutotransition(autotransition)).thenReturn(autotransition));
			verifyNoMoreInteractions(institutionService);
			verifyNoMoreInteractions(autotransitionRepository);
		}

	}

}
