/**
 * 
 */
package co.edu.icesi.nigm.service.interfaces;

import co.edu.icesi.nigm.exception.LogicalException;
import co.edu.icesi.nigm.model.Institution;

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

