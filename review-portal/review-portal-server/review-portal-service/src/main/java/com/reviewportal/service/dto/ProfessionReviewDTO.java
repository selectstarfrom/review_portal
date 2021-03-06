package com.reviewportal.service.dto;

/**
 * @author imfroz
 *
 */
public class ProfessionReviewDTO extends AbstractDTO {

    public ProfessionReviewDTO() {
        super();
    }

    protected String review;

    protected ReviewWriterDTO reviewBy;

    protected ProfessionalDTO reviewAbout;

    protected Long views;

    private Integer rating;

    public String getReview() {
        return review;
    }

    public void setReview(String pReview) {
        review = pReview;
    }

    public Long getViews() {
        return views;
    }

    public void setViews(Long pViews) {
        views = pViews;
    }

    public ReviewWriterDTO getReviewBy() {
        return reviewBy;
    }

    public void setReviewBy(ReviewWriterDTO reviewBy) {
        this.reviewBy = reviewBy;
    }

    public ProfessionalDTO getReviewAbout() {
        return reviewAbout;
    }

    public void setReviewAbout(ProfessionalDTO reviewAbout) {
        this.reviewAbout = reviewAbout;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer pRating) {
        rating = pRating;
    }

    @Override
    public String toString() {
        return "ProfessionReviewDTO [review=" + review + ", reviewBy=" + reviewBy + ", reviewAbout=" + reviewAbout
                + ", views=" + views + "]";
    }
}
