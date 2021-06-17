package co.edu.icesi.nigm.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import co.edu.icesi.nigm.daos.interfaces.PersonDAO;
import co.edu.icesi.nigm.model.Autotransition;
import co.edu.icesi.nigm.model.Person;

@Repository
@Scope("singleton")
public class PersonDAOImpl implements PersonDAO{
	
	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void Save(Person entity) {
		em.persist(entity);
	}

	@Override
	public void Delete(Person entity) {
		Person attachedEntity = em.merge(entity);
		em.remove(attachedEntity);
	}

	@Override
	public void Edit(Person entity) {
		em.merge(entity);
	}

	@Override
	public Person findById(long id) {
		return em.find(Person.class, id);
	}

	@Override
	public List<Person> findAll() {
		String q = "SELECT per FROM Person per";
		return em.createQuery(q).getResultList();
	}

	@Override
	public List<Person> findByName(String name) {
		String q =  "SELECT per FROM Person per WHERE per.persName = :name";
		Query query = em.createQuery(q);
		query.setParameter("name", name);
		return query.getResultList();
	}

	@Override
	public List<Person> findByIdDoc(String doc) {
		String q =  "SELECT per FROM Person per WHERE per.persIddocument = :doc";
		Query query = em.createQuery(q);
		query.setParameter("doc", doc);
		return query.getResultList();
	}

	@Override
	public List<Person> findByInstitution(long idInt) {
		String q =  "SELECT per FROM Person per WHERE per.institution.instId = :idInt";
		Query query = em.createQuery(q);
		query.setParameter("idInt", idInt);
		return query.getResultList();
	}

	@Override
	public List<Person> findAutotranActiveInDateRange(int active, String startDate, String finishDate) {
		String q = "SELECT per FROM Person per"
				+ "WHERE per.personautotrans.size() >= :active"
				+ "AND per.personautotrans.perautDate >= :startDate"
				+ "AND per.personautotrans.perautDate <= :finishDate";
		Query query = em.createQuery(q);
		query.setParameter("active", active);
		query.setParameter("startDate", startDate);
		query.setParameter("finishDate", finishDate);
		return query.getResultList();
	}

}
