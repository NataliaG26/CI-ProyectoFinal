package co.edu.icesi.front.bd.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import co.edu.icesi.front.model.classes.Institution;
import co.edu.icesi.front.model.classes.Institutions;
import co.edu.icesi.front.bd.interfaces.InstitutionDelegate;

@Component
public class InstitutionDelegateImpl implements InstitutionDelegate{
	
	RestTemplate restTemplate;
	public static final String SERVER="http://localhost:8080/api-rest/institution/";
	
	public InstitutionDelegateImpl() {
		this.restTemplate = new RestTemplate();
	}
	
	public void setRestTemplate(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
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
		return restTemplate.getForObject(SERVER + id, Institution.class);
	}
	
	@Override
	public List<Institution> findAll() {
		Institution[] institutions = restTemplate.getForObject(SERVER, Institution[].class);
		List<Institution> list = Arrays.asList(institutions);
		return list;
	}

	@Override
	public void delete(long id) {
		System.out.println("Delegado 1 ");
		restTemplate.delete(SERVER + id);
		System.out.println("Delegado");
	}
}
