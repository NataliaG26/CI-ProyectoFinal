package co.edu.icesi.nigm.service.interfaces;

import co.edu.icesi.nigm.exception.LogicalException;
import co.edu.icesi.nigm.model.Autotransition;

public interface AutotransitionService {
	
	public Autotransition createAutotransition (Autotransition autotransition) throws LogicalException;
	
	public Autotransition updateAutotransition (Autotransition autotransition) throws LogicalException;
	
	public Autotransition getAutotransitionById(long id) throws LogicalException;
	
	public Iterable<Autotransition> findAll();
	
	public void delete(Autotransition autotransition);
}
