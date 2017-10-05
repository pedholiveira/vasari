package repository;

import java.util.List;

import enumeration.CategoryEnum;
import model.User;

/**
 * Data repository to store {@link User} instances.
 * 
 * @author pedholiveira
 */
public interface UserRepository extends BaseRepository<User> {
	
	public List<User> list(CategoryEnum category);
	
}
