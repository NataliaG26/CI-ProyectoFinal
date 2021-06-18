package co.edu.icesi.front.bd.interfaces;

import java.util.List;

import co.edu.icesi.front.model.classes.Institution;

public interface InstitutionDelegate {
	
	public Institution createInstitution(Institution institution);
	
	public void updateInstitution(Institution institution);
	
	public Institution getInstitutionById(long id);
	
	public List<Institution> findAll();
	
	public void delete(long id);

}
