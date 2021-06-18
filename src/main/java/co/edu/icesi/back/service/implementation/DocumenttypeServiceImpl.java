package co.edu.icesi.back.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.back.daos.interfaces.DocumenttypeDAO;
import co.edu.icesi.back.model.Documenttype;
import co.edu.icesi.back.service.interfaces.DocumenttypeService;

@Service
public class DocumenttypeServiceImpl implements DocumenttypeService{

	private DocumenttypeDAO documenttypeDAO;
	
	@Autowired
	public DocumenttypeServiceImpl(DocumenttypeDAO documenttypeDAO) {
		this.documenttypeDAO = documenttypeDAO;
	}
	
	@Override
	@Transactional
	public Documenttype createDocumenttype(Documenttype documenttype) {
		documenttypeDAO.Save(documenttype);
		return documenttype;
	}

	@Override
	@Transactional
	public Documenttype updateDocumenttype(Documenttype documenttype) {
		documenttypeDAO.Save(documenttype);
		return documenttype;
	}

	@Override
	@Transactional
	public Documenttype getDocumenttypeById(long id) {
		return documenttypeDAO.findById(id);
	}

	@Override
	@Transactional
	public Iterable<Documenttype> findAll() {
		return documenttypeDAO.findAll();
	}

	@Override
	@Transactional
	public void delete(long id) {
		Documenttype documenttype = getDocumenttypeById(id);
		documenttypeDAO.Delete(documenttype);
	}

}
