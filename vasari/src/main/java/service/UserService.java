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
	 * Create a new user.
	 * 
	 * @param user
	 */
	public void create(User user);
	
	/**
	 * Update an existing user.
	 * 
	 * @param user
	 */
	public void update(User user);
	
	/**
	 * Delete an existing user.
	 * 
	 * @param user
	 */
	public void delete(User user);
	
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
