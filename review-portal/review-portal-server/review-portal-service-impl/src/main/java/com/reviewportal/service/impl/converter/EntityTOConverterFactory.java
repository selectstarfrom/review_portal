package com.reviewportal.service.impl.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.reviewportal.model.entities.AbstractEntity;
import com.reviewportal.service.dto.AbstractDTO;
import com.reviewportal.service.dto.UserRoleDTO;
import com.reviewportal.service.exceptions.SystemServiceException;

/**
 * @author imfroz
 *
 * @param <E>
 * @param <D>
 */
@Component
public class EntityTOConverterFactory {

	@Autowired
	private ApplicationContext appContext;

	@SuppressWarnings("unchecked")
	public <T extends AbstractEntityTOConverter<? extends AbstractEntity, ? extends AbstractDTO>> T getMapper(Class<?> pClass) {
		return (T) appContext.getBean(pClass);
	}

	public <T extends AbstractEntityTOConverter<? extends AbstractEntity, ? extends AbstractDTO>> T getCoverter(Class<?> pClass)
			throws SystemServiceException {

		UserRoleDTO.class.getName();

		switch (pClass.getName()) {

		case "com.reviewportal.service.dto.UserDTO":
			return getMapper(UserConverter.class);

		case "com.reviewportal.model.entities.User":
			return getMapper(UserConverter.class);

		case "com.reviewportal.service.dto.UserRoleDTO":
			return getMapper(UserRoleConverter.class);

		case "com.reviewportal.model.entities.UserRole":
			return getMapper(UserRoleConverter.class);

		case "com.reviewportal.service.dto.ProfessionReviewDTO":
			return getMapper(ProfessionReviewConverter.class);

		case "com.reviewportal.model.entities.ProfessionReview":
			return getMapper(UserRoleConverter.class);

		case "com.reviewportal.service.dto.ReviewWriterDTO":
			return getMapper(ReviewWriterConverter.class);

		case "com.reviewportal.model.entities.ReviewWriter":
			return getMapper(ReviewWriterConverter.class);

		case "com.reviewportal.service.dto.AddressDTO":
			return getMapper(AddressConverter.class);

		case "com.reviewportal.model.entities.Address":
			return getMapper(AddressConverter.class);

		case "com.reviewportal.service.dto.ProfessionalDTO":
			return getMapper(EmployeeConverter.class);

		case "com.reviewportal.model.entities.Professional":
			return getMapper(EmployeeConverter.class);

		case "com.reviewportal.service.dto.ProfessionDTO":
			return getMapper(ProfessionConverter.class);

		case "com.reviewportal.model.entities.Profession":
			return getMapper(ProfessionConverter.class);

		default:
			throw new SystemServiceException("No AbstractEntityTOConverter found for class: " + pClass.getName());
		}

	}

}
