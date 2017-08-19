package com.reviewportal.webclient.web.managedbeans.review.write;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.springframework.beans.factory.annotation.Autowired;

import com.reviewportal.service.dto.ProfessionalDTO;
import com.reviewportal.service.dto.ProfessionReviewDTO;
import com.reviewportal.service.dto.ReviewWriterDTO;
import com.reviewportal.service.impl.services.ProfessionReviewServicesImpl;
import com.reviewportal.service.impl.services.UserServicesImpl;
import com.reviewportal.service.impl.services.member.ProfessionalMemberServicesImpl;
import com.reviewportal.service.impl.services.member.ReviewWriterMemberServicesImpl;
import com.reviewportal.webclient.web.managedbeans.AbstractMBean;
import com.reviewportal.webclient.web.managedbeans.IPropertyAccessor;

/**
 * @author imfroz
 *
 */
@ManagedBean(name = "addReviewPageAccessor")
@ViewScoped
public class AddReviewPageAccessor extends AbstractMBean implements IPropertyAccessor {

    private static final long serialVersionUID = 6677682346756378610L;

    private ReviewWriterDTO reviewWriter;

    private ProfessionReviewDTO review;

    private List<ProfessionalDTO> filteredProfessionals;

    @Autowired
    protected transient ProfessionalMemberServicesImpl professionalMemberService;

    @Autowired
    protected transient ReviewWriterMemberServicesImpl reviewWriterMemberService;

    @Autowired
    protected transient ProfessionReviewServicesImpl reviewServices;

    @Autowired
    protected transient UserServicesImpl userServices;

    public AddReviewPageAccessor() {
        super();
    }

    @PostConstruct
    public void init() {
        super.init();
    }

    public ReviewWriterDTO getReviewWriter() {
        return reviewWriter;
    }

    public void setReviewWriter(ReviewWriterDTO pReviewWriter) {
        reviewWriter = pReviewWriter;
    }

    public ProfessionReviewDTO getReview() {
        return review;
    }

    public void setReview(ProfessionReviewDTO pReview) {
        review = pReview;
    }

    public List<ProfessionalDTO> getFilteredProfessionals() {
        return filteredProfessionals;
    }

    public void setFilteredProfessionals(List<ProfessionalDTO> pFilteredProfessionals) {
        filteredProfessionals = pFilteredProfessionals;
    }

    public ProfessionalMemberServicesImpl getProfessionalMemberService() {
        return professionalMemberService;
    }

    public void setProfessionalMemberService(ProfessionalMemberServicesImpl pProfessionalMemberService) {
        professionalMemberService = pProfessionalMemberService;
    }

    public ReviewWriterMemberServicesImpl getReviewWriterMemberService() {
        return reviewWriterMemberService;
    }

    public void setReviewWriterMemberService(ReviewWriterMemberServicesImpl pReviewWriterMemberService) {
        reviewWriterMemberService = pReviewWriterMemberService;
    }

    public UserServicesImpl getUserServices() {
        return userServices;
    }

    public void setUserServices(UserServicesImpl pUserServices) {
        userServices = pUserServices;
    }

    public ProfessionReviewServicesImpl getReviewServices() {
        return reviewServices;
    }

    public void setReviewServices(ProfessionReviewServicesImpl pReviewServices) {
        reviewServices = pReviewServices;
    }

}
