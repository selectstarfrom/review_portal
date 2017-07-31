package com.reviewportal.model.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author imfroz
 *
 */
@Entity
@Table(name = "PROFESSION_REVIEW")
public class ProfessionReview extends AbstractReview {

	public ProfessionReview() {
		super();
	}

}
