package co.edu.icesi.back.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.edu.icesi.back.daos.interfaces.DocumenttDAO;
import co.edu.icesi.back.model.Documentt;
import co.edu.icesi.back.service.interfaces.DocumenttService;

@Service
public class DocumenttServiceImpl implements DocumenttService{

	private DocumenttDAO documenttDAO;
	
	@Autowired
	public DocumenttServiceImpl(DocumenttDAO documenttDAO) {
		this.documenttDAO = documenttDAO;
	}
	
	@Override
	@Transactional
	public Documentt createDocumentt(Documentt documentt) {
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
