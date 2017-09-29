package model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import enumeration.CategoryEnum;

/**
 * User category
 * 
 * @author pedholiveira
 */
@Entity
@Table(name = "category")
public class Category extends BaseEntity {
	private static final long serialVersionUID = 2353715873245995344L;

	@Enumerated(EnumType.STRING)
	private CategoryEnum name;
	@ManyToMany
    @JoinTable(name="user_category",
    	joinColumns = @JoinColumn(name = "category_name", referencedColumnName = "name"), 
    	inverseJoinColumns = @JoinColumn(name = "user_name", referencedColumnName = "username"))
	private List<User> users;

	/**
	 * @return name
	 */
	public CategoryEnum getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(CategoryEnum name) {
		this.name = name;
	}

	/**
	 * @return users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

}
