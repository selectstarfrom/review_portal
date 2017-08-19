package com.reviewportal.webclient.web.managedbeans.review.write;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.slf4j.LoggerFactory;

import com.reviewportal.service.dto.OfficialDTO;
import com.reviewportal.service.impl.services.ProfessionReviewServicesImpl;
import com.reviewportal.webclient.web.managedbeans.AbstractActionBean;

/**
 * @author imfroz
 *
 */
@ManagedBean(name = "addReviewPageActionBean")
@ViewScoped
public class AddReviewPageActionBean extends AbstractActionBean {

    private static final long serialVersionUID = 5449537897967019063L;

    public AddReviewPageActionBean() {
        super();
        logger = LoggerFactory.getLogger(AddReviewPageActionBean.class);
    }

    public void saveReviewAction() {

        ProfessionReviewServicesImpl lReviewServices = getAccessor().getReviewServices();
        getAccessor().getReview().setReviewBy(getAccessor().getReviewWriter());
        lReviewServices.save(getAccessor().getReview());

        info(getMessage("review.professional.save.success"), "review-save-msg-success");
        
        getAccessor().setReview(getParent().getNewReviewInstance());

    }

    public List<OfficialDTO> autoCompleteProfessionals(String pInput) {

        List<OfficialDTO> lProfessionals = getAccessor().getEmployeeMemberService().getByNameLike(pInput);

        getAccessor().setFilteredProfessionals(lProfessionals);

        return lProfessionals;
    }

    private AddReviewPageAccessor getAccessor() {
        return getParent().getAccessor();
    }

    @SuppressWarnings("unchecked")
    @Override
    public AddReviewPageViewBean getParent() {
        return super.getParent();
    }

}
