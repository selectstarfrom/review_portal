package com.reviewportal.webclient.web.managedbeans.dashboard;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.reviewportal.service.dto.AbstractMemberDTO;
import com.reviewportal.service.dto.OfficialDTO;
import com.reviewportal.service.dto.ReviewWriterDTO;
import com.reviewportal.service.dto.UserDTO;
import com.reviewportal.webclient.web.managedbeans.AbstractViewBean;

@ManagedBean(name = "dashboardPageBean")
@ViewScoped
public class DashboardPageViewBean extends AbstractViewBean {

    private static final long serialVersionUID = 2189754068583227672L;

    @PostConstruct
    public void init() {
        mock();
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
    public DashboardPageAccessor getAccessor() {
        return (DashboardPageAccessor) this.accessor;
    }

    @Override
    public DashboardPageActionBean getActions() {
        return (DashboardPageActionBean) super.actions;
    }

}