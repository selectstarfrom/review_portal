package com.reviewportal.webclient.web.managedbeans.review.write;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.reviewportal.service.dto.AbstractMemberDTO;
import com.reviewportal.service.dto.OfficialDTO;
import com.reviewportal.service.dto.ProfessionReviewDTO;
import com.reviewportal.service.dto.ReviewWriterDTO;
import com.reviewportal.service.dto.UserDTO;
import com.reviewportal.webclient.web.core.PropertyAccessor;
import com.reviewportal.webclient.web.core.ViewAction;
import com.reviewportal.webclient.web.managedbeans.AbstractViewBean;

/**
 * @author imfroz
 *
 */
@ManagedBean(name = "addReviewPageViewBean")
@ViewScoped
@PropertyAccessor(className = AddReviewPageAccessor.class)
@ViewAction(className = AddReviewPageActionBean.class)
public class AddReviewPageViewBean extends AbstractViewBean {

    private static final long serialVersionUID = 3138228684490172667L;

    @PostConstruct
    public void init() {
        super.init();
        mock();

        UserDTO lLoggedInUser = getLoggedInUser();
        ReviewWriterDTO lReviewWriterDTO = getAccessor().getReviewWriterMemberService()
                .getByUserId(lLoggedInUser.getId());
        getAccessor().setReviewWriter(lReviewWriterDTO);
        getAccessor().setReview(getNewReviewInstance());
    }

    public ProfessionReviewDTO getNewReviewInstance() {
        ProfessionReviewDTO lInstance = new ProfessionReviewDTO();
        lInstance.setReviewAbout(new OfficialDTO());
        return lInstance;
    }

    public AbstractMemberDTO getNewSignupOfficialInstance() {
        OfficialDTO lInstance = new OfficialDTO();
        return lInstance;
    }

    private void mock() {

    }

    @Override
    public AddReviewPageAccessor getAccessor() {
        return (AddReviewPageAccessor) this.accessor;
    }

    @Override
    public AddReviewPageActionBean getActions() {
        return (AddReviewPageActionBean) super.actions;
    }

}