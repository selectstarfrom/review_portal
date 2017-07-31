package com.reviewportal.service.dto;

import java.util.Date;

/**
 * @author imfroz
 *
 */

public class UserRoleDTO extends AbstractDTO {

	private String role;

	private String description;

	public UserRoleDTO() {
		super();
	}

	public UserRoleDTO(Long pId, Date pCreatedDate, String pCreatedBy, Date pModifiedDate, String pModifiedBy,
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
		return "UserRoleDTO [role=" + role + ", description=" + description + "]";
	}

}
