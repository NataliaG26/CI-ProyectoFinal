package co.edu.icesi.front.bd.interfaces;

import java.util.List;

import co.edu.icesi.front.model.classes.Documenttype;

public interface DocumenttypeDelegate {
	
	public Documenttype createDocumenttype(Documenttype documenttype);
	
	public void updateDocumenttype(Documenttype documenttype);
	
	public Documenttype getDocumenttypeById(long id);
	
	public List<Documenttype> findAll();
	
	public void delete(long id);
}
