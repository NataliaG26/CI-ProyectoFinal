package co.edu.icesi.back.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.back.daos.interfaces.DocumenttypeDAO;
import co.edu.icesi.back.model.Documenttype;

@Repository
@Scope("singleton")
public class DocumenttypeDAOImpl implements DocumenttypeDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void Save(Documenttype entity) {
		em.persist(entity);
	}

	@Override
	public void Delete(Documenttype entity) {
		Documenttype attachedEntity = em.merge(entity);
		em.remove(attachedEntity);
	}

	@Override
	public void Edit(Documenttype entity) {
		em.merge(entity);
	}

	@Override
	public Documenttype findById(long id) {
		return em.find(Documenttype.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Documenttype> findAll() {
		String q = "SELECT doctype FROM Documenttype doctype";
		return em.createQuery(q).getResultList();
	}

}
