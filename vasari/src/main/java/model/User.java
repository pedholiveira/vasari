package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Entity class for system users.
 * 
 * @author pedholiveira
 */
@Entity
@Table(name="user")
public class User extends BaseEntity {
	
	private static final long serialVersionUID = 7884209361845675064L;

	private String username;
	private String password;
	@ManyToMany(mappedBy = "users", fetch=FetchType.EAGER)
	private List<Category> categories;

	/**
	 * @return username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return category
	 */
	public List<Category> getCategories() {
		return categories;
	}

	/**
	 * @param category
	 */
	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

}
