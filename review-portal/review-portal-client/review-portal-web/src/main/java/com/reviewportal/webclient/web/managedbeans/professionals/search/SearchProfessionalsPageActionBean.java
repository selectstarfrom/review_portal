package com.reviewportal.webclient.web.managedbeans.professionals.search;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;

import com.reviewportal.model.enums.Gender;
import com.reviewportal.service.dto.ProfessionalDTO;
import com.reviewportal.service.impl.services.member.ProfessionalMemberServicesImpl;
import com.reviewportal.webclient.web.dto.CriteriaSearchProfessionalDTO;
import com.reviewportal.webclient.web.managedbeans.AbstractActionBean;

/**
 * @author imfroz
 *
 */
@ManagedBean(name = "searchProfessionalsPageActionBean")
@ViewScoped
public class SearchProfessionalsPageActionBean extends AbstractActionBean {

    private static final long serialVersionUID = 7645617834371111001L;

    public SearchProfessionalsPageActionBean() {
        super();
        logger = LoggerFactory.getLogger(SearchProfessionalsPageActionBean.class);
    }

    public void searchAction() {

        CriteriaSearchProfessionalDTO lSearchCriteria = getAccessor().getSearchCriteria();

        ProfessionalMemberServicesImpl lServices = getAccessor().getProfessionalMemberService();
        ProfessionalDTO lProfessionalExample = getParent().getNewProfessionalInstance();

        String lSearchGender = lSearchCriteria.getSearchGender();
        String lSearchName = lSearchCriteria.getSearchName();
        String lSearchProfession = lSearchCriteria.getSearchProfessionTitle();

        String lSearchRatingMax = lSearchCriteria.getSearchRatingMax();
        String lSearchRatingMin = lSearchCriteria.getSearchRatingMin();

        String lSearchCity = lSearchCriteria.getSearchCity();
        String lSearchState = lSearchCriteria.getSearchState();
        String lSearchZip = lSearchCriteria.getSearchZip();

        String lName = StringUtils.isEmpty(lSearchName) ? null : lSearchName;
        lProfessionalExample.setName(lName);

        String lTitle = StringUtils.isEmpty(lSearchProfession) ? null : lSearchProfession;
        lProfessionalExample.getProfession().setTitle(lTitle);

        Gender lGender = StringUtils.isEmpty(lSearchGender) ? null : Gender.valueOf(lSearchGender);
        lProfessionalExample.setGender(lGender);

        String lCity = StringUtils.isEmpty(lSearchCity) ? null : lSearchCity;
        lProfessionalExample.getAddress().setCity(lCity);

        String lState = StringUtils.isEmpty(lSearchState) ? null : lSearchState;
        lProfessionalExample.getAddress().setState(lState);

        String lZip = StringUtils.isEmpty(lSearchZip) ? null : lSearchZip;
        lProfessionalExample.getAddress().setZip(lZip);

        List<ProfessionalDTO> lProfessionReviews = lServices.getByExample(lProfessionalExample);

        getAccessor().setProfessionals(lProfessionReviews);
    }

    private SearchProfessionalsPageAccessor getAccessor() {
        return getParent().getAccessor();
    }

    @SuppressWarnings("unchecked")
    @Override
    public SearchProfessionalsPageViewBean getParent() {
        return super.getParent();
    }

}
