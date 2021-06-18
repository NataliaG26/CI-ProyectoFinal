package co.edu.icesi.back.restcontroller.interfaces;

import org.springframework.web.bind.annotation.PathVariable;
import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.back.model.Personautotran;

public interface PersonautotranRestController {
	
	public Iterable<Personautotran> showAll();
	
	public Personautotran showPersonautotran(@PathVariable("id") long id) throws LogicalException;
	
	public Personautotran savePersonautotran(@PathVariable("personid") long personId, @PathVariable("autotranid") long autotranId, 
			Personautotran personautotran) throws LogicalException;
	
	public void deletePersonautotran(@PathVariable("id") long id) throws LogicalException;
	
	public void updatePersonautotran(Personautotran person) throws LogicalException;

}
