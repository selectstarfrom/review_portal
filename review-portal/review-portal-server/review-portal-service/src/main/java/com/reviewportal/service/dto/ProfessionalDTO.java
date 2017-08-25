package com.reviewportal.service.dto;

import java.util.List;

/**
 * @author imfroz
 *
 */
public class ProfessionalDTO extends AbstractMemberDTO {

    private ProfessionDTO profession;

    private List<ProfessionReviewDTO> reviews;

    private Integer rating;

    private Long reviewCount;

    public ProfessionalDTO() {
        super();
        profession = new ProfessionDTO();
    }

    public ProfessionDTO getProfession() {
        return profession;
    }

    public void setProfession(ProfessionDTO pProfession) {
        profession = pProfession;
    }

    @Override
    public String toString() {
        return "ProfessionalDTO [profession=" + profession + "]";
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer pRating) {
        rating = pRating;
    }

    public List<ProfessionReviewDTO> getReviews() {
        return reviews;
    }

    public void setReviews(List<ProfessionReviewDTO> pReviews) {
        reviews = pReviews;
    }

    public Long getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Long pReviewCount) {
        reviewCount = pReviewCount;
    }

}
