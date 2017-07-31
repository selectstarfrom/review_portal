package com.reviewportal.model.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author imfroz
 *
 */
@Entity
@Table(name = "OFFICIAL")
public class Official extends AbstractMember {

	@ManyToOne
	private Profession profession;

	public Official() {
		super();
	}

	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession pProfession) {
		profession = pProfession;
	}

}
