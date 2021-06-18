package co.edu.icesi.back.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Documenttype createDocumenttype(Documenttype documenttype) {
		documenttypeDAO.Save(documenttype);
		return documenttype;
	}

	@Override
	public Documenttype updateDocumenttype(Documenttype documenttype) {
		documenttypeDAO.Save(documenttype);
		return documenttype;
	}

	@Override
	public Documenttype getDocumenttypeById(long id) {
		return documenttypeDAO.findById(id);
	}

	@Override
	public Iterable<Documenttype> findAll() {
		return documenttypeDAO.findAll();
	}

	@Override
	public void delete(long id) {
		Documenttype documenttype = getDocumenttypeById(id);
		documenttypeDAO.Delete(documenttype);
	}

}
