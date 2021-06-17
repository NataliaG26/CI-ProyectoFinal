package co.edu.icesi.back.daos.interfaces;

import java.util.List;

import co.edu.icesi.back.model.Person;

public interface PersonDAO {
	
	public void Save(Person entity);
	
	public void Delete(Person entity);
	
	public void Edit(Person entity);
	
	public Person findById(long id);
	
	public List<Person> findAll();
	
	public List<Person> findByName(String name);
	
	public List<Person> findByIdDoc(String doc);
	
	public List<Person> findByInstitution(long idInt);
	
	public List<Person> findAutotranActiveInDateRange(int active, String startDate, String finishDate);

}
