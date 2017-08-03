package com.reviewportal.service.impl.services.member;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.reviewportal.dao.dao.IOfficialsDao;
import com.reviewportal.model.entities.Official;
import com.reviewportal.model.enums.MembershipType;
import com.reviewportal.service.dto.OfficialDTO;
import com.reviewportal.service.dto.ProfessionDTO;
import com.reviewportal.service.dto.UserDTO;
import com.reviewportal.service.dto.UserRoleDTO;
import com.reviewportal.service.exceptions.SystemServiceException;
import com.reviewportal.service.impl.converter.OfficialConverter;

@Service
public class EmployeeMemberServicesImpl extends AbstractMemberServicesImpl<Official, OfficialDTO> {

	@Autowired
	public EmployeeMemberServicesImpl(IOfficialsDao pDao, OfficialConverter pConverter) {
		super(pDao, pConverter);
	}

	public IOfficialsDao getDao() {
		return (IOfficialsDao) super.getDao();
	}

	public OfficialConverter getConverter() {
		return (OfficialConverter) super.getConverter();
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void save(OfficialDTO pDto) throws SystemServiceException {

		pDto.setId(null);
		pDto.getAddress().setId(null);
		if (MembershipType.OFFICIAL.name().equals(pDto.getMembershipType())) {
			ProfessionDTO lDto = getCommonServices().getProfessionByName(pDto.getProfession().getTitle());
			pDto.setProfession(lDto);
		}
		UserDTO lUser = pDto.getUser();
		lUser.setId(null);
		String lEncodedPassword = getCommonServices().getEncodedPassword(lUser.getPassword(), lUser.getUsername());
		Set<UserRoleDTO> lUserRoles;
		try {
			lUserRoles = getCommonServices().getDefaultUserRolesForOfficials();
		} catch (SystemServiceException pServiceException) {
			throw pServiceException;
		}

		lUser.setPassword(lEncodedPassword);
		lUser.setUserRoles(lUserRoles);

		super.save(pDto);
	}

}
