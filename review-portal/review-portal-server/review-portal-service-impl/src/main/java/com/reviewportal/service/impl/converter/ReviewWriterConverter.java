package com.reviewportal.service.impl.converter;

import org.springframework.stereotype.Component;

import com.reviewportal.model.entities.ReviewWriter;
import com.reviewportal.service.dto.ReviewWriterDTO;

/**
 * @author imfroz
 *
 */
@Component
public class ReviewWriterConverter extends AbstractEntityTOConverter<ReviewWriter, ReviewWriterDTO> {

	@Override
	ReviewWriterDTO getNewDtoInstance() {
		return new ReviewWriterDTO();
	}

	@Override
	ReviewWriter getNewEntityInstance() {
		return new ReviewWriter();
	}

	@Override
	public String[] getComplexTypes() {
		return new String[] { "address", "user" };
	}

}
