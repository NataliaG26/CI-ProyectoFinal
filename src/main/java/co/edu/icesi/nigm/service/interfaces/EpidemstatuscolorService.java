package co.edu.icesi.nigm.service.interfaces;

import co.edu.icesi.nigm.model.Epidemstatuscolor;

public interface EpidemstatuscolorService {
	
	public Epidemstatuscolor createEpidemstatuscolor(Epidemstatuscolor epidemstatuscolor);
	
	public Iterable<Epidemstatuscolor> findAll();
	
	public Epidemstatuscolor updateEpidemstatuscolor(Epidemstatuscolor epidemstatuscolor);
	
	public Epidemstatuscolor getEpidemstatuscolorById(Long id);
	
	public void delete(Epidemstatuscolor epidemstatuscolor);
	
}
