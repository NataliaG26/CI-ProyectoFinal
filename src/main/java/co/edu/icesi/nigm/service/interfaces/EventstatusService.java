package co.edu.icesi.nigm.service.interfaces;

import co.edu.icesi.nigm.model.Eventstatus;

public interface EventstatusService {
	
	public Eventstatus createEventstatus(Eventstatus eventstatus);
	
	public Iterable<Eventstatus> findAll();
	
	public Eventstatus updateEventstatus(Eventstatus eventstatus);
	
	public Eventstatus getEventstatusById(Long id);
	
	public void delete(Eventstatus eventstatus);

}
