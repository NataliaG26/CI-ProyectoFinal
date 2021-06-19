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
		return restTemplate.postForEntity(SERVER, autotransition, Autotransition.class).getBody();
	}

	@Override
	public void updateAutotransition(Autotransition autotransition) {
		restTemplate.put(SERVER, autotransition, Autotransition.class);
	}

	@Override
	public Autotransition getAutotransitionById(long id) {
		return restTemplate.getForObject(SERVER+id, Autotransition.class);
	}

	@Override
	public Iterable<Autotransition> findAll() {
		Autotransition[] autotransitions = restTemplate.getForObject(SERVER, Autotransition[].class);
		List<Autotransition> at = Arrays.asList(autotransitions);
		if(at.size()==0) {
			return null;
		}
		return at;
	}

	@Override
	public void delete(long id) {
		restTemplate.delete(SERVER+ id);
	}

	@Override
	public Iterable<Autotransition> searchByName(String autoName) {
		Autotransition[] autotransitions = restTemplate.getForObject(SERVER+"?autoName="+autoName, Autotransition[].class);
		System.out.println(autoName+" searchName Delegate");
		return Arrays.asList(autotransitions);
	}

	@Override
	public Iterable<Autotransition> searchByIsActive(String isActive) {
		Autotransition[] autotransitions = restTemplate.getForObject(SERVER+"?isActive="+isActive, Autotransition[].class);
		return Arrays.asList(autotransitions);
	}

	@Override
	public Iterable<Autotransition> searchByLogicOp(String logicOp) {
		Autotransition[] autotransitions = restTemplate.getForObject(SERVER+"?logicOp="+logicOp, Autotransition[].class);
		return Arrays.asList(autotransitions);
	}
	
	
}
