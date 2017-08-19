package com.reviewportal.webclient.web.managedbeans.review.search;

import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.LoggerFactory;

import com.reviewportal.service.dto.ProfessionReviewDTO;
import com.reviewportal.service.dto.ProfessionalDTO;
import com.reviewportal.service.impl.services.ProfessionReviewServicesImpl;
import com.reviewportal.webclient.web.dto.CriteriaSearchReviewDTO;
import com.reviewportal.webclient.web.managedbeans.AbstractActionBean;

/**
 * @author imfroz
 *
 */
@ManagedBean(name = "searchReviewPageActionBean")
@ViewScoped
public class SearchReviewPageActionBean extends AbstractActionBean {

    private static final long serialVersionUID = -7314833734293782933L;

    public SearchReviewPageActionBean() {
        super();
        logger = LoggerFactory.getLogger(SearchReviewPageActionBean.class);
    }

    public List<ProfessionalDTO> autoCompleteProfessionals(String pInput) {

        List<ProfessionalDTO> lProfessionals = getAccessor().getProfessionalMemberService().getByNameLike(pInput);

        getAccessor().setFilteredProfessionals(lProfessionals);

        return lProfessionals;
    }

    public void searchveReviewAction() {

        CriteriaSearchReviewDTO lSearchCriteria = getAccessor().getSearchCriteria();

        ProfessionReviewServicesImpl lReviewServices = getAccessor().getReviewServices();
        ProfessionReviewDTO lProfessionReviewExample = getParent().getNewReviewInstance();

        Date lSearchDate = lSearchCriteria.getSearchDate();
        String lSearchReviewBy = lSearchCriteria.getSearchReviewBy();
        String lSearchProfession = lSearchCriteria.getSearchProfession();
        String lSearchReviewAbout = lSearchCriteria.getSearchReviewAbout();

        lProfessionReviewExample.setModifiedDate(lSearchDate);

        String lName = StringUtils.isEmpty(lSearchReviewBy) ? null : lSearchReviewBy;
        lProfessionReviewExample.getReviewBy().setName(lName);

        String lTitle = StringUtils.isEmpty(lSearchProfession) ? null : lSearchProfession;
        lProfessionReviewExample.getReviewAbout().getProfession().setTitle(lTitle);

        String lReviewAboutName = StringUtils.isEmpty(lSearchReviewAbout) ? null : lSearchReviewAbout;
        lProfessionReviewExample.getReviewAbout().setName(lReviewAboutName);
        
        lProfessionReviewExample.getReviewBy().setMembershipType(null);
        lProfessionReviewExample.getReviewAbout().setMembershipType(null);
        lProfessionReviewExample.getReviewBy().setUser(null);
        lProfessionReviewExample.getReviewAbout().setUser(null);

        List<ProfessionReviewDTO> lProfessionReviews = lReviewServices.getByExample(lProfessionReviewExample);

        getAccessor().setReviews(lProfessionReviews);
    }

    private SearchReviewPageAccessor getAccessor() {
        return getParent().getAccessor();
    }

    @SuppressWarnings("unchecked")
    @Override
    public SearchReviewPageViewBean getParent() {
        return super.getParent();
    }

}
