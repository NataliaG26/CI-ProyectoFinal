package co.edu.icesi.front.bd.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.edu.icesi.front.bd.interfaces.EventstatusDelegate;
import co.edu.icesi.front.model.classes.Eventstatus;

@Component
public class EventstatusDelegateImpl implements EventstatusDelegate{
	
	RestTemplate restTemplate;
	final String SERVER="http://localhost:8080/api-rest/eventstatus/";
	
	public EventstatusDelegateImpl() {
		this.restTemplate = new RestTemplate();
	}

	@Override
	public Eventstatus createEventstatus(Eventstatus eventstatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Eventstatus> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Eventstatus updateEventstatus(Eventstatus eventstatus) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Eventstatus getEventstatusById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Eventstatus eventstatus) {
		// TODO Auto-generated method stub
		
	}

}
