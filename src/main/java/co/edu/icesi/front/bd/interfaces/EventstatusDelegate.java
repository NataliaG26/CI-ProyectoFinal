package co.edu.icesi.front.bd.interfaces;

import co.edu.icesi.front.model.classes.Eventstatus;

public interface EventstatusDelegate {
	
public Eventstatus createEventstatus(Eventstatus eventstatus);
	
	public Iterable<Eventstatus> findAll();
	
	public Eventstatus updateEventstatus(Eventstatus eventstatus);
	
	public Eventstatus getEventstatusById(Long id);
	
	public void delete(Eventstatus eventstatus);

}
