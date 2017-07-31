package com.reviewportal.model.entities;

import javax.persistence.ManyToOne;

/**
 * @author imfroz
 *
 */
public abstract class AbstractReview extends AbstractEntity {

	private String review;

	@ManyToOne
	private AbstractMember reviewBy;

	@ManyToOne
	private AbstractMember reviewAbout;

	private Long views;

	public AbstractReview() {
		super();
	}

	public String getReview() {
		return review;
	}

	public void setReview(String pReview) {
		review = pReview;
	}

	public AbstractMember getReviewBy() {
		return reviewBy;
	}

	public void setReviewBy(AbstractMember pReviewBy) {
		reviewBy = pReviewBy;
	}

	public AbstractMember getReviewAbout() {
		return reviewAbout;
	}

	public void setReviewAbout(AbstractMember pReviewAbout) {
		reviewAbout = pReviewAbout;
	}

	public Long getViews() {
		return views;
	}

	public void setViews(Long pViews) {
		views = pViews;
	}

}
