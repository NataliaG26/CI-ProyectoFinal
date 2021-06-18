package co.edu.icesi.back.daos.interfaces;

import java.util.List;

import co.edu.icesi.back.model.Documentt;

public interface DocumenttDAO {
	
public void Save(Documentt entity);
	
	public void Delete(Documentt entity);
	
	public void Edit(Documentt entity);
	
	public Documentt findById(long id);
	
	public List<Documentt> findAll();

}
