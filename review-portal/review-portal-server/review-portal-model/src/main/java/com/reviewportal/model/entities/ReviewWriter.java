package com.reviewportal.model.entities;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author imfroz
 *
 */
@Entity
@Table(name = "REVIEW_WRITER")
public class ReviewWriter extends AbstractMember {

	public ReviewWriter() {
		super();
	}

}
