package com.reviewportal.service.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.reviewportal.model.entities.AbstractEntity;
import com.reviewportal.service.dto.AbstractDTO;

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
	protected <T extends AbstractEntityTOConverter<? extends AbstractEntity, ? extends AbstractDTO>> T getMapper(
			Class<?> pClass) {
		return (T) appContext.getBean(pClass);
	}

}
