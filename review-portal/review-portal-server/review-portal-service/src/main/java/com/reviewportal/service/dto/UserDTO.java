package com.reviewportal.service.dto;

import java.util.Date;
import java.util.Set;

import com.reviewportal.model.enums.UserStatus;
import com.reviewportal.model.enums.UserType;

/**
 * @author imfroz
 *
 */
public class UserDTO extends AbstractDTO {

    private String name;

    private String username;

    private String email;

    private String password;

    private UserStatus status = UserStatus.NEW;

    private String telephone;

    private String displayPicture;

    private Set<UserRoleDTO> userRoles;

    private UserType userType;

    public UserDTO() {
        super();
    }

    public UserDTO(Long pId, Date pCreatedDate, String pCreatedBy, Date pModifiedDate, String pModifiedBy, String name,
            String username, String email, String password, UserStatus status, String telephone, String displayPicture,
            UserType pUserType, Set<UserRoleDTO> userRoles) {
        super(pId, pCreatedDate, pCreatedBy, pModifiedDate, pModifiedBy);
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.status = status;
        this.telephone = telephone;
        this.displayPicture = displayPicture;
        this.userType = pUserType;
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

    public Set<UserRoleDTO> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(Set<UserRoleDTO> pUserRoles) {
        userRoles = pUserRoles;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType pUserType) {
        userType = pUserType;
    }

    @Override
    public String toString() {
        return "UserDTO [name=" + name + ", username=" + username + ", email=" + email + ", password=" + password
                + ", status=" + status + ", telephone=" + telephone + ", displayPicture=" + displayPicture
                + ", userRoles=" + userRoles + ", userType=" + userType + "]";
    }

}
