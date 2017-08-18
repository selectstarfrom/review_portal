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
    private List<SelectItem> professions;

    private UserDTO loggedInUser;

    @PostConstruct
    public void init() {
        super.init();

        try {
            UserDTO lDemoUser = userServices.getByUsername("demo_prof");
            setLoggedInUser(lDemoUser);
        } catch (Exception pException) {

        }

        membershipTypes = new ArrayList<>();
        for (MembershipType lEnum : MembershipType.values()) {
            membershipTypes.add(new SelectItem(lEnum.name(), lEnum.getLabel()));
        }

        genders = new ArrayList<>();
        for (Gender lEnum : Gender.values()) {
            genders.add(new SelectItem(lEnum.name(), lEnum.getLabel()));
        }

        List<String> lAllProfessions = masterDataService.getAllProfessions();
        professions = new ArrayList<>();
        for (String lValueObject : lAllProfessions) {
            professions.add(new SelectItem(lValueObject, lValueObject));
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

    public List<SelectItem> getProfessions() {
        return professions;
    }

    public void setProfessions(List<SelectItem> pProfessions) {
        professions = pProfessions;
    }

    public UserDTO getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(UserDTO pLoggedInUser) {
        loggedInUser = pLoggedInUser;
    }

}