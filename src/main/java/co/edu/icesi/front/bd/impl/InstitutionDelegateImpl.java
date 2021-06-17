package co.edu.icesi.front.bd.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.edu.icesi.front.model.classes.Institution;
import co.edu.icesi.front.bd.interfaces.InstitutionDelegate;

@Component
public class InstitutionDelegateImpl implements InstitutionDelegate{
	
	RestTemplate restTemplate;
	final String SERVER="http://localhost:8080/api-rest/institution/";
	
	public InstitutionDelegateImpl() {
		this.restTemplate = new RestTemplate();
	}
	

	@Override
	public Institution createInstitution(Institution institution){
		return restTemplate.postForEntity(SERVER +"add", institution, Institution.class).getBody();
	}

	@Override
	public void updateInstitution(Institution institution){
		restTemplate.put(SERVER + "update/", institution, Institution.class);
	}

	@Override
	public Institution getInstitutionById(long id){
		return restTemplate.getForObject(SERVER + "show/"+id, Institution.class);
	}

	@Override
	public Iterable<Institution> findAll() {
		Institution[] institutions = restTemplate.getForObject(SERVER, Institution[].class);
		List<Institution> list;
		try {
			list = Arrays.asList(institutions);
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void delete(long id) {
		restTemplate.delete(SERVER + "del/"+ id);
		
	}
}
