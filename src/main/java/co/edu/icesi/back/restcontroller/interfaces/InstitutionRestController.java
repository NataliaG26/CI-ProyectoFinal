package co.edu.icesi.back.restcontroller.interfaces;

import org.springframework.web.bind.annotation.PathVariable;

import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.back.model.Institution;

public interface InstitutionRestController {
	
	public Iterable<Institution> showAllInstitutions();
	
	public Institution showInstitution(@PathVariable("id") long id);
	
	public void updateInstitution(Institution institution) throws LogicalException;
	
	public Institution saveInstitution(Institution institution) throws LogicalException;
	
	public void deleteInstitution(@PathVariable("id") long id) throws LogicalException;
	
	
	
	

}
