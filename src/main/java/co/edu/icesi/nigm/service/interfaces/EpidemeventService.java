package co.edu.icesi.nigm.service.interfaces;

import co.edu.icesi.nigm.model.Epidemevent;

public interface EpidemeventService {
	
	public Epidemevent createEpidemevent(Epidemevent epidemevent);
	
	public Iterable<Epidemevent> findAll();
	
	public Epidemevent updateEpidemevent(Epidemevent epidemevent);
	
	public Epidemevent getEpidemeventById(Long id);
	
	public void delete(Epidemevent epidemevent);
}
