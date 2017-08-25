package com.reviewportal.webclient.web.managedbeans.professionals.search;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.reviewportal.service.dto.ProfessionalDTO;
import com.reviewportal.webclient.web.core.PropertyAccessor;
import com.reviewportal.webclient.web.core.ViewAction;
import com.reviewportal.webclient.web.dto.CriteriaSearchProfessionalDTO;
import com.reviewportal.webclient.web.managedbeans.AbstractViewBean;

/**
 * @author imfroz
 *
 */
@ManagedBean(name = "searchProfessionalsPageViewBean")
@ViewScoped
@PropertyAccessor(className = SearchProfessionalsPageAccessor.class)
@ViewAction(className = SearchProfessionalsPageActionBean.class)
public class SearchProfessionalsPageViewBean extends AbstractViewBean {

    private static final long serialVersionUID = 4036750616723480143L;

    @PostConstruct
    public void init() {
        super.init();
        getAccessor().setSearchCriteria(getNewSearchCriteriaInstance());
    }

    public CriteriaSearchProfessionalDTO getNewSearchCriteriaInstance() {
        CriteriaSearchProfessionalDTO lInstance = new CriteriaSearchProfessionalDTO();
        return lInstance;
    }

    public ProfessionalDTO getNewProfessionalInstance() {
        ProfessionalDTO lInstance = new ProfessionalDTO();
        return lInstance;
    }

    @Override
    public SearchProfessionalsPageAccessor getAccessor() {
        return (SearchProfessionalsPageAccessor) this.accessor;
    }

    @Override
    public SearchProfessionalsPageActionBean getActions() {
        return (SearchProfessionalsPageActionBean) super.actions;
    }

}