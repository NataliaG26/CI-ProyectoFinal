package co.edu.icesi.back.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.back.model.Epidemevent;
import co.edu.icesi.back.repository.EpidemeventRepository;
import co.edu.icesi.back.service.interfaces.EpidemeventService;

@Service
public class EpidemeventServiceImpl implements EpidemeventService {

	private EpidemeventRepository epidemeventRepository;
	
	@Autowired
	public EpidemeventServiceImpl(EpidemeventRepository epidemeventRepository) {
		this.epidemeventRepository = epidemeventRepository;
	}
	
	@Override
	public Epidemevent createEpidemevent(Epidemevent epidemevent) {
		epidemeventRepository.save(epidemevent);
		return epidemevent;
	}

	@Override
	public Iterable<Epidemevent> findAll() {
		return epidemeventRepository.findAll();
	}
	
	@Override
	public Epidemevent updateEpidemevent(Epidemevent epidemevent) {
		epidemeventRepository.save(epidemevent);
		return epidemevent;
	}

	@Override
	public Epidemevent getEpidemeventById(Long id) {
		return epidemeventRepository.findById(id).get();
	}

	@Override
	public void delete(Epidemevent epidemevent) {
		epidemeventRepository.delete(epidemevent);
		
	}

}
