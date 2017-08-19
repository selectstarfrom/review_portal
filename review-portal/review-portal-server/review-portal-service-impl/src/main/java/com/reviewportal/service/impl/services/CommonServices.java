package com.reviewportal.service.impl.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.stereotype.Service;

import com.reviewportal.dao.dao.IProfessionDao;
import com.reviewportal.dao.dao.IUserRoleDao;
import com.reviewportal.model.entities.Profession;
import com.reviewportal.model.entities.UserRole;
import com.reviewportal.model.enums.UserRoleEnums;
import com.reviewportal.service.dto.ProfessionDTO;
import com.reviewportal.service.dto.UserRoleDTO;
import com.reviewportal.service.exceptions.SystemServiceException;
import com.reviewportal.service.impl.converter.EntityTOConverterFactory;
import com.reviewportal.service.impl.converter.ProfessionConverter;
import com.reviewportal.service.impl.converter.UserRoleConverter;

@Service
public class CommonServices {

	@Autowired
	private IUserRoleDao userRoleDao;

	@Autowired
	private IProfessionDao professionDao;

	@Autowired
	private EntityTOConverterFactory converterFactory;

	public Set<UserRoleDTO> getDefaultUserRolesForProfessionals() throws SystemServiceException {
		return getRoles(UserRoleEnums.USER_MEMBER_PROFESSIONAL);
	}

	public Set<UserRoleDTO> getDefaultUserRolesForReviewWriters() throws SystemServiceException {
		return getRoles(UserRoleEnums.USER_MEMBER_REVIEW_WRITER);
	}

	private Set<UserRoleDTO> getRoles(UserRoleEnums pUserRoleEnums) {
		UserRole lUserRole = new UserRole();
		lUserRole.setRole(pUserRoleEnums.name());
		Example<UserRole> lExample = Example.of(lUserRole);
		List<UserRole> lFindAll = userRoleDao.findAll(lExample);
		UserRoleConverter lConverter = converterFactory.getCoverter(UserRole.class);
		List<UserRoleDTO> lDtos = lConverter.getDtos(lFindAll);
		return new HashSet<UserRoleDTO>(lDtos);
	}

	public String getEncodedPassword(String pPassword, String pSalt) {
		return getPasswordEncoder().encodePassword(pPassword, pSalt);
	}

	@Bean
	public ShaPasswordEncoder getPasswordEncoder() {
		return new ShaPasswordEncoder(256);
	}

	public ProfessionDTO getProfessionByName(String pName) throws SystemServiceException {
		Profession lProfession = new Profession();
		lProfession.setTitle(pName);
		Example<Profession> lExample = Example.of(lProfession);
		Profession lFindOne = professionDao.findOne(lExample);
		ProfessionConverter lConverter = converterFactory.getCoverter(Profession.class);
		ProfessionDTO lDto = lConverter.getDto(lFindOne);
		return lDto;
	}
}
