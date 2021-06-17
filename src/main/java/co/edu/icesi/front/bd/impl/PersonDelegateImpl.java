package co.edu.icesi.front.bd.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.edu.icesi.front.bd.interfaces.PersonDelegate;

@Component
public class PersonDelegateImpl implements PersonDelegate{
	
	RestTemplate restTemplate;
	final String SERVER="http://localhost:8080/api-rest/";
	
	public PersonDelegateImpl() {
		
	}
}
