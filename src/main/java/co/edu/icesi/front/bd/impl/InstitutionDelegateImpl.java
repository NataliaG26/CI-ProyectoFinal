package co.edu.icesi.front.bd.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.edu.icesi.front.bd.interfaces.InstitutionDelegate;

@Component
public class InstitutionDelegateImpl implements InstitutionDelegate{
	
	RestTemplate restTemplate;
	final String SERVER="http://localhost:8080/api-rest/";
	
	public InstitutionDelegateImpl() {
		
	}
}
