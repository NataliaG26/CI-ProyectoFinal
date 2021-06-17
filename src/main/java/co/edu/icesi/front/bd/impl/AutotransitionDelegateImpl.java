package co.edu.icesi.front.bd.impl;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.edu.icesi.front.bd.interfaces.AutotransitionDelegate;

@Component
public class AutotransitionDelegateImpl  implements AutotransitionDelegate{
	
	RestTemplate restTemplate;
	final String SERVER="http://localhost:8080/api-rest/";
	
	public AutotransitionDelegateImpl() {
		
	}
}
