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

	protected OfficialDTO reviewAbout;

	protected Long views;

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

	public OfficialDTO getReviewAbout() {
		return reviewAbout;
	}

	public void setReviewAbout(OfficialDTO reviewAbout) {
		this.reviewAbout = reviewAbout;
	}


}
