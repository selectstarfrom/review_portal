package com.reviewportal.webclient.web.managedbeans.landingPage;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.reviewportal.service.dto.OfficialDTO;
import com.reviewportal.service.dto.ProfessionDTO;
import com.reviewportal.service.dto.UserDTO;
import com.reviewportal.webclient.web.managedbeans.AbstractViewBean;

@ManagedBean(name = "landingPageBean")
@ViewScoped
public class LandingPageViewBean extends AbstractViewBean {

	private static final long serialVersionUID = -2350610396008037477L;

	private List<OfficialDTO> searchResult;

	@PostConstruct
	public void init() {
		mock();
		super.accessor = getPropertyAccessorBean("landingPageAccessor");
		super.actions = getActionBean("landingPageActionBean");
		getActions().setParent(this);
		getAccessor().setSignupUser(getNewSignupUserInstance());
	}

	private UserDTO getNewSignupUserInstance() {
		UserDTO lUserDTO = new UserDTO();
		return lUserDTO;
	}

	private void mock() {
		searchResult = new ArrayList<>();
		for (int lI = 0; lI < 15; lI++) {
			OfficialDTO lOfficialDTO = new OfficialDTO();
			lOfficialDTO.setName("Professional" + "-" + lI);
			lOfficialDTO.setProfession(new ProfessionDTO());
			lOfficialDTO.getProfession().setTitle("Lawyer");
			lOfficialDTO.setUser(getNewSignupUserInstance());
			lOfficialDTO.getUser().setEmail("prof" + "-" + lI + "@gmail.com");
			lOfficialDTO.getUser().setDisplayPicture("images/avatar" + lI % 5 + ".png");
			searchResult.add(lOfficialDTO);

		}

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