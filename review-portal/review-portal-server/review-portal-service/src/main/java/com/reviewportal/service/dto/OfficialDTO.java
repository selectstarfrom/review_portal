package com.reviewportal.service.dto;

import javax.persistence.ManyToOne;

/**
 * @author imfroz
 *
 */
public class OfficialDTO extends AbstractMemberDTO {

	@ManyToOne
	private ProfessionDTO profession;

	public OfficialDTO() {
		super();
	}

	public ProfessionDTO getProfession() {
		return profession;
	}

	public void setProfession(ProfessionDTO pProfession) {
		profession = pProfession;
	}

}
