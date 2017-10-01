package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import model.BaseEntity;
import repository.BaseRepository;

/**
 * Base class to implement a Repository.
 * 
 * @author pedholiveira
 * @param <T>
 */
public abstract class BaseDAO<T extends BaseEntity> implements BaseRepository<T> {
	
	private static final String PU_NAME = "escola";
	
	@Override
	public void save(T entity) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(entity);
		em.getTransaction().commit();
	}
	
	@Override
	public void delete(T entity) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.remove(em.merge(entity));
		em.getTransaction().commit();
	}
	
	@Override
	public T find(long id) {
		EntityManager manager = getEntityManager();
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(getEntityClass());
        Root<T> root = criteriaQuery.from(getEntityClass());
        criteriaQuery.where(criteriaBuilder.equal(root.get("id"), id));
        CriteriaQuery<T> select = criteriaQuery.select(root);
        TypedQuery<T> query = manager.createQuery(select);
        List<T> result = query.getResultList();
        return result.size() > 0 ? result.get(0) : null;
	}
	
	@Override
	public List<T> listAll() {
		EntityManager manager = getEntityManager();
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(getEntityClass());
        Root<T> root = criteriaQuery.from(getEntityClass());
        CriteriaQuery<T> select = criteriaQuery.select(root);
        TypedQuery<T> query = manager.createQuery(select);
        return query.getResultList();
	}
	
	protected abstract Class<T> getEntityClass();
	
	/**
	 * Return the EntityManager class to manipulate actions at the database.
	 * 
	 * @return entityManager
	 */
	protected EntityManager getEntityManager() {
		return Persistence.createEntityManagerFactory(PU_NAME)
							.createEntityManager();
	}
}
