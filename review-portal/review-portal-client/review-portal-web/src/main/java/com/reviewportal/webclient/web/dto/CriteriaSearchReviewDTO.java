package com.reviewportal.webclient.web.dto;

import java.util.Date;

public class CriteriaSearchReviewDTO {
    
    private String searchReviewBy;
    private String searchReviewAbout;
    private Date searchDate;
    private String searchProfession;

    public String getSearchReviewBy() {
        return searchReviewBy;
    }

    public void setSearchReviewBy(String pSearchReviewBy) {
        searchReviewBy = pSearchReviewBy;
    }

    public String getSearchReviewAbout() {
        return searchReviewAbout;
    }

    public void setSearchReviewAbout(String pSearchReviewAbout) {
        searchReviewAbout = pSearchReviewAbout;
    }

    public Date getSearchDate() {
        return searchDate;
    }

    public void setSearchDate(Date pSearchDate) {
        searchDate = pSearchDate;
    }

    public String getSearchProfession() {
        return searchProfession;
    }

    public void setSearchProfession(String pSearchProfession) {
        searchProfession = pSearchProfession;
    }

}
