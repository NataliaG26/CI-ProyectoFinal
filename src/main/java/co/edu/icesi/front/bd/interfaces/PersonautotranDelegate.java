package co.edu.icesi.front.bd.interfaces;

import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.front.model.classes.Personautotran;

public interface PersonautotranDelegate {
	
	public Personautotran createPersonautotran(Personautotran personautotran) throws LogicalException;
	
	public void updatePersonautotran(Personautotran personautotran) throws LogicalException;
	
	public Personautotran getPersonautotranById(long id) throws LogicalException;

	public Iterable<Personautotran> findAll();
	
	public void delete(long id);

}
