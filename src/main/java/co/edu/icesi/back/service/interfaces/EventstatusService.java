package co.edu.icesi.back.service.interfaces;

import co.edu.icesi.back.model.Eventstatus;

public interface EventstatusService {
	
	public Eventstatus createEventstatus(Eventstatus eventstatus);
	
	public Iterable<Eventstatus> findAll();
	
	public Eventstatus updateEventstatus(Eventstatus eventstatus);
	
	public Eventstatus getEventstatusById(Long id);
	
	public void delete(Eventstatus eventstatus);

}
