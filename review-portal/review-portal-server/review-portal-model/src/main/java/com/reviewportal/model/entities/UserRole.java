package com.reviewportal.model.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

/**
 * @author imfroz
 *
 */
@Entity
@Table(name = "USER_ROLE")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class UserRole extends AbstractEntity {

	@Column(unique = true)
	private String role;

	private String description;

	public UserRole() {
		super();
	}

	public UserRole(String pRole, String pDescription) {
		super();
		role = pRole;
		description = pDescription;
	}

	public UserRole(Long pId, Date pCreatedDate, String pCreatedBy, Date pModifiedDate, String pModifiedBy,
			String pRole, String pDescription) {
		super(pId, pCreatedDate, pCreatedBy, pModifiedDate, pModifiedBy);
		role = pRole;
		description = pDescription;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String pRole) {
		role = pRole;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String pDescription) {
		description = pDescription;
	}

	@Override
	public String toString() {
		return "UserRole [role=" + role + ", description=" + description + "]";
	}

}
