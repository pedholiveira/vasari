package model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import enumeration.CategoryEnum;

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
	@Enumerated(EnumType.STRING)
	private CategoryEnum category;

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
	public CategoryEnum getCategory() {
		return category;
	}

	/**
	 * @param category
	 */
	public void setCategory(CategoryEnum category) {
		this.category = category;
	}

}
