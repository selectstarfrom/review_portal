package com.reviewportal.service.impl.converter;

import org.springframework.stereotype.Component;

import com.reviewportal.model.entities.ProfessionReview;
import com.reviewportal.service.dto.ProfessionReviewDTO;

/**
 * @author imfroz
 *
 */
@Component
public class ProfessionReviewConverter extends AbstractEntityTOConverter<ProfessionReview, ProfessionReviewDTO> {

	@Override
	ProfessionReviewDTO getNewDtoInstance() {
		return new ProfessionReviewDTO();
	}

	@Override
	ProfessionReview getNewEntityInstance() {
		return new ProfessionReview();
	}

	@Override
	public String[] getComplexTypes() {
		return new String[] { "reviewBy", "reviewAbout" };
	}

}
