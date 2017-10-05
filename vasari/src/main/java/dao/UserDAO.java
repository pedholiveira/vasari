package dao;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import enumeration.CategoryEnum;
import model.User;
import repository.UserRepository;

/**
 * User's data repository implementation. 
 * 
 * @author pedholiveira
 */
@RequestScoped
public class UserDAO extends BaseDAO<User> implements UserRepository {

	@Override
	public List<User> list(CategoryEnum category) {
		EntityManager manager = getEntityManager();
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(getEntityClass());
        CriteriaQuery<User> select = criteriaQuery.select(root)
        		.where(criteriaBuilder.equal(root.get("category"), category));
        TypedQuery<User> query = manager.createQuery(select);
        return query.getResultList();
	}
	
	@Override
	protected Class<User> getEntityClass() {
		return User.class;
	}

}
