package com.reviewportal.model.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author imfroz
 *
 */
@Entity
@Table(name = "PROFESSION_REVIEW")
public class ProfessionReview extends AbstractEntity {

	private String review;

	@ManyToOne
	private ReviewWriter reviewBy;

	@ManyToOne
	private Official reviewAbout;

	private Long views;

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public ReviewWriter getReviewBy() {
		return reviewBy;
	}

	public void setReviewBy(ReviewWriter reviewBy) {
		this.reviewBy = reviewBy;
	}

	public Official getReviewAbout() {
		return reviewAbout;
	}

	public void setReviewAbout(Official reviewAbout) {
		this.reviewAbout = reviewAbout;
	}

	public Long getViews() {
		return views;
	}

	public void setViews(Long views) {
		this.views = views;
	}

}
