package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Table;

import annotation.EnumField;
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

	@Column(name="username", nullable=false, length=45)
	private String username;
	@Column(name="password", nullable=false, length=65)
	private String password;
	
	@EnumField
	@Enumerated(EnumType.STRING)
	@Column(name="category", nullable=false, length=45)
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
