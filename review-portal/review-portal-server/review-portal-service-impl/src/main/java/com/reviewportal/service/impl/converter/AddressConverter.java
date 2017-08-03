package com.reviewportal.service.impl.converter;

import org.springframework.stereotype.Component;

import com.reviewportal.model.entities.Address;
import com.reviewportal.service.dto.AddressDTO;

/**
 * @author imfroz
 *
 */
@Component
public class AddressConverter extends AbstractEntityTOConverter<Address, AddressDTO> {

	@Override
	AddressDTO getNewDtoInstance() {
		return new AddressDTO();
	}

	@Override
	Address getNewEntityInstance() {
		return new Address();
	}

}
