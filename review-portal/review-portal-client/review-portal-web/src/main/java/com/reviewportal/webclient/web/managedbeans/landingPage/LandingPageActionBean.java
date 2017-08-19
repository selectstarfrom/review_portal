package com.reviewportal.webclient.web.managedbeans.landingPage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.LoggerFactory;

import com.reviewportal.model.enums.MembershipType;
import com.reviewportal.service.dto.AbstractMemberDTO;
import com.reviewportal.service.dto.ProfessionalDTO;
import com.reviewportal.service.dto.ReviewWriterDTO;
import com.reviewportal.service.dto.UserDTO;
import com.reviewportal.service.impl.services.member.ProfessionalMemberServicesImpl;
import com.reviewportal.service.impl.services.member.ReviewWriterMemberServicesImpl;
import com.reviewportal.webclient.web.managedbeans.AbstractActionBean;

/**
 * @author imfroz
 *
 */
@ManagedBean(name = "landingPageActionBean")
@ViewScoped
public class LandingPageActionBean extends AbstractActionBean {

    private static final long serialVersionUID = 9154429268719167961L;

    public LandingPageActionBean() {
        super();
        logger = LoggerFactory.getLogger(LandingPageActionBean.class);
    }

    public String signInUser() {

        UserDTO lSignInUser = getAccessor().getSignInUser();
        String lUsername = lSignInUser.getUsername();
        String lPassword = lSignInUser.getPassword();

        UserDTO lByUsername = getAccessor().getUserServices().getByUsername(lUsername);

        if (lByUsername != null && getAccessor().getUserServices().checkPassword(lPassword, lByUsername)) {
            getSessionCache().setLoggedInUser(lByUsername);
            return "/dashboard";
        } else {
            error(getBundle().getString("landing.user-signin.error"), "user-singin-msg-error");
            return "";
        }
    }

    public void registerUser() {
        AbstractMemberDTO lSignupUser = getAccessor().getSignupUser();

        if (lSignupUser instanceof ProfessionalDTO) {
            ProfessionalMemberServicesImpl lProfessionalMemberServicesImpl = getAccessor().getProfessionalMemberService();

            lProfessionalMemberServicesImpl.save((ProfessionalDTO) lSignupUser);
        } else {
            ReviewWriterMemberServicesImpl lReviewWriterMemberService = getAccessor().getReviewWriterMemberService();

            lReviewWriterMemberService.save((ReviewWriterDTO) lSignupUser);
        }

        info(getBundle().getString("landing.user-signup.success"), "user-singup-msg-success");
        logger.info("Created new user: " + lSignupUser.getId());

        boolean lSendEmail = sendRegistrationConfirmationEmail(lSignupUser);
        if (lSendEmail) {
            logger.info("Sent email: " + lSignupUser.getId());
            info(getBundle().getString("landing.user-signup.email.confirm"), "user-singup-msg-email");
        }
    }

    private boolean sendRegistrationConfirmationEmail(AbstractMemberDTO pSignupUser) {
        return true;
    }

    public void membershipTypeActionListner() {

        String lMembershipType = getAccessor().getMembershipType();

        if (MembershipType.PROFESSIONAL.name().equals(lMembershipType)) {
            getAccessor().setSignupUser(getParent().getNewSignupProfessionalInstance());
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
