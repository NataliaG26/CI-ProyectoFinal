package co.edu.icesi.nigm.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.nigm.daos.interfaces.AutotransitionDAO;
import co.edu.icesi.nigm.model.Autotransition;

@Repository
@Scope("singleton")
public class AutotransitionDAOImpl implements AutotransitionDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void Save(Autotransition entity) {
		em.persist(entity);
	}

	@Override
	public void Delete(Autotransition entity) {
		Autotransition attachedEntity = em.merge(entity);
		em.remove(attachedEntity);
	}

	@Override
	public void Edit(Autotransition entity) {
		em.merge(entity);
	}

	@Override
	public Autotransition findById(long id) {
		return em.find(Autotransition.class, id);
	}

	@Override
	public List<Autotransition> findAll() {
		String q = "SELECT auto FROM Autotransition auto";
		return em.createQuery(q).getResultList();
	}

	@Override
	public List<Autotransition> findByName(String name) {
		String q =  "SELECT auto FROM Autotransition auto WHERE auto.autotranName = :name";
		Query query = em.createQuery(q);
		query.setParameter("name", name);
		return query.getResultList();
	}

	@Override
	public List<Autotransition> findByIsactive(String isActive) {
		String q = "SELECT auto FROM Autotransition auto WHERE auto.autotranIsactive = :isActive";
		Query query = em.createQuery(q);
		query.setParameter("isActive", isActive);
		return query.getResultList();
	}

	@Override
	public List<Autotransition> findByLogicOperand(String logicoperand) {
		String q = "SELECT auto FROM Autotransition auto WHERE auto.autotranLogicaloperand = :logicoperand";
		Query query = em.createQuery(q);
		query.setParameter("logicoperand", logicoperand);
		return query.getResultList();
	}
	
	

}
