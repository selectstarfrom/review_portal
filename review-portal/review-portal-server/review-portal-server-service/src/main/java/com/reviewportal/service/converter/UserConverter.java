package com.reviewportal.service.converter;

import org.springframework.stereotype.Component;

import com.reviewportal.model.entities.User;
import com.reviewportal.service.dto.UserDTO;

/**
 * @author imfroz
 *
 */
@Component
public class UserConverter extends AbstractEntityTOConverter<User, UserDTO> {

	@Override
	UserDTO getNewDtoInstance() {
		return new UserDTO();
	}

	@Override
	User getNewEntityInstance() {
		return new User();
	}

	public String[] getComplexTypes() {
		return new String[] { "userRoles" };
	}

}
