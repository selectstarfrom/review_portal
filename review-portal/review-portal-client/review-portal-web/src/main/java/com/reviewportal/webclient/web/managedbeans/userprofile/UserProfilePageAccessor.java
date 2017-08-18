package com.reviewportal.webclient.web.managedbeans.userprofile;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.StreamedContent;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.reviewportal.model.enums.MembershipType;
import com.reviewportal.service.dto.AbstractMemberDTO;
import com.reviewportal.service.impl.services.member.EmployeeMemberServicesImpl;
import com.reviewportal.service.impl.services.member.ReviewWriterMemberServicesImpl;
import com.reviewportal.webclient.web.managedbeans.AbstractMBean;
import com.reviewportal.webclient.web.managedbeans.IPropertyAccessor;

/**
 * @author imfroz
 *
 */
@ManagedBean(name = "userProfilePageAccessor")
@ViewScoped
public class UserProfilePageAccessor extends AbstractMBean implements IPropertyAccessor {

    private static final long serialVersionUID = -3143040833117419451L;

    private StreamedContent graphicText;

    private String membershipType;

    private AbstractMemberDTO member;

    private boolean editProfileEnabled;

    @Autowired
    protected transient EmployeeMemberServicesImpl employeeMemberService;

    @Autowired
    protected transient ReviewWriterMemberServicesImpl reviewWriterMemberService;

    public UserProfilePageAccessor() {
        super();
        logger = LoggerFactory.getLogger(UserProfilePageAccessor.class);
    }

    @PostConstruct
    public void init() {
        super.init();
    }

    public StreamedContent getGraphicText() {
        return graphicText;
    }

    public void setGraphicText(StreamedContent pGraphicText) {
        graphicText = pGraphicText;
    }

    public String getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(String pMembershipType) {
        membershipType = pMembershipType;
    }

    public AbstractMemberDTO getMember() {
        return member;
    }

    public void setMember(AbstractMemberDTO pMember) {
        member = pMember;
    }

    public EmployeeMemberServicesImpl getEmployeeMemberService() {
        return employeeMemberService;
    }

    public void setEmployeeMemberService(EmployeeMemberServicesImpl pEmployeeMemberService) {
        employeeMemberService = pEmployeeMemberService;
    }

    public ReviewWriterMemberServicesImpl getReviewWriterMemberService() {
        return reviewWriterMemberService;
    }

    public void setReviewWriterMemberService(ReviewWriterMemberServicesImpl pReviewWriterMemberService) {
        reviewWriterMemberService = pReviewWriterMemberService;
    }

    public boolean isEditProfileEnabled() {
        return editProfileEnabled;
    }
    
    public boolean isRenderAutoCompleteProfessions() {
        return isEditProfileEnabled() && getMember().getMembershipType().equals(MembershipType.PROFESSIONAL.name());
    }

    public void setEditProfileEnabled(boolean pEditProfileEnabled) {
        editProfileEnabled = pEditProfileEnabled;
    }
    

}
