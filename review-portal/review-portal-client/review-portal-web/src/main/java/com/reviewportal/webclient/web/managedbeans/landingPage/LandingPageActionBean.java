package com.reviewportal.webclient.web.managedbeans.landingPage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.reviewportal.webclient.web.managedbeans.AbstractActionBean;

@ManagedBean(name = "landingPageActionBean")
@ViewScoped
public class LandingPageActionBean extends AbstractActionBean {

	public void registerUser() {
		System.out.println("------------------------" + getParent().getAccessor().getSignupUser());
	}

	@SuppressWarnings("unchecked")
	@Override
	public LandingPageViewBean getParent() {
		return super.getParent();
	}

}
