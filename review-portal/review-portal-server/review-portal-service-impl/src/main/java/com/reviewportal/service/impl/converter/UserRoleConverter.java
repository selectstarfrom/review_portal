package com.reviewportal.service.impl.converter;

import org.springframework.stereotype.Component;

import com.reviewportal.model.entities.UserRole;
import com.reviewportal.service.dto.UserRoleDTO;

/**
 * @author imfroz
 *
 */
@Component
public class UserRoleConverter extends AbstractEntityTOConverter<UserRole, UserRoleDTO> {

	@Override
	UserRoleDTO getNewDtoInstance() {
		return new UserRoleDTO();
	}

	@Override
	UserRole getNewEntityInstance() {
		return new UserRole();
	}

}
