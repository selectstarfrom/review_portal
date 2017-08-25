package com.reviewportal.webclient.web.managedbeans.professionals.search;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.reviewportal.service.dto.ProfessionalDTO;
import com.reviewportal.service.impl.services.member.ProfessionalMemberServicesImpl;
import com.reviewportal.webclient.web.dto.CriteriaSearchProfessionalDTO;
import com.reviewportal.webclient.web.managedbeans.AbstractMBean;
import com.reviewportal.webclient.web.managedbeans.IPropertyAccessor;

/**
 * @author imfroz
 *
 */
@ManagedBean(name = "searchProfessionalsPageAccessor")
@ViewScoped
public class SearchProfessionalsPageAccessor extends AbstractMBean implements IPropertyAccessor {

    private static final long serialVersionUID = 1816491541459222316L;

    private CriteriaSearchProfessionalDTO searchCriteria;

    private ProfessionalDTO professional;

    private List<ProfessionalDTO> professionals;

    @Autowired
    protected transient ProfessionalMemberServicesImpl professionalMemberService;

    public SearchProfessionalsPageAccessor() {
        super();
    }

    @PostConstruct
    public void init() {
        super.init();
    }

    public CriteriaSearchProfessionalDTO getSearchCriteria() {
        return searchCriteria;
    }

    public void setSearchCriteria(CriteriaSearchProfessionalDTO pSearchCriteria) {
        searchCriteria = pSearchCriteria;
    }

    public ProfessionalDTO getProfessional() {
        return professional;
    }

    public void setProfessional(ProfessionalDTO pProfessional) {
        professional = pProfessional;
    }

    public List<ProfessionalDTO> getProfessionals() {
        return professionals;
    }

    public void setProfessionals(List<ProfessionalDTO> pProfessionals) {
        professionals = pProfessionals;
    }

    public ProfessionalMemberServicesImpl getProfessionalMemberService() {
        return professionalMemberService;
    }

    public void setProfessionalMemberService(ProfessionalMemberServicesImpl pProfessionalMemberService) {
        professionalMemberService = pProfessionalMemberService;
    }

}
