package co.edu.icesi.front.bd.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import co.edu.icesi.front.bd.interfaces.DocumenttypeDelegate;
import co.edu.icesi.front.model.classes.Documenttype;

@Component
public class DocumenttypeDelegateImpl implements DocumenttypeDelegate{
	
	RestTemplate restTemplate;
	public static final String SERVER="http://localhost:8080/api-rest/documenttype/";
	
	public DocumenttypeDelegateImpl() {
		this.restTemplate = new RestTemplate();
	}
	
	@Override
	public Documenttype createDocumenttype(Documenttype documenttype) {
		return restTemplate.postForEntity(SERVER +"add", documenttype, Documenttype.class).getBody();
	}

	@Override
	public void updateDocumenttype(Documenttype documenttype) {
		String s = SERVER + "update";
		System.out.println(s);
		restTemplate.put(s, documenttype, Documenttype.class);
	}

	@Override
	public Documenttype getDocumenttypeById(long id) {
		return restTemplate.getForObject(SERVER + id, Documenttype.class);
	}

	@Override
	public List<Documenttype> findAll() {
		List<Documenttype> documenttypelist = new ArrayList<Documenttype>();
		try {
			Documenttype[] documenttypes = restTemplate.getForObject(SERVER, Documenttype[].class);
			documenttypelist = Arrays.asList(documenttypes);
		}catch(Exception e) {
			return documenttypelist;
		}
		return documenttypelist;
	}

	@Override
	public void delete(long id) {
		restTemplate.delete(SERVER + id);
	}

}
