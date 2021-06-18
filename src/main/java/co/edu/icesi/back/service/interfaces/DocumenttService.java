package co.edu.icesi.back.service.interfaces;

import co.edu.icesi.back.model.Documentt;

public interface DocumenttService {
	
	public Documentt createDocumentt (Documentt documentt);
	
	public Documentt updateDocumentt (Documentt documentt);
	
	public Documentt getDocumenttById(long id);
	
	public Iterable<Documentt> findAll();
	
	public void delete(long id);

}
