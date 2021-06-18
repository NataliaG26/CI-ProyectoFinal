package co.edu.icesi.back.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import co.edu.icesi.back.daos.interfaces.PersonautotranDAO;
import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.back.model.Autotransition;
import co.edu.icesi.back.model.Person;
import co.edu.icesi.back.model.Personautotran;
import co.edu.icesi.back.repository.PersonautotranRepository;
import co.edu.icesi.back.service.interfaces.AutotransitionService;
import co.edu.icesi.back.service.interfaces.PersonService;
import co.edu.icesi.back.service.interfaces.PersonautotranService;

@Service
public class PersonautotranServiceImpl implements PersonautotranService{
	
	private PersonautotranRepository personautotranRepository;
	
	private PersonService personService;
	
	private AutotransitionService autotransitionService;
	
	private PersonautotranDAO personautotranDAO;
	
	@Autowired
	public PersonautotranServiceImpl(PersonautotranRepository personautotranRepository, PersonService personservice,
			AutotransitionService autotransitionService, PersonautotranDAO personautotranDAO){
		this.personautotranRepository = personautotranRepository;
		this.personService = personservice;
		this.autotransitionService = autotransitionService;
		this.personautotranDAO = personautotranDAO;
	}

	@Override
	@Transactional
	public Personautotran createPersonautotran(Personautotran personautotran, long personId, long autotranId) throws LogicalException {
		if(personautotran == null) {
			throw new LogicalException("La autotrancición de la persona no puede ser null");
		}
//		else if(personautotran.getPerson()== null) {
//			throw new LogicalException("La persona no puede ser null");
//		}
		Person person = personService.getPersonById(personId);
		
//		if(personautotran.getAutotransition() == null) {
//			throw new LogicalException("La autotransición no puede ser null");
//		}
		Autotransition autotran = autotransitionService.getAutotransitionById(autotranId);
		
//		if(personautotran.getPerautDate()==null) {
//			throw new LogicalException("La fecha no puede ser null");
//		}
		personautotran.setPerson(person);
		personautotran.setAutotransition(autotran);
		//personautotranRepository.save(personautotran);
		personautotranDAO.Save(personautotran);
		return personautotran;
	}

	@Override
	@Transactional
	public Personautotran updatePersonautotran(Personautotran personautotran) throws LogicalException {
		if(personautotran == null) {
			throw new LogicalException("La autotrancición de la persona no puede ser null");
		}
		else if(personautotran.getPerson()== null) {
			throw new LogicalException("La persona no puede ser null");
		}
		personService.getPersonById(personautotran.getPerson().getPersId());
		
		if(personautotran.getAutotransition() == null) {
			throw new LogicalException("La autotransición no puede ser null");
		}
		autotransitionService.getAutotransitionById(personautotran.getAutotransition().getAutotranId());
		
		if(personautotran.getPerautDate()==null) {
			throw new LogicalException("La fecha no puede ser null");
		}
		
		//personautotranRepository.save(personautotran);
		personautotranDAO.Edit(personautotran);
		
		return personautotran;
	}

	@Override
	public Personautotran getPersonautotranById(long id) throws LogicalException {
		//return personautotranRepository.findById(id),get();
		return personautotranDAO.findById(id);
	}
	
	@Override
	public Iterable<Personautotran> findAll(){
		//return personautotranRepository.findAll();
		return personautotranDAO.findAll();
	}
	
	@Override
	@Transactional
	public void delete(long id) throws LogicalException {
		//personautotranRepository.delete(personautotran);
		Personautotran personAutotran = getPersonautotranById(id);
		personautotranDAO.Delete(personAutotran);
	}

}
