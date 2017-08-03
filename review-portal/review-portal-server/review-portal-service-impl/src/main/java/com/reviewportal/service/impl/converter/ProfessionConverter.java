package com.reviewportal.service.impl.converter;

import org.springframework.stereotype.Component;

import com.reviewportal.model.entities.Profession;
import com.reviewportal.service.dto.ProfessionDTO;

/**
 * @author imfroz
 *
 */
@Component
public class ProfessionConverter extends AbstractEntityTOConverter<Profession, ProfessionDTO> {

	@Override
	ProfessionDTO getNewDtoInstance() {
		return new ProfessionDTO();
	}

	@Override
	Profession getNewEntityInstance() {
		return new Profession();
	}

}
