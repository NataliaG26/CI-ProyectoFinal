package co.edu.icesi.front.bd.interfaces;

import java.util.List;

import co.edu.icesi.front.model.classes.Documentt;

public interface DocumenttDelegate {
	
public Documentt createDocumentt(Documentt documentt);
	
	public void updateDocumentt(Documentt documentt);
	
	public Documentt getDocumenttById(long id);
	
	public List<Documentt> findAll();
	
	public void delete(long id);

}
