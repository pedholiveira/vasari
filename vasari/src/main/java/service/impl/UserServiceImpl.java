package service.impl;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

import model.User;
import repository.UserRepository;
import service.UserService;
import utils.EncryptionUtils;

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
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void save(User user) {
		String password = EncryptionUtils.encryptSHA256(user.getPassword());
		user.setPassword(password);
		
		repository.save(user);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void delete(long id) {
		User user = find(id);
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
