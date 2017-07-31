package com.reviewportal.service.impl.services;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.reviewportal.dao.dao.ICommonDao;
import com.reviewportal.model.entities.AbstractEntity;
import com.reviewportal.service.dto.AbstractDTO;
import com.reviewportal.service.exceptions.SystemServiceException;
import com.reviewportal.service.impl.converter.AbstractEntityTOConverter;
import com.reviewportal.service.services.ICommonService;

public class AbstractCommonServiceImpl<E extends AbstractEntity, D extends AbstractDTO>
		implements ICommonService<E, D> {

	private ICommonDao<E> dao;

	private AbstractEntityTOConverter<E, D> converter;

	public AbstractCommonServiceImpl(ICommonDao<E> pDao, AbstractEntityTOConverter<E, D> pConverter) {
		super();
		dao = pDao;
		converter = pConverter;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void save(D pDto) throws SystemServiceException {
		E lEnity = converter.getEnity(pDto);
		dao.save(lEnity);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void save(List<D> pDto) throws SystemServiceException {
		List<E> lEnities = converter.getEnities(pDto);
		List<E> lEnity = lEnities;
		dao.save(lEnity);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public D update(D pDto) throws SystemServiceException {
		E lEnity = converter.getEnity(pDto);
		lEnity = dao.save(lEnity);
		D lDto = converter.getDto(lEnity);
		return lDto;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<D> update(List<D> pDto) throws SystemServiceException {
		List<E> lEnities = converter.getEnities(pDto);
		lEnities = dao.save(lEnities);
		List<D> lDtos = converter.getDtos(lEnities);
		return lDtos;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<D> getAll() throws SystemServiceException {
		List<E> lFindAll = (List<E>) dao.findAll();
		return converter.getDtos(lFindAll);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public D getById(Long pId) throws SystemServiceException {
		E lFind = dao.findOne(pId);
		return converter.getDto(lFind);
	}

	public ICommonDao<E> getDao() {
		return dao;
	}

	public AbstractEntityTOConverter<E, D> getConverter() {
		return converter;
	}

	@Override
	public boolean deleteById(Long pId) {
		getDao().delete(pId);
		return true;
	}

	@Override
	public boolean deleteAll() {
		getDao().deleteAll();
		return true;
	}

}
