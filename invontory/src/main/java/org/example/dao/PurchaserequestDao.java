package org.example.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.example.model.Purchaserequest;

/**
 * DAO for Purchaserequest
 */
@Stateless
public class PurchaserequestDao {
	@PersistenceContext(unitName = "invontory-persistence-unit")
	private EntityManager em;

	public void create(Purchaserequest entity) {
		em.persist(entity);
	}

	public void deleteById(Integer id) {
		Purchaserequest entity = em.find(Purchaserequest.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Purchaserequest findById(Integer id) {
		return em.find(Purchaserequest.class, id);
	}

	public Purchaserequest update(Purchaserequest entity) {
		return em.merge(entity);
	}

	public List<Purchaserequest> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Purchaserequest> findAllQuery = em.createQuery(
				"SELECT DISTINCT p FROM Purchaserequest p LEFT JOIN FETCH p.employee LEFT JOIN FETCH p.purchases ORDER BY p.id",
				Purchaserequest.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
