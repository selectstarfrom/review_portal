package com.reviewportal.webclient.web.managedbeans.landingPage;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.reviewportal.service.dto.UserDTO;
import com.reviewportal.service.impl.services.member.EmployeeMemberServicesImpl;
import com.reviewportal.webclient.web.managedbeans.AbstractMBean;
import com.reviewportal.webclient.web.managedbeans.IPropertyAccessor;

@ManagedBean(name = "landingPageAccessor")
@ViewScoped
public class LandingPageAccessor extends AbstractMBean implements IPropertyAccessor {

    private static final long serialVersionUID = -1306742840520779183L;
    private UserDTO signupUser;

    @PostConstruct
    public void init() {
         super.init();
    }

    @Autowired
    protected transient EmployeeMemberServicesImpl employeeMemberServicesImpl;

    public LandingPageAccessor() {
        super();
        System.out.println(employeeMemberServicesImpl);
    }

    public UserDTO getSignupUser() {
        return signupUser;
    }

    public void setSignupUser(UserDTO signupUser) {
        this.signupUser = signupUser;
    }

    public EmployeeMemberServicesImpl getEmployeeMemberServicesImpl() {
        return employeeMemberServicesImpl;
    }

}
