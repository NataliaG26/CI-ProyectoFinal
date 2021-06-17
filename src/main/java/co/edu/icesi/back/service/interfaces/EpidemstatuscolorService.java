package co.edu.icesi.back.service.interfaces;

import co.edu.icesi.back.model.Epidemstatuscolor;

public interface EpidemstatuscolorService {
	
	public Epidemstatuscolor createEpidemstatuscolor(Epidemstatuscolor epidemstatuscolor);
	
	public Iterable<Epidemstatuscolor> findAll();
	
	public Epidemstatuscolor updateEpidemstatuscolor(Epidemstatuscolor epidemstatuscolor);
	
	public Epidemstatuscolor getEpidemstatuscolorById(Long id);
	
	public void delete(Epidemstatuscolor epidemstatuscolor);
	
}
