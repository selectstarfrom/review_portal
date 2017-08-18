package com.reviewportal.webclient.web.managedbeans.landingPage;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.reviewportal.service.dto.AbstractMemberDTO;
import com.reviewportal.service.dto.OfficialDTO;
import com.reviewportal.service.dto.ReviewWriterDTO;
import com.reviewportal.service.dto.UserDTO;
import com.reviewportal.webclient.web.core.PropertyAccessor;
import com.reviewportal.webclient.web.core.ViewAction;
import com.reviewportal.webclient.web.core.ViewBase;
import com.reviewportal.webclient.web.managedbeans.AbstractViewBean;

@ManagedBean(name = "landingPageBean")
@ViewScoped
@ViewBase(baseName = "landing")
@PropertyAccessor(className = LandingPageAccessor.class)
@ViewAction(className=LandingPageActionBean.class)
public class LandingPageViewBean extends AbstractViewBean {

	private static final long serialVersionUID = -2350610396008037477L;

	@PostConstruct
	public void init() {
		super.init();
		mock();
		getAccessor().setSignupUser(getNewSignupReviewWriterInstance());
		getAccessor().setSignInUser(getNewSignInUserInstance());
	}

	public AbstractMemberDTO getNewSignupReviewWriterInstance() {
		ReviewWriterDTO lInstance = new ReviewWriterDTO();
		return lInstance;
	}

	public UserDTO getNewSignInUserInstance() {
		UserDTO lInstance = new UserDTO();
		return lInstance;
	}

	public AbstractMemberDTO getNewSignupOfficialInstance() {

		OfficialDTO lInstance = new OfficialDTO();

		return lInstance;
	}

	private void mock() {

	}

	@Override
	public LandingPageAccessor getAccessor() {
		return (LandingPageAccessor) this.accessor;
	}

	@Override
	public LandingPageActionBean getActions() {
		return (LandingPageActionBean) super.actions;
	}

}