package co.edu.icesi.nigm.service.interfaces;

import co.edu.icesi.nigm.exception.LogicalException;
import co.edu.icesi.nigm.model.Personautotran;


public interface PersonautotranService {
	
	public Personautotran createPersonautotran(Personautotran personautotran) throws LogicalException;
	
	public Personautotran updatePersonautotran(Personautotran personautotran) throws LogicalException;
	
	public Personautotran getPersonautotranById(long id) throws LogicalException;

	public Iterable<Personautotran> findAll();
	
	public void delete(Personautotran personautotran);
}
