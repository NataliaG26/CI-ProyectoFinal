package co.edu.icesi.back.service.interfaces;

import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.back.model.Personautotran;


public interface PersonautotranService {
	
	public Personautotran createPersonautotran(Personautotran personautotran, long personId, long autotranId) throws LogicalException;
	
	public Personautotran updatePersonautotran(Personautotran personautotran) throws LogicalException;
	
	public Personautotran getPersonautotranById(long id) throws LogicalException;

	public Iterable<Personautotran> findAll();
	
	public void delete(long id) throws LogicalException;
}
