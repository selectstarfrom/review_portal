package com.reviewportal.webclient.web.managedbeans.landingPage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.reviewportal.service.dto.UserDTO;
import com.reviewportal.webclient.web.managedbeans.IPropertyAccessor;

@ManagedBean(name="landingPageAccessor")
@ViewScoped
public class LandingPageAccessor implements IPropertyAccessor {

	private UserDTO signupUser;

	public UserDTO getSignupUser() {
		return signupUser;
	}

	public void setSignupUser(UserDTO signupUser) {
		this.signupUser = signupUser;
	}
}
