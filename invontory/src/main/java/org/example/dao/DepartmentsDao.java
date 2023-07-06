package org.example.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import org.example.model.Departments;

/**
 * DAO for Departments
 */
@Stateless
public class DepartmentsDao {
	@PersistenceContext(unitName = "invontory-persistence-unit")
	private EntityManager em;

	public void create(Departments entity) {
		em.persist(entity);
	}

	public void deleteById(Integer id) {
		Departments entity = em.find(Departments.class, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	public Departments findById(Integer id) {
		return em.find(Departments.class, id);
	}

	public Departments update(Departments entity) {
		return em.merge(entity);
	}

	public List<Departments> listAll(Integer startPosition, Integer maxResult) {
		TypedQuery<Departments> findAllQuery = em.createQuery(
				"SELECT DISTINCT d FROM Departments d LEFT JOIN FETCH d.employees ORDER BY d.id", Departments.class);
		if (startPosition != null) {
			findAllQuery.setFirstResult(startPosition);
		}
		if (maxResult != null) {
			findAllQuery.setMaxResults(maxResult);
		}
		return findAllQuery.getResultList();
	}
}
