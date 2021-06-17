package co.edu.icesi.nigm.daos.interfaces;

import java.util.List;

import co.edu.icesi.nigm.model.Personautotran;

public interface PersonautotranDAO {
	
	public void Save(Personautotran entity);
	
	public void Delete(Personautotran entity);
	
	public void Edit(Personautotran entity);
	
	public Personautotran findById(long id);
	
	public List<Personautotran> findAll();
	
	public List<Personautotran> findByPersonId(long personId);
	
	public List<Personautotran> findByAutotranId(long autotranId);
	
	public List<Personautotran> findByDate(String date);
	
	public List<Personautotran> findByDataRange(String startDate, String finishDate);

}
