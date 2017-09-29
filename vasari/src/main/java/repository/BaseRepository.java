package repository;

import java.util.List;

import model.BaseEntity;

/**
 * Entity base repository. 
 * 
 * @author pedholiveira
 * @param <T>
 */
public interface BaseRepository<T extends BaseEntity> {
	
	/**
	 * Save an entity instance at the database.
	 * 
	 * @param entity
	 */
	public void save(T entity);
	
	/**
	 * Delete an entity that already exists in the database.
	 * 
	 * @param entity
	 */
	public void delete(T entity);
	
	/**
	 * Find a specific entity instance by id.
	 * 
	 * @param id
	 * @return entity
	 */
	public T find(long id);
	
	/**
	 * List all entities instances.
	 * 
	 * @return
	 */
	public List<T> listAll();
}
