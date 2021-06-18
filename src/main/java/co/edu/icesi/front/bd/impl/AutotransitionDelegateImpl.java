package co.edu.icesi.front.bd.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.edu.icesi.front.bd.interfaces.AutotransitionDelegate;
import co.edu.icesi.front.model.classes.Autotransition;

@Component
public class AutotransitionDelegateImpl  implements AutotransitionDelegate{
	
	RestTemplate restTemplate;
	final String SERVER="http://localhost:8080/api-rest/autotransition/";
	
	public AutotransitionDelegateImpl() {
		this.restTemplate = new RestTemplate();
	}

	@Override
	public Autotransition createAutotransition(Autotransition autotransition) {
		return restTemplate.postForEntity(SERVER +"add", autotransition, Autotransition.class).getBody();
	}

	@Override
	public void updateAutotransition(Autotransition autotransition) {
		restTemplate.put(SERVER + "update/", autotransition, Autotransition.class);
	}

	@Override
	public Autotransition getAutotransitionById(long id) {
		return restTemplate.getForObject(SERVER + "show/"+id, Autotransition.class);
	}

	@Override
	public Iterable<Autotransition> findAll() {
		Autotransition[] autotransitions = restTemplate.getForObject(SERVER, Autotransition[].class);
		List<Autotransition> list;
		try {
			list = Arrays.asList(autotransitions);
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
