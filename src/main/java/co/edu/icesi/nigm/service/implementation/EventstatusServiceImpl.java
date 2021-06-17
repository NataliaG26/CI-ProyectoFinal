package co.edu.icesi.nigm.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.icesi.nigm.model.Eventstatus;
import co.edu.icesi.nigm.repository.EventstatusRepository;
import co.edu.icesi.nigm.service.interfaces.EventstatusService;

@Service
public class EventstatusServiceImpl implements EventstatusService{
	
	private EventstatusRepository eventstatusRepository;
	
	@Autowired
	public EventstatusServiceImpl(EventstatusRepository eventstatusRepository) {
		this.eventstatusRepository = eventstatusRepository;
	}
	
	@Override
	public Eventstatus createEventstatus(Eventstatus eventstatus) {
		eventstatusRepository.save(eventstatus);
		return eventstatus;
	}
	

	@Override
	public Iterable<Eventstatus> findAll() {
		return eventstatusRepository.findAll();
	}

	@Override
	public Eventstatus updateEventstatus(Eventstatus eventstatus) {
		eventstatusRepository.save(eventstatus);
		return eventstatus;
	}

	@Override
	public Eventstatus getEventstatusById(Long id) {
		return eventstatusRepository.findById(id).get();
	}

	@Override
	public void delete(Eventstatus eventstatus) {
		eventstatusRepository.delete(eventstatus);
		
	}

}
