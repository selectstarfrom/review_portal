package com.reviewportal.service.impl.services.member;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.reviewportal.dao.dao.IMemberDao;
import com.reviewportal.model.entities.AbstractMember;
import com.reviewportal.service.dto.AbstractMemberDTO;
import com.reviewportal.service.dto.UserDTO;
import com.reviewportal.service.dto.UserRoleDTO;
import com.reviewportal.service.exceptions.SystemServiceException;
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

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void save(D pDto) throws SystemServiceException {

		pDto.setId(null);
		pDto.getAddress().setId(null);

		doMemberSpecificLogics(pDto);

		UserDTO lUser = pDto.getUser();
		lUser.setId(null);
		String lEncodedPassword = getCommonServices().getEncodedPassword(lUser.getPassword(), lUser.getUsername());
		Set<UserRoleDTO> lUserRoles;
		try {
			lUserRoles = getDefaultRolesBasedOnMemberType();
		} catch (SystemServiceException pServiceException) {
			throw pServiceException;
		}

		lUser.setPassword(lEncodedPassword);
		lUser.setUserRoles(lUserRoles);

		super.save(pDto);
	}

	protected abstract Set<UserRoleDTO> getDefaultRolesBasedOnMemberType();

	protected void doMemberSpecificLogics(D pDto) {

	}

}
