package com.reviewportal.service.impl.services.member;

import org.springframework.beans.factory.annotation.Autowired;

import com.reviewportal.dao.dao.IMemberDao;
import com.reviewportal.model.entities.AbstractMember;
import com.reviewportal.service.dto.AbstractMemberDTO;
import com.reviewportal.service.impl.converter.AbstractEntityTOConverter;
import com.reviewportal.service.impl.services.AbstractCommonServiceImpl;
import com.reviewportal.service.services.IMemberServices;

public abstract class AbstractMemberServicesImpl<E extends AbstractMember, D extends AbstractMemberDTO>
		extends AbstractCommonServiceImpl<E, D> implements IMemberServices<E, D> {

	@Autowired
	public AbstractMemberServicesImpl(IMemberDao<E> pDao, AbstractEntityTOConverter<E, D> pConverter) {
		super(pDao, pConverter);
	}

	public IMemberDao<E> getDao() {
		return (IMemberDao<E>) super.getDao();
	}

	public AbstractEntityTOConverter<E, D> getConverter() {
		return (AbstractEntityTOConverter<E, D>) super.getConverter();
	}

	// @Override
	// public boolean isExist(D pDto) {
	// int lCount = getDao().getCount(pDto.getUser().getUsername());
	// if (lCount > 0) {
	// return true;
	// }
	// return false;
	// }

}
