package com.reviewportal.webclient.web.managedbeans.landingPage;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.reviewportal.service.dto.AbstractMemberDTO;
import com.reviewportal.service.dto.ProfessionalDTO;
import com.reviewportal.service.dto.ReviewWriterDTO;
import com.reviewportal.service.dto.UserDTO;
import com.reviewportal.service.impl.services.UserServicesImpl;
import com.reviewportal.service.impl.services.member.ProfessionalMemberServicesImpl;
import com.reviewportal.service.impl.services.member.ReviewWriterMemberServicesImpl;
import com.reviewportal.webclient.web.managedbeans.AbstractMBean;
import com.reviewportal.webclient.web.managedbeans.IPropertyAccessor;

/**
 * @author imfroz
 *
 */
@ManagedBean(name = "landingPageAccessor")
@ViewScoped
public class LandingPageAccessor extends AbstractMBean implements IPropertyAccessor {

    private static final long serialVersionUID = 6503910852856630182L;

    private String repeatPassword;
    private String membershipType;

    private AbstractMemberDTO signupUser;
    private UserDTO signInUser;

    private ProfessionalDTO signupProfessional;
    private ReviewWriterDTO signupReviewWriter;

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

    public LandingPageAccessor() {
        super();
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String pMembershipType) {
        membershipType = pMembershipType;
    }

    public AbstractMemberDTO getSignupUser() {
        return signupUser;
    }

    public void setSignupUser(AbstractMemberDTO pSignupUser) {
        signupUser = pSignupUser;
    }

    public ProfessionalDTO getSignupProfessional() {
        return signupProfessional;
    }

    public void setSignupProfessional(ProfessionalDTO pSignupProfessional) {
        signupProfessional = pSignupProfessional;
    }

    public ReviewWriterDTO getSignupReviewWriter() {
        return signupReviewWriter;
    }

    public void setSignupReviewWriter(ReviewWriterDTO pSignupReviewWriter) {
        signupReviewWriter = pSignupReviewWriter;
    }

    public ProfessionalMemberServicesImpl getProfessionalMemberService() {
        return professionalMemberService;
    }

    public ReviewWriterMemberServicesImpl getReviewWriterMemberService() {
        return reviewWriterMemberService;
    }

    public String getRepeatPassword() {
        return repeatPassword;
    }

    public void setRepeatPassword(String pRepeatPassword) {
        repeatPassword = pRepeatPassword;
    }

    public UserDTO getSignInUser() {
        return signInUser;
    }

    public void setSignInUser(UserDTO signInUser) {
        this.signInUser = signInUser;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public UserServicesImpl getUserServices() {
        return userServices;
    }
    
    

}
