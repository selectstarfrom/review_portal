package com.reviewportal.service.services.impl;

import java.util.List;

import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.reviewportal.dao.dao.ICommonDao;
import com.reviewportal.model.entities.AbstractEntity;
import com.reviewportal.service.converter.AbstractEntityTOConverter;
import com.reviewportal.service.dto.AbstractDTO;
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
	public void save(D pDto) {
		E lEnity = converter.getEnity(pDto);
		dao.save(lEnity);
	}
	
	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void save(List<D> pDto) {
		List<E> lEnity = converter.getEnities(pDto);
		dao.save(lEnity);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public List<D> getAll() {
		List<E> lFindAll = (List<E>) dao.findAll();
		return converter.getDtos(lFindAll);
	}

	public ICommonDao<E> getDao() {
		return dao;
	}

	public AbstractEntityTOConverter<E, D> getConverter() {
		return converter;
	}
	
	
}
