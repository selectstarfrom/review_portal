package com.reviewportal.webclient.web.managedbeans.landingPage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.reviewportal.service.impl.services.member.EmployeeMemberServicesImpl;
import com.reviewportal.webclient.web.managedbeans.AbstractActionBean;

@ManagedBean(name = "landingPageActionBean")
@ViewScoped
public class LandingPageActionBean extends AbstractActionBean {

	public void registerUser() {
	    System.out.println("------------------------" + getParent().getAccessor().getEmployeeMemberServicesImpl());
		System.out.println("------------------------" + getParent().getAccessor().getSignupUser());
		EmployeeMemberServicesImpl lEmployeeMemberServicesImpl = getParent().getAccessor().getEmployeeMemberServicesImpl();
		System.out.println(lEmployeeMemberServicesImpl.toString());
	}

	@SuppressWarnings("unchecked")
	@Override
	public LandingPageViewBean getParent() {
		return super.getParent();
	}

}
