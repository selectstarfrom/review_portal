package com.reviewportal.webclient.web.managedbeans;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import org.springframework.beans.factory.annotation.Autowired;

import com.reviewportal.model.enums.Gender;
import com.reviewportal.model.enums.MembershipType;
import com.reviewportal.service.dto.UserDTO;
import com.reviewportal.service.impl.services.MasterDataServices;
import com.reviewportal.service.impl.services.UserServicesImpl;

/**
 * @author imfroz
 *
 */
@ManagedBean(name = "appCache")
@ApplicationScoped
public class ApplicationCacheMBean extends AbstractBaseBean {

    private static final long serialVersionUID = 8718218500596390833L;

    @Autowired
    protected transient MasterDataServices masterDataService;

    @Autowired
    protected transient UserServicesImpl userServices;

    private List<SelectItem> membershipTypes;
    private List<SelectItem> genders;
    private List<String> professionsTitles;
    private List<SelectItem> professions;

    // private UserDTO loggedInUser;

    @PostConstruct
    public void init() {
        super.init();

        membershipTypes = new ArrayList<>();
        for (MembershipType lEnum : MembershipType.values()) {
            membershipTypes.add(new SelectItem(lEnum.name(), lEnum.getLabel()));
        }

        genders = new ArrayList<>();
        for (Gender lEnum : Gender.values()) {
            genders.add(new SelectItem(lEnum.name(), lEnum.getLabel()));
        }

        List<String> lAllProfessionTitles = masterDataService.getAllProfessionTitles();
        professionsTitles = lAllProfessionTitles;

        List<String[]> lAllProfessions = masterDataService.getAllProfessions();
        professions = new ArrayList<>();
        for (Object[] lObjects : lAllProfessions) {
            professions.add(new SelectItem((String)lObjects[0], (String)lObjects[1]));
        }
    }

    private void testUser() {
        try {
            UserDTO lDemoUser = userServices.getByUsername("demo_prof");
            // setLoggedInUser(lDemoUser);
        } catch (Exception pException) {

        }
    }

    public List<SelectItem> getMembershipTypes() {
        return membershipTypes;
    }

    public void setMembershipTypes(List<SelectItem> pMembershipTypes) {
        membershipTypes = pMembershipTypes;
    }

    public List<SelectItem> getGenders() {
        return genders;
    }

    public void setGenders(List<SelectItem> pGenders) {
        genders = pGenders;
    }

    public List<String> getProfessionsTitles() {
        return professionsTitles;
    }

    public List<SelectItem> getProfessions() {
        return professions;
    }

}