package com.reviewportal.service.dto;

/**
 * @author imfroz
 *
 */
public class ProfessionDTO extends AbstractDTO {

	private String title;

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
