package com.reviewportal.service.services;

import com.reviewportal.model.entities.AbstractMember;
import com.reviewportal.service.dto.AbstractMemberDTO;

public interface IMemberServices<E extends AbstractMember, D extends AbstractMemberDTO> extends ICommonService<E, D> {

}
