package co.edu.icesi.nigm.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.nigm.daos.interfaces.PersonautotranDAO;
import co.edu.icesi.nigm.model.Autotransition;
import co.edu.icesi.nigm.model.Personautotran;

@Repository
@Scope("singleton")
public class PersonautotranDAOImpl implements PersonautotranDAO{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void Save(Personautotran entity) {
		em.persist(entity);
		
	}

	@Override
	public void Delete(Personautotran entity) {
		Personautotran attachedEntity = em.merge(entity);
		em.remove(attachedEntity);	
	}

	@Override
	public void Edit(Personautotran entity) {
		em.merge(entity);
	}

	@Override
	public Personautotran findById(long id) {
		return em.find(Personautotran.class, id);
	}

	@Override
	public List<Personautotran> findAll() {
		String q = "SELECT personau FROM Personautotran personau";
		return em.createQuery(q).getResultList();
	}

	@Override
	public List<Personautotran> findByPersonId(long personId) {
		String q = "SELECT personau FROM Personautotran personau WHERE personau.person.persId = :personId";
		Query query = em.createQuery(q);
		query.setParameter("personId", personId);
		return query.getResultList();
	}

	@Override
	public List<Personautotran> findByAutotranId(long autotranId) {
		String q = "SELECT personau FROM Personautotran personau WHERE personau.autotransition.autotranId = :autotranId";
		Query query = em.createQuery(q);
		query.setParameter("autotranId", autotranId);
		return query.getResultList();
	}

	@Override
	public List<Personautotran> findByDate(String date) {
		String q = "SELECT personau FROM Personautotran personau WHERE personau.perautDate = :date";
		Query query = em.createQuery(q);
		query.setParameter("date", date);
		return query.getResultList();
	}

	@Override
	public List<Personautotran> findByDataRange(String startDate, String finishDate) {
		String q = "SELECT personau FROM Personautotran personau WHERE personau.perautDate >= :startDate AND personau.perautDate <= :finishDate";
		Query query = em.createQuery(q);
		query.setParameter("startDate", startDate);
		query.setParameter("finishDate", finishDate);
		return query.getResultList();
	}

}
