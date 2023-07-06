package org.example.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.example.model.Resourcetype;

/**
 * DAO for Resourcetype
 */
@Stateless
public class ResourcetypeDao {
	@PersistenceContext(unitName = "invontory-persistence-unit")
	private EntityManager em;

	public void create(Resourcetype entity) {
		em.persist(entity);
	}

	public void deleteById(Integer id) {
		Resourcetype entity = em.find(Resourcetype.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Resourcetype findById(Integer id) {
		return em.find(Resourcetype.class, id);
	}

	public Resourcetype update(Resourcetype entity) {
		return em.merge(entity);
	}

	public List<Resourcetype> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Resourcetype> findAllQuery = em.createQuery("SELECT DISTINCT r FROM Resourcetype r ORDER BY r.id",
				Resourcetype.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
