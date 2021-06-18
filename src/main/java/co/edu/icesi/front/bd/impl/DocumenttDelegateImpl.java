package co.edu.icesi.front.bd.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.edu.icesi.front.bd.interfaces.DocumenttDelegate;
import co.edu.icesi.front.model.classes.Documentt;
import co.edu.icesi.front.model.classes.Documenttype;

@Component
public class DocumenttDelegateImpl implements DocumenttDelegate{
	
	RestTemplate restTemplate;
	public static final String SERVER="http://localhost:8080/api-rest/documentt/";
	
	public DocumenttDelegateImpl() {
		this.restTemplate = new RestTemplate();
	}
	
	@Override
	public Documentt createDocumentt(Documentt documentt) {
		return restTemplate.postForEntity(SERVER +"add", documentt, Documentt.class).getBody();
	}

	@Override
	public void updateDocumentt(Documentt documentt) {
		restTemplate.put(SERVER + "update/", documentt, Documentt.class);
	}

	@Override
	public Documentt getDocumenttById(long id) {
		return restTemplate.getForObject(SERVER + id, Documentt.class);
	}

	@Override
	public List<Documentt> findAll() {
		List<Documentt> documenttlist = new ArrayList<Documentt>();
		try {
			Documentt[] documentts = restTemplate.getForObject(SERVER, Documentt[].class);
			documenttlist = Arrays.asList(documentts);
		}catch(Exception e) {
			return documenttlist;
		}
		return documenttlist;
	}

	@Override
	public void delete(long id) {
		restTemplate.delete(SERVER + id);
	}
	

}
