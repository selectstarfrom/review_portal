package com.reviewportal.service.dto;

import java.util.Date;
import java.util.Set;

import com.reviewportal.model.enums.UserStatus;

/**
 * @author imfroz
 *
 */
public class UserDTO extends AbstractDTO {

	private String name;

	private String username;

	private String password;

	private UserStatus status;

	private String telephone;

	private String displayPicture;

	private Set<UserRoleDTO> userRoles;

	public UserDTO() {
		super();
	}

	public UserDTO(Long pId, Date pCreatedDate, String pCreatedBy, Date pModifiedDate, String pModifiedBy, String pName,
			String pUsername, String pPassword, UserStatus pStatus, String pTelephone, String pDisplayPicture,
			Set<UserRoleDTO> pUserRoles) {
		super(pId, pCreatedDate, pCreatedBy, pModifiedDate, pModifiedBy);
		name = pName;
		username = pUsername;
		password = pPassword;
		status = pStatus;
		telephone = pTelephone;
		displayPicture = pDisplayPicture;
		userRoles = pUserRoles;
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

	public Set<UserRoleDTO> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRoleDTO> pUserRoles) {
		userRoles = pUserRoles;
	}

	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", username=" + username + ", password=" + password + ", status=" + status
				+ ", telephone=" + telephone + ", displayPicture=" + displayPicture + ", userRoles=" + userRoles + "]";
	}

}
