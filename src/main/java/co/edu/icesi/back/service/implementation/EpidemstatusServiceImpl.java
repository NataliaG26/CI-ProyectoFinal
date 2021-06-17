package co.edu.icesi.back.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.back.model.Epidemstatus;
import co.edu.icesi.back.repository.EpidemstatusRepository;
import co.edu.icesi.back.service.interfaces.EpidemstatusService;

@Service
public class EpidemstatusServiceImpl implements EpidemstatusService{
	
	private EpidemstatusRepository epidemstatusRepository;
	
	@Autowired
	public EpidemstatusServiceImpl(EpidemstatusRepository epidemstatusRepository) {
		this.epidemstatusRepository = epidemstatusRepository;
	}
	
	@Override
	public Epidemstatus createEpidemstatus(Epidemstatus epidemstatus) {
		epidemstatusRepository.save(epidemstatus);
		return epidemstatus;
	}

	@Override
	public Iterable<Epidemstatus> findAll() {
		return epidemstatusRepository.findAll();
	}

	@Override
	public Epidemstatus updateEpidemstatus(Epidemstatus epidemstatus) {
		epidemstatusRepository.save(epidemstatus);
		return epidemstatus;
	}

	@Override
	public Epidemstatus getEpidemstatusById(Long id) {
		return epidemstatusRepository.findById(id).get();
	}

	@Override
	public void delete(Epidemstatus epidemstatus) {
		epidemstatusRepository.delete(epidemstatus);
		
	}
	
	

}
