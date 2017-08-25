package com.reviewportal.service.impl.converter;

import org.springframework.stereotype.Component;

import com.reviewportal.model.entities.Professional;
import com.reviewportal.service.dto.ProfessionalDTO;

/**
 * @author imfroz
 *
 */
@Component
public class ProfessionalConverter extends AbstractEntityTOConverter<Professional, ProfessionalDTO> {

	@Override
	ProfessionalDTO getNewDtoInstance() {
		return new ProfessionalDTO();
	}

	@Override
	Professional getNewEntityInstance() {
		return new Professional();
	}

	@Override
	public String[] getComplexTypes() {
		return new String[] { "address", "profession", "user", "reviews" };
	}

}
