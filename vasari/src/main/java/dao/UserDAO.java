package dao;

import javax.enterprise.context.RequestScoped;

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
	protected Class<User> getEntityClass() {
		return User.class;
	}

}
