package com.reviewportal.webclient.web.managedbeans.landingPage;

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
@ManagedBean(name = "landingPageBean")
@ViewScoped
@PropertyAccessor(className = LandingPageAccessor.class)
@ViewAction(className = LandingPageActionBean.class)
public class LandingPageViewBean extends AbstractViewBean {

    private static final long serialVersionUID = -8553614341511083383L;

    @PostConstruct
    public void init() {
        super.init();
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

    public AbstractMemberDTO getNewSignupProfessionalInstance() {

        ProfessionalDTO lInstance = new ProfessionalDTO();

        return lInstance;
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