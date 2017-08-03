package com.reviewportal.service.dto;

/**
 * @author imfroz
 *
 */
public abstract class AbstractReviewDTO extends AbstractDTO {

	protected String review;

	protected AbstractMemberDTO reviewBy;

	protected AbstractMemberDTO reviewAbout;

	protected Long views;

	public AbstractReviewDTO() {
		super();
	}

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

}
