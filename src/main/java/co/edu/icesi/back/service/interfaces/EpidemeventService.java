package co.edu.icesi.back.service.interfaces;

import co.edu.icesi.back.model.Epidemevent;

public interface EpidemeventService {
	
	public Epidemevent createEpidemevent(Epidemevent epidemevent);
	
	public Iterable<Epidemevent> findAll();
	
	public Epidemevent updateEpidemevent(Epidemevent epidemevent);
	
	public Epidemevent getEpidemeventById(Long id);
	
	public void delete(Epidemevent epidemevent);
}
