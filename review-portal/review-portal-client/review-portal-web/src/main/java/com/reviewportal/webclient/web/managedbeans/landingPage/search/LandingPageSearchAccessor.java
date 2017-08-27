package com.reviewportal.webclient.web.managedbeans.landingPage.search;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.reviewportal.service.impl.services.UserServicesImpl;
import com.reviewportal.service.impl.services.member.ProfessionalMemberServicesImpl;
import com.reviewportal.service.impl.services.member.ReviewWriterMemberServicesImpl;
import com.reviewportal.webclient.web.managedbeans.AbstractMBean;
import com.reviewportal.webclient.web.managedbeans.IPropertyAccessor;

/**
 * @author imfroz
 *
 */
@ManagedBean(name = "landingPageSearchAccessor")
@ViewScoped
public class LandingPageSearchAccessor extends AbstractMBean implements IPropertyAccessor {

	private static final long serialVersionUID = -5805117559419329640L;
	
	private String searchProfession;

	@PostConstruct
	public void init() {
		super.init();
	}

	@Autowired
	protected transient ProfessionalMemberServicesImpl professionalMemberService;
	@Autowired
	protected transient ReviewWriterMemberServicesImpl reviewWriterMemberService;
	@Autowired
	protected transient UserServicesImpl userServices;

	public LandingPageSearchAccessor() {
		super();
	}

	public String getSearchProfession() {
		return searchProfession;
	}

	public void setSearchProfession(String pSearchProfession) {
		searchProfession = pSearchProfession;
	}
	
	

}
