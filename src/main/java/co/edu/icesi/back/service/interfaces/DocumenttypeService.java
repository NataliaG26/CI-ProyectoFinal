package co.edu.icesi.back.service.interfaces;

import co.edu.icesi.back.model.Documenttype;

public interface DocumenttypeService {
	
	public Documenttype createDocumenttype (Documenttype documentt);
	
	public Documenttype updateDocumenttype (Documenttype documentt);
	
	public Documenttype getDocumenttypeById(long id);
	
	public Iterable<Documenttype> findAll();
	
	public void delete(long id);

}
