package com.reviewportal.service.services;

import java.util.List;

import com.reviewportal.model.entities.AbstractEntity;
import com.reviewportal.service.dto.AbstractDTO;
import com.reviewportal.service.exceptions.SystemServiceException;

/**
 * @author imfroz
 *
 * @param <E>
 * @param <D>
 */
public interface ICommonService<E extends AbstractEntity, D extends AbstractDTO> {

	void save(D pUserDTO) throws SystemServiceException;

	void save(List<D> pDto) throws SystemServiceException;

	D update(D pUserDTO) throws SystemServiceException;

	List<D> update(List<D> pDto) throws SystemServiceException;

	List<D> getAll() throws SystemServiceException;

	D getById(Long pId) throws SystemServiceException;

	boolean deleteById(Long pId) throws SystemServiceException;

	boolean deleteAll() throws SystemServiceException;

}
