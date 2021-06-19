package co.edu.icesi.front.bd.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.front.bd.interfaces.PersonautotranDelegate;
import co.edu.icesi.front.model.classes.Personautotran;

@Component
public class PersonautoranDelegateImpl implements PersonautotranDelegate{
	
	RestTemplate restTemplate;
	final String SERVER="http://localhost:8080/api-rest/personautotran/";
	
	public PersonautoranDelegateImpl() {
		this.restTemplate = new RestTemplate();
	}

	@Override
	public Personautotran createPersonautotran(Personautotran personautotran, long personId, long autotranId) throws LogicalException {
		String s = SERVER + "add/"+personId+"/"+autotranId;
		System.out.println(s);
		return restTemplate.postForEntity(s, personautotran, Personautotran.class).getBody();
	}

	@Override
	public void updatePersonautotran(Personautotran personautotran) throws LogicalException {
		restTemplate.put(SERVER + "update/", personautotran, Personautotran.class);
	}

	@Override
	public Personautotran getPersonautotranById(long id) throws LogicalException {
		return restTemplate.getForObject(SERVER  + id, Personautotran.class);
	}

	@Override
	public Iterable<Personautotran> findAll() {
		Personautotran[] personautotrans = restTemplate.getForObject(SERVER, Personautotran[].class);
		List<Personautotran> at;
		try {
			at = Arrays.asList(personautotrans);
			return at;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public void delete(long id) {
		restTemplate.delete(SERVER + + id);
	}
}
