package co.edu.icesi.front.bd.interfaces;

import co.edu.icesi.front.model.classes.Autotransition;

public interface AutotransitionDelegate {
	
	public Autotransition createAutotransition (Autotransition autotransition);
	
	public void updateAutotransition (Autotransition autotransition);
	
	public Autotransition getAutotransitionById(long id);
	
	public Iterable<Autotransition> findAll();
	
	public void delete(long id);

}
