package com.reviewportal.webclient.web.managedbeans.dashboard;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.reviewportal.service.dto.AbstractMemberDTO;
import com.reviewportal.service.dto.OfficialDTO;
import com.reviewportal.service.dto.ReviewWriterDTO;
import com.reviewportal.service.dto.UserDTO;
import com.reviewportal.service.impl.services.member.EmployeeMemberServicesImpl;
import com.reviewportal.service.impl.services.member.ReviewWriterMemberServicesImpl;
import com.reviewportal.webclient.web.managedbeans.AbstractMBean;
import com.reviewportal.webclient.web.managedbeans.IPropertyAccessor;

@ManagedBean(name = "dashboardPageAccessor")
@ViewScoped
public class DashboardPageAccessor extends AbstractMBean implements IPropertyAccessor {

    private static final long serialVersionUID = -1306742840520779183L;

    private String repeatPassword;
    private String membershipType;

    private AbstractMemberDTO signupUser;
    private UserDTO signInUser;

    private OfficialDTO signupOfficial;
    private ReviewWriterDTO signupReviewWriter;

    @PostConstruct
    public void init() {
        super.init();
    }

    @Autowired
    protected transient EmployeeMemberServicesImpl employeeMemberService;
    @Autowired
    protected transient ReviewWriterMemberServicesImpl reviewWriterMemberService;

    public DashboardPageAccessor() {
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

    public OfficialDTO getSignupOfficial() {
        return signupOfficial;
    }

    public void setSignupOfficial(OfficialDTO pSignupOfficial) {
        signupOfficial = pSignupOfficial;
    }

    public ReviewWriterDTO getSignupReviewWriter() {
        return signupReviewWriter;
    }

    public void setSignupReviewWriter(ReviewWriterDTO pSignupReviewWriter) {
        signupReviewWriter = pSignupReviewWriter;
    }

    public EmployeeMemberServicesImpl getEmployeeMemberService() {
        return employeeMemberService;
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

}
