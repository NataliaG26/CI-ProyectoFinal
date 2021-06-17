package co.edu.icesi.back.service.interfaces;

import co.edu.icesi.back.model.Epidemstatus;

public interface EpidemstatusService {
	
	public Epidemstatus createEpidemstatus(Epidemstatus epidemstatus);
	
	public Iterable<Epidemstatus> findAll();
	
	public Epidemstatus updateEpidemstatus(Epidemstatus epidemstatus);
	
	public Epidemstatus getEpidemstatusById(Long id);
	
	public void delete(Epidemstatus epidemstatus);
}
