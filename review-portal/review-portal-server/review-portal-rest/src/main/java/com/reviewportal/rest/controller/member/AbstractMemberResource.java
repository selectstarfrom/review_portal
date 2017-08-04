package com.reviewportal.rest.controller.member;

import com.reviewportal.model.entities.AbstractMember;
import com.reviewportal.rest.controller.AbstractResource;
import com.reviewportal.service.dto.AbstractMemberDTO;
import com.reviewportal.service.services.ICommonService;

public abstract class AbstractMemberResource<E extends AbstractMember, D extends AbstractMemberDTO>
		extends AbstractResource<E, D> {

	public AbstractMemberResource() {
		super();
	}

	public AbstractMemberResource(ICommonService<E, D> pService) {
		super(pService);
	}

}