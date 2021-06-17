package co.edu.icesi.nigm.daos.interfaces;

import java.util.List;

import co.edu.icesi.nigm.model.Institution;

public interface InstitutionDAO {
	
	public void Save(Institution entity);
	public void Delete(Institution entity);
	public void Edit(Institution entity);
	public Institution findById(long id);
	public List<Institution> findAll();


}
