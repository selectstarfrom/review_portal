package com.reviewportal.webclient.web.managedbeans;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import com.reviewportal.service.dto.ProfessionReviewDTO;

@ManagedBean(name = "reviewProfessionalsMBean")
public class ReviewProfessionalsMBean extends AbstractMBean {

    private static final long serialVersionUID = -2350610396008037477L;

    private List<ProfessionReviewDTO> searchResult;

    @PostConstruct
    public void init() {

    }

    public List<ProfessionReviewDTO> getSearchResult() {
        return searchResult;
    }

    public void setSearchResult(List<ProfessionReviewDTO> pSearchResult) {
        searchResult = pSearchResult;
    }

}