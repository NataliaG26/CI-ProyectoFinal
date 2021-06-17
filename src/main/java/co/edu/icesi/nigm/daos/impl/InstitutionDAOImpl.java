package co.edu.icesi.nigm.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.nigm.daos.interfaces.InstitutionDAO;
import co.edu.icesi.nigm.model.Institution;

@Repository
@Scope("singleton")
public class InstitutionDAOImpl implements InstitutionDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void Save(Institution entity) {
		em.persist(entity);
		
	}

	@Override
	public void Delete(Institution entity) {
		Institution attachedEntity = em.merge(entity);
		em.remove(attachedEntity);
		
	}

	@Override
	public void Edit(Institution entity) {
		em.merge(entity);
		
	}

	@Override
	public Institution findById(long id) {
		return em.find(Institution.class, id);
	}

	@Override
	public List<Institution> findAll() {
		String q = "SELECT inst FROM Institution inst";
		return em.createQuery(q).getResultList();
	}

}
