/**
 * 
 */
package co.edu.icesi.back.service.interfaces;

import co.edu.icesi.back.exception.LogicalException;
import co.edu.icesi.back.model.Institution;

/**
 * 
 */
public interface InstitutionService {

	public Institution createInstitution(Institution institution) throws LogicalException;
	
	public Institution updateInstitution(Institution institution) throws LogicalException;
	
	public Institution getInstitutionById(long id) throws LogicalException;
	
	public Iterable<Institution> findAll();
	
	public void delete(Institution institution);

}

