package com.reviewportal.webclient.web.managedbeans.dashboard;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;

import com.reviewportal.model.enums.MembershipType;
import com.reviewportal.service.dto.AbstractMemberDTO;
import com.reviewportal.service.dto.OfficialDTO;
import com.reviewportal.service.dto.ReviewWriterDTO;
import com.reviewportal.service.dto.UserDTO;
import com.reviewportal.service.impl.services.member.EmployeeMemberServicesImpl;
import com.reviewportal.service.impl.services.member.ReviewWriterMemberServicesImpl;
import com.reviewportal.webclient.web.managedbeans.AbstractActionBean;

@ManagedBean(name = "dashboardPageActionBean")
@ViewScoped
public class DashboardPageActionBean extends AbstractActionBean {

	private static final long serialVersionUID = -3705215744787931486L;

	public DashboardPageActionBean() {
		super();
		logger = LoggerFactory.getLogger(DashboardPageActionBean.class);
	}

	public String signInUser() {

		UserDTO lSignInUser = getAccessor().getSignInUser();
		String lUsername = lSignInUser.getUsername();
		String lPassword = lSignInUser.getPassword();
		if (StringUtils.equalsAnyIgnoreCase("demo", lUsername) && StringUtils.equalsAnyIgnoreCase("demo", lPassword)) {
			return "/dashboard";
		} else {
			error(getBundle().getString("landing.user-signin.error"), "user-singin-msg-error");
			return "";
		}
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
			getAccessor().setSignupUser(getParent().getNewSignupOfficialInstance());
		} else {
			getAccessor().setSignupUser(getParent().getNewSignupReviewWriterInstance());
		}
	}

	private DashboardPageAccessor getAccessor() {
		return getParent().getAccessor();
	}

	@SuppressWarnings("unchecked")
	@Override
	public DashboardPageViewBean getParent() {
		return super.getParent();
	}

}
