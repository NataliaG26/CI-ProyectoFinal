package co.edu.icesi.back.daos.interfaces;

import java.util.List;

import co.edu.icesi.back.model.Autotransition;

public interface AutotransitionDAO {
	
	public void Save(Autotransition entity);
	
	public void Delete(Autotransition entity);
	
	public void Edit(Autotransition entity);
	
	public Autotransition findById(long id);
	
	public List<Autotransition> findAll();
	
	public List<Autotransition> findByName(String name);
	
	public List<Autotransition> findByIsactive(String isActive);
	
	public List<Autotransition> findByLogicOperand(String logicoperand);
	
}
