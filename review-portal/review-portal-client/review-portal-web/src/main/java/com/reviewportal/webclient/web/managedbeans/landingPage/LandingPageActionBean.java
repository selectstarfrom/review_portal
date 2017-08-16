package com.reviewportal.webclient.web.managedbeans.landingPage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.LoggerFactory;

import com.reviewportal.model.enums.MembershipType;
import com.reviewportal.service.dto.AbstractMemberDTO;
import com.reviewportal.service.dto.OfficialDTO;
import com.reviewportal.service.dto.ReviewWriterDTO;
import com.reviewportal.service.impl.services.member.EmployeeMemberServicesImpl;
import com.reviewportal.service.impl.services.member.ReviewWriterMemberServicesImpl;
import com.reviewportal.webclient.web.managedbeans.AbstractActionBean;

@ManagedBean(name = "landingPageActionBean")
@ViewScoped
public class LandingPageActionBean extends AbstractActionBean {

    private static final long serialVersionUID = -3705215744787931486L;

    public LandingPageActionBean() {
        super();
        logger = LoggerFactory.getLogger(LandingPageActionBean.class);
    }

    public void registerUser() {
        AbstractMemberDTO lSignupUser = getAccessor().getSignupUser();

        if (lSignupUser instanceof OfficialDTO) {
            EmployeeMemberServicesImpl lEmployeeMemberServicesImpl = getAccessor().getEmployeeMemberService();

            lEmployeeMemberServicesImpl.save((OfficialDTO) lSignupUser);
        } else {
            ReviewWriterMemberServicesImpl lReviewWriterMemberService = getAccessor().getReviewWriterMemberService();

            lReviewWriterMemberService.save((ReviewWriterDTO) lSignupUser);
        }

        logger.info("Created new user: " + lSignupUser.getId());

        boolean lSendEmail = sendRegistrationConfirmationEmail(lSignupUser);
        if (lSendEmail)
            logger.info("Sent email: " + lSignupUser.getId());
    }

    private boolean sendRegistrationConfirmationEmail(AbstractMemberDTO pSignupUser) {
        return false;
    }

    public void membershipTypeActionListner() {

        String lMembershipType = getAccessor().getMembershipType();

        if (MembershipType.PROFESSIONAL.name().equals(lMembershipType)) {
            getAccessor().setSignupUser(getParent().getNewSignupOfficialInstance());
        } else {
            getAccessor().setSignupUser(getParent().getNewSignupReviewWriterInstance());
        }
    }

    private LandingPageAccessor getAccessor() {
        return getParent().getAccessor();
    }

    @SuppressWarnings("unchecked")
    @Override
    public LandingPageViewBean getParent() {
        return super.getParent();
    }
}
