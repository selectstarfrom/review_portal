package com.reviewportal.service.impl.converter;

import org.springframework.stereotype.Component;

import com.reviewportal.model.entities.Official;
import com.reviewportal.service.dto.OfficialDTO;

/**
 * @author imfroz
 *
 */
@Component
public class OfficialConverter extends AbstractEntityTOConverter<Official, OfficialDTO> {

	@Override
	OfficialDTO getNewDtoInstance() {
		return new OfficialDTO();
	}

	@Override
	Official getNewEntityInstance() {
		return new Official();
	}

	@Override
	public String[] getComplexTypes() {
		return new String[] { "address", "profession", "user" };
	}

}
