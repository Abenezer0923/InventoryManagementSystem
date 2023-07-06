package org.example.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.example.model.Resourcerequest;

/**
 * DAO for Resourcerequest
 */
@Stateless
public class ResourcerequestDao {
	@PersistenceContext(unitName = "invontory-persistence-unit")
	private EntityManager em;

	public void create(Resourcerequest entity) {
		em.persist(entity);
	}

	public void deleteById(int id) {
		Resourcerequest entity = em.find(Resourcerequest.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Resourcerequest findById(int id) {
		return em.find(Resourcerequest.class, id);
	}

	public Resourcerequest update(Resourcerequest entity) {
		return em.merge(entity);
	}

	public List<Resourcerequest> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Resourcerequest> findAllQuery = em.createQuery(
				"SELECT DISTINCT r FROM Resourcerequest r LEFT JOIN FETCH r.employee LEFT JOIN FETCH r.resources ORDER BY r.id",
				Resourcerequest.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
