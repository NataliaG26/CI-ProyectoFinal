package co.edu.icesi.back.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.back.daos.interfaces.DocumenttDAO;
import co.edu.icesi.back.model.Documentt;

@Repository
@Scope("singleton")
public class DocumenttDAOImpl implements DocumenttDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void Save(Documentt entity) {
		em.persist(entity);
	}

	@Override
	public void Delete(Documentt entity) {
		Documentt attachedEntity = em.merge(entity);
		em.remove(attachedEntity);
	}

	@Override
	public void Edit(Documentt entity) {
		em.merge(entity);
	}

	@Override
	public Documentt findById(long id) {
		return em.find(Documentt.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Documentt> findAll() {
		String q = "SELECT doc FROM Documentt doc";
		return em.createQuery(q).getResultList();
	}

}
