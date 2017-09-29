package service.impl;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import model.User;
import repository.UserRepository;
import service.UserService;

/**
 * Implementation of {@link UserService}.
 * 
 * @author pedholiveira
 */
@RequestScoped
public class UserServiceImpl implements UserService {

	@Inject
	private UserRepository repository;
	
	@Override
	public void create(User user) {
		repository.save(user);
	}

	@Override
	public void update(User user) {
		repository.save(user);
	}

	@Override
	public void delete(User user) {
		repository.delete(user);
	}

	@Override
	public User find(long id) {
		return repository.find(id);
	}

	@Override
	public List<User> list() {
		return repository.listAll();
	}

}
