package com.reviewportal.webclient.web.managedbeans.landingPage;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.reviewportal.service.dto.AbstractMemberDTO;
import com.reviewportal.service.dto.OfficialDTO;
import com.reviewportal.service.dto.ReviewWriterDTO;
import com.reviewportal.service.dto.UserDTO;
import com.reviewportal.webclient.web.managedbeans.AbstractViewBean;

@ManagedBean(name = "landingPageBean")
@ViewScoped
public class LandingPageViewBean extends AbstractViewBean {

    private static final long serialVersionUID = -2350610396008037477L;

    @PostConstruct
    public void init() {
        mock();
        super.accessor = getPropertyAccessorBean("landingPageAccessor");
        super.actions = getActionBean("landingPageActionBean");
        getActions().setParent(this);
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