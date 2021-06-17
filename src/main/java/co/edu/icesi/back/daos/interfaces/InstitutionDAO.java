package co.edu.icesi.back.daos.interfaces;

import java.util.List;

import co.edu.icesi.back.model.Institution;

public interface InstitutionDAO {
	
	public void Save(Institution entity);
	public void Delete(Institution entity);
	public void Edit(Institution entity);
	public Institution findById(long id);
	public List<Institution> findAll();


}
