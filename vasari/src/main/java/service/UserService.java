package service;

import java.util.List;

import model.User;

/**
 * Class to manipulate the business rules of {@link User}.
 * 
 * @author pedholiveira
 */
public interface UserService {
	
	/**
	 * Save an user instance.
	 * 
	 * @param user
	 */
	public void save(User user);
	
	/**
	 * Delete an existing user.
	 * 
	 * @param id
	 */
	public void delete(long id);
	
	/**
	 * Find an specifc user by id.
	 * 
	 * @param id
	 * @return
	 */
	public User find(long id);
	
	/**
	 * List all existing users.
	 * 
	 * @return users
	 */
	public List<User> list();
}
