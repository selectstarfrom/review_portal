package com.reviewportal.webclient.web.managedbeans.userprofile;

import java.util.List;
import java.util.stream.Collectors;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.ActionEvent;
import javax.faces.model.SelectItem;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;

import com.reviewportal.service.dto.AbstractMemberDTO;
import com.reviewportal.service.dto.ProfessionalDTO;
import com.reviewportal.service.dto.ReviewWriterDTO;
import com.reviewportal.service.impl.services.member.EmployeeMemberServicesImpl;
import com.reviewportal.service.impl.services.member.ReviewWriterMemberServicesImpl;
import com.reviewportal.webclient.web.managedbeans.AbstractActionBean;
import com.reviewportal.webclient.web.managedbeans.ApplicationCacheMBean;

/**
 * @author imfroz
 *
 */
@ManagedBean(name = "userProfileActionBean")
@ViewScoped
public class UserProfileActionBean extends AbstractActionBean {

    private static final long serialVersionUID = 8077901845468639759L;

    public UserProfileActionBean() {
        super();
        logger = LoggerFactory.getLogger(UserProfileActionBean.class);
    }

    private UserProfilePageAccessor getAccessor() {
        return getParent().getAccessor();
    }

    @SuppressWarnings("unchecked")
    @Override
    public UserProfilePageViewBean getParent() {
        return super.getParent();
    }

    public void makeEditableAction() {
        getAccessor().setEditProfileEnabled(true);
    }

    public void makeNonEditableAction() {
        getAccessor().setEditProfileEnabled(false);
    }

    public void saveProfileActionListener(ActionEvent pActionEvent) {
        AbstractMemberDTO lMember = getAccessor().getMember();
        if (lMember instanceof ProfessionalDTO) {
            EmployeeMemberServicesImpl lEmployeeMemberService = getAccessor().getEmployeeMemberService();
            ProfessionalDTO lProfessional = (ProfessionalDTO) getAccessor().getMember();
            lEmployeeMemberService.update(lProfessional);
        } else if (lMember instanceof ReviewWriterDTO) {
            ReviewWriterMemberServicesImpl lReviewWriterMemberService = getAccessor().getReviewWriterMemberService();
            ReviewWriterDTO lReviewWriterDTO = (ReviewWriterDTO) getAccessor().getMember();
            lReviewWriterMemberService.update(lReviewWriterDTO);
        }

        info(getMessage("profile.save.success"), "profile-save-msg-success");
        makeNonEditableAction();
    }

}
