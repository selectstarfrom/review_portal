package com.reviewportal.service.services;

import java.util.List;

import com.reviewportal.model.entities.AbstractEntity;
import com.reviewportal.service.dto.AbstractDTO;

/**
 * @author imfroz
 *
 * @param <E>
 * @param <D>
 */
public interface ICommonService<E extends AbstractEntity, D extends AbstractDTO> {

	void save(D pUserDTO);

	void save(List<D> pDto);

	List<D> getAll();

}
