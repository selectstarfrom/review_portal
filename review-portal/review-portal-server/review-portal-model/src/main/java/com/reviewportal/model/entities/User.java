package com.reviewportal.model.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.reviewportal.model.enums.UserStatus;

/**
 * @author imfroz
 *
 */
@Entity
@Table(name = "USER")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class User extends AbstractEntity {

	private String name;

	private String username;

	private String email;

	private String password;

	private UserStatus status;

	private String telephone;

	private String displayPicture;

	// @Column(name = "ID")
	@ManyToMany(cascade = {CascadeType.MERGE}, fetch = FetchType.EAGER)
	@JoinTable(name = "MAP_USER_USER_ROLES", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "USER_ROLE_ID") })
	private Set<UserRole> userRoles;

	public User() {
		super();
	}

	public User(Long pId, Date pCreatedDate, String pCreatedBy, Date pModifiedDate, String pModifiedBy, String name,
			String username, String email, String password, UserStatus status, String telephone, String displayPicture,
			Set<UserRole> userRoles) {
		super(pId, pCreatedDate, pCreatedBy, pModifiedDate, pModifiedBy);
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
		this.status = status;
		this.telephone = telephone;
		this.displayPicture = displayPicture;
		this.userRoles = userRoles;
	}

	public String getName() {
		return name;
	}

	public void setName(String pName) {
		name = pName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String pUsername) {
		username = pUsername;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String pPassword) {
		password = pPassword;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus pStatus) {
		status = pStatus;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String pTelephone) {
		telephone = pTelephone;
	}

	public String getDisplayPicture() {
		return displayPicture;
	}

	public void setDisplayPicture(String pDisplayPicture) {
		displayPicture = pDisplayPicture;
	}

	public Set<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRole> pUserRoles) {
		userRoles = pUserRoles;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", username=" + username + ", email=" + email + ", password=" + password
				+ ", status=" + status + ", telephone=" + telephone + ", displayPicture=" + displayPicture
				+ ", userRoles=" + userRoles + "]";
	}

}
