package co.edu.icesi.nigm.service.implementation;

import org.springframework.stereotype.Service;

import co.edu.icesi.nigm.service.interfaces.EpidemstatuscolorService;
import co.edu.icesi.nigm.model.Epidemstatuscolor;
import co.edu.icesi.nigm.repository.EpidemstatuscolorRepository;


@Service
public class EpidemstatuscolorServiceImpl implements EpidemstatuscolorService{
	
	private EpidemstatuscolorRepository epidemstatuscolorRepository; 
	
	public EpidemstatuscolorServiceImpl(EpidemstatuscolorRepository epidemstatuscolorRepository) {
		this.epidemstatuscolorRepository = epidemstatuscolorRepository;
	}

	@Override
	public Epidemstatuscolor createEpidemstatuscolor(Epidemstatuscolor epidemstatuscolor) {
		epidemstatuscolorRepository.save(epidemstatuscolor);
		return epidemstatuscolor;
	}

	@Override
	public Iterable<Epidemstatuscolor> findAll() {
		return epidemstatuscolorRepository.findAll();
	}

	@Override
	public Epidemstatuscolor updateEpidemstatuscolor(Epidemstatuscolor epidemstatuscolor) {
		epidemstatuscolorRepository.save(epidemstatuscolor);
		return epidemstatuscolor;
	}

	@Override
	public Epidemstatuscolor getEpidemstatuscolorById(Long id) {
		return epidemstatuscolorRepository.findById(id).get();
	}

	@Override
	public void delete(Epidemstatuscolor epidemstatuscolor) {
		epidemstatuscolorRepository.delete(epidemstatuscolor);
		
	}
}
