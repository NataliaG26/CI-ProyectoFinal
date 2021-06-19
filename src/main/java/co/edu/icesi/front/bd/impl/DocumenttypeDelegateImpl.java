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
		System.out.println("Delegate "+ documenttype.getInstInstId());
		return restTemplate.postForEntity(SERVER, documenttype, Documenttype.class).getBody();
	}

	@Override
	public void updateDocumenttype(Documenttype documenttype) {
		String s = SERVER;
		System.out.println(s);
		restTemplate.put(SERVER, documenttype, Documenttype.class);
	}

	@Override
	public Documenttype getDocumenttypeById(long id) {
		return restTemplate.getForObject(SERVER + id, Documenttype.class);
	}

	@Override
	public List<Documenttype> findAll() {
		Documenttype[] documenttypes = restTemplate.getForObject(SERVER, Documenttype[].class);
		List<Documenttype> at = Arrays.asList(documenttypes);
		if(at.size()==0) {
			return null;
		}
		return at;

	}

	@Override
	public void delete(long id) {
		restTemplate.delete(SERVER + id);
	}

}
