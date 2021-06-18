package co.edu.icesi.back.service.implementation;

import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import co.edu.icesi.back.daos.interfaces.AutotransitionDAO;
import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.back.model.Autotransition;
import co.edu.icesi.back.repository.AutotransitionRepository;
import co.edu.icesi.back.service.interfaces.AutotransitionService;
import co.edu.icesi.back.service.interfaces.InstitutionService;

@Service
public class AutotransitionServiceImpl implements AutotransitionService{
	
	private AutotransitionRepository autotransitionRepository;
	
	private InstitutionService institutionService;
	private AutotransitionDAO autotransitionDAO;
	
	@Autowired
	public AutotransitionServiceImpl(AutotransitionRepository autotransitionRepository, InstitutionService institutionService,
			AutotransitionDAO autotransitionDAO) {
		this.autotransitionRepository = autotransitionRepository;
		this.institutionService = institutionService;
		this.autotransitionDAO = autotransitionDAO;
	}
	
	@Override
	@Transactional
	public Autotransition createAutotransition(Autotransition autotransition) throws LogicalException {
		
		if(autotransition == null) {
			throw new LogicalException("La autotransición a ingresar no puede ser null");
		}
		
		institutionService.getInstitutionById(autotransition.getInstInstId().longValue());
		
		if(autotransition.getEventstatus1() == null || autotransition.getEventstatus2() == null) {
			throw new LogicalException("El estado epidemiológico no puede ser null");
		}
		else if(autotransition.getAutotranIsactive() == null) {
			throw new LogicalException("El activo de la Autotransición no puede ser null");
		}
		else if(!autotransition.getAutotranIsactive().equals("Y") && !autotransition.getAutotranIsactive().equals("N")) {
			throw new LogicalException("El activo de la Autotransición debe ser 'Y' o 'N'");
		}
		else if(autotransition.getAutotranLogicaloperand() == null) {
			throw new LogicalException("El operador lógico de la autotransición no puede ser null");
		}
		else if(!autotransition.getAutotranLogicaloperand().equals("OR") && !autotransition.getAutotranLogicaloperand().equals("AND")) {
			throw new LogicalException("El operador lógico de la Autotransición solo puede ser 'OR' o 'AND'");
		}
		else if(autotransition.getAutotranName() == null) {
			throw new LogicalException("El nombre de la Autotrancisión no puede ser null");
		}
		else if(autotransition.getAutotranName().equals("")) {
			throw new LogicalException("La Autotransición debe tener un nombre diferente de vacío");
		}
		else {
			//autotransitionRepository.save(autotransition);
			autotransitionDAO.Save(autotransition);
			return autotransition;
		}
		
	}

	@Override
	@Transactional
	public Autotransition updateAutotransition(Autotransition autotransition) throws LogicalException {
		
		if(autotransition == null) {
			throw new LogicalException("La autotransición a ingresar no puede ser null");
		}
		
		Autotransition existingAutotransition = getAutotransitionById(autotransition.getAutotranId());
		
		institutionService.getInstitutionById(autotransition.getAutotranId());
		
		if(autotransition.getEventstatus1() == null || autotransition.getEventstatus2() == null) {
			throw new LogicalException("El estado epidemiológico no puede ser null");
		}
		else if(autotransition.getAutotranIsactive() == null) {
			throw new LogicalException("El activo de la Autotransición no puede ser null");
		}
		else if(!autotransition.getAutotranIsactive().equals("Y") && !autotransition.getAutotranIsactive().equals("N")) {
			throw new LogicalException("El activo de la Autotransición debe ser 'Y' o 'N'");
		}
		else if(autotransition.getAutotranLogicaloperand() == null) {
			throw new LogicalException("El operador lógico de la autotransición no puede ser null");
		}
		else if(!autotransition.getAutotranLogicaloperand().equals("OR") || autotransition.getAutotranLogicaloperand().equals("AND")) {
			throw new LogicalException("El operador lógico de la Autotransición solo puede ser 'OR' o 'AND'");
		}
		else if(autotransition.getAutotranName() == null) {
			throw new LogicalException("El nombre de la Autotrancisión no puede ser null");
		}
		else if(autotransition.getAutotranName().equals("")) {
			throw new LogicalException("La Autotransición debe tener un nombre diferente de vacío");
		}
		else {
			existingAutotransition.setAutotranIsactive(autotransition.getAutotranIsactive());
			existingAutotransition.setAutotranLogicaloperand(autotransition.getAutotranLogicaloperand());
			existingAutotransition.setAutotranName(autotransition.getAutotranName());
			existingAutotransition.setInstInstId(autotransition.getInstInstId());
			existingAutotransition.setEventstatus1(autotransition.getEventstatus1());
			existingAutotransition.setEventstatus2(autotransition.getEventstatus2());
			
			//autotransitionRepository.save(existingAutotransition);
			autotransitionDAO.Edit(existingAutotransition);
			return autotransition;
		}
	}
	
	@Override
	public Autotransition getAutotransitionById(long id) throws LogicalException {
		try {
			//Autotransition autotransition = autotransitionRepository.findById(id).get();
			Autotransition autotransition = autotransitionDAO.findById(id);
			return autotransition;
		}catch(NoSuchElementException e) {
			throw new LogicalException("No se encontró la Autotransición");
		}
		
	}
	
	@Override
	public Iterable<Autotransition> findAll(){
		//return autotransitionRepository.findAll();
		return autotransitionDAO.findAll();
	}
	
	@Override
	@Transactional
	public void delete(long id) throws LogicalException {
		//autotransitionRepository.delete(autotransition);
		Autotransition autotransition = getAutotransitionById(id);
		autotransitionDAO.Delete(autotransition);
	}
	
}
