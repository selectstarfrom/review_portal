package com.reviewportal.webclient.web.managedbeans.landingPage.search;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.reviewportal.service.dto.AbstractMemberDTO;
import com.reviewportal.service.dto.ProfessionalDTO;
import com.reviewportal.service.dto.ReviewWriterDTO;
import com.reviewportal.service.dto.UserDTO;
import com.reviewportal.webclient.web.core.PropertyAccessor;
import com.reviewportal.webclient.web.core.ViewAction;
import com.reviewportal.webclient.web.managedbeans.AbstractViewBean;

/**
 * @author imfroz
 *
 */
@ManagedBean(name = "landingPageSearchBean")
@ViewScoped
@PropertyAccessor(className = LandingPageSearchAccessor.class)
@ViewAction(className = LandingPageSearchActionBean.class)
public class LandingPageViewBean extends AbstractViewBean {

	private static final long serialVersionUID = 5610163128120651427L;

	@PostConstruct
	public void init() {
		super.init();
	}

	public AbstractMemberDTO getNewSignupReviewWriterInstance() {
		ReviewWriterDTO lInstance = new ReviewWriterDTO();
		return lInstance;
	}

	public UserDTO getNewSignInUserInstance() {
		UserDTO lInstance = new UserDTO();
		return lInstance;
	}

	public AbstractMemberDTO getNewSignupProfessionalInstance() {

		ProfessionalDTO lInstance = new ProfessionalDTO();

		return lInstance;
	}

	@Override
	public LandingPageSearchAccessor getAccessor() {
		return (LandingPageSearchAccessor) this.accessor;
	}

	@Override
	public LandingPageSearchActionBean getActions() {
		return (LandingPageSearchActionBean) super.actions;
	}

}