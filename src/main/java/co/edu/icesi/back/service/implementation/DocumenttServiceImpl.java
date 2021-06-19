package co.edu.icesi.back.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.back.daos.interfaces.DocumenttDAO;
import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.back.model.Documentt;
import co.edu.icesi.back.service.interfaces.DocumenttService;
import co.edu.icesi.back.service.interfaces.DocumenttypeService;
import co.edu.icesi.back.service.interfaces.PersonService;


@Service
public class DocumenttServiceImpl implements DocumenttService{

	private DocumenttDAO documenttDAO;
	
	private DocumenttypeService documenttypeService;
	
	private PersonService personService;
	
	@Autowired
	public DocumenttServiceImpl(DocumenttDAO documenttDAO, DocumenttypeService documenttypeService, PersonService personService) {
		this.documenttDAO = documenttDAO;
		this.documenttypeService = documenttypeService;
		this.personService = personService;
	}
	
	@Override
	@Transactional
	public Documentt createDocumentt(Documentt documentt) {
		documentt.setDocumenttype(documenttypeService.getDocumenttypeById(documentt.getDocttypeId()));
		try {
			documentt.setPerson(personService.getPersonById(documentt.getPersonId()));
		} catch (LogicalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		documenttDAO.Save(documentt);
		return documentt;
	}

	@Override
	@Transactional
	public Documentt updateDocumentt(Documentt documentt) {
		documenttDAO.Save(documentt);
		return documentt;
	}

	@Override
	@Transactional
	public Documentt getDocumenttById(long id) {
		return documenttDAO.findById(id);
	}

	@Override
	@Transactional
	public Iterable<Documentt> findAll() {
		return documenttDAO.findAll();
	}

	@Override
	@Transactional
	public void delete(long id) {
		Documentt documentt = getDocumenttById(id);
		documenttDAO.Delete(documentt);
	}

}
