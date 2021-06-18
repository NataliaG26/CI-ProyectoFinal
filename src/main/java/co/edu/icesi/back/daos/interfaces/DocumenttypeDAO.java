package co.edu.icesi.back.daos.interfaces;

import java.util.List;

import co.edu.icesi.back.model.Documenttype;

public interface DocumenttypeDAO {
	
	public void Save(Documenttype entity);
	
	public void Delete(Documenttype entity);
	
	public void Edit(Documenttype entity);
	
	public Documenttype findById(long id);
	
	public List<Documenttype> findAll();

}
