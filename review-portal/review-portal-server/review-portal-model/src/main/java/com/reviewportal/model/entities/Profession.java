package com.reviewportal.model.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author imfroz
 *
 */
@Entity
@Table(name = "PROFESSION")
public class Profession extends AbstractEntity {

	@Column(unique = true, nullable = false)
	private String title;

	@Column(length=200)
	private String description;

	public String getTitle() {
		return title;
	}

	public void setTitle(String pTitle) {
		title = pTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String pDescription) {
		description = pDescription;
	}

}
