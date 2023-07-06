package org.example.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.example.model.Resources;

/**
 * DAO for Resources
 */
@Stateless
public class ResourcesDao {
	@PersistenceContext(unitName = "invontory-persistence-unit")
	private EntityManager em;

	public void create(Resources entity) {
		em.persist(entity);
	}

	public void deleteById(Integer id) {
		Resources entity = em.find(Resources.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Resources findById(Integer id) {
		return em.find(Resources.class, id);
	}

	public Resources update(Resources entity) {
		return em.merge(entity);
	}

	public List<Resources> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Resources> findAllQuery = em.createQuery(
				"SELECT DISTINCT r FROM Resources r LEFT JOIN FETCH r.resourcerequests LEFT JOIN FETCH r.holdingses LEFT JOIN FETCH r.purchases ORDER BY r.id",
				Resources.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
