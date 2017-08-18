package com.reviewportal.webclient.web.managedbeans;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.reviewportal.service.dto.UserDTO;
import com.reviewportal.service.impl.services.MasterDataServices;
import com.reviewportal.service.impl.services.UserServicesImpl;

/**
 * @author imfroz
 *
 */
@ManagedBean(name = "sessionCache")
@SessionScoped
public class SessionCacheMBean extends AbstractBaseBean {

    private static final long serialVersionUID = -8394090019785741012L;

    @Autowired
    protected transient MasterDataServices masterDataService;

    @Autowired
    protected transient UserServicesImpl userServices;

    private UserDTO loggedInUser;

    @PostConstruct
    public void init() {
        super.init();

    }

    private void testUser() {
        try {
            UserDTO lDemoUser = userServices.getByUsername("demo_prof");
            // setLoggedInUser(lDemoUser);
        } catch (Exception pException) {

        }
    }

    public UserDTO getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(UserDTO pLoggedInUser) {
        loggedInUser = pLoggedInUser;
    }

}