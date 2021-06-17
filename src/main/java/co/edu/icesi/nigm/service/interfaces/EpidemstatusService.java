package co.edu.icesi.nigm.service.interfaces;

import co.edu.icesi.nigm.model.Epidemstatus;

public interface EpidemstatusService {
	
	public Epidemstatus createEpidemstatus(Epidemstatus epidemstatus);
	
	public Iterable<Epidemstatus> findAll();
	
	public Epidemstatus updateEpidemstatus(Epidemstatus epidemstatus);
	
	public Epidemstatus getEpidemstatusById(Long id);
	
	public void delete(Epidemstatus epidemstatus);
}
