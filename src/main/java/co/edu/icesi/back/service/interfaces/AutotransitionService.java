package co.edu.icesi.back.service.interfaces;

import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.back.model.Autotransition;

public interface AutotransitionService {
	
	public Autotransition createAutotransition (Autotransition autotransition) throws LogicalException;
	
	public Autotransition updateAutotransition (Autotransition autotransition) throws LogicalException;
	
	public Autotransition getAutotransitionById(long id) throws LogicalException;
	
	public Iterable<Autotransition> findAll();
	
	public void delete(long id) throws LogicalException;
	
	public Iterable<Autotransition> findByName(String name);
	
	public Iterable<Autotransition> findByIsActive(String isactive);
	
	public Iterable<Autotransition> findByLogicOp(String logicOp);
	
}
