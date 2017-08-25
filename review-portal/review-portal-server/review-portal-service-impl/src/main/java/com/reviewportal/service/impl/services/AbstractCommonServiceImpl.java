package com.reviewportal.service.impl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
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

    @Autowired
    private CommonServices commonServices;

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
        try {
            E lEnity = converter.getEnity(pDto);
            dao.save(lEnity);
        } catch (Exception pException) {
            throw new SystemServiceException("Error occured in save service", pException);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(List<D> pDto) throws SystemServiceException {
        try {
            List<E> lEnities = converter.getEnities(pDto);
            List<E> lEnity = lEnities;
            dao.save(lEnity);
        } catch (Exception pException) {
            throw new SystemServiceException("Error occured in save service", pException);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public D update(D pDto) throws SystemServiceException {
        try {
            E lEnity = converter.getEnity(pDto);
            lEnity = dao.save(lEnity);
            D lDto = converter.getDto(lEnity);
            return lDto;
        } catch (Exception pException) {
            throw new SystemServiceException("Error occured in update service", pException);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public List<D> update(List<D> pDto) throws SystemServiceException {
        try {
            List<E> lEnities = converter.getEnities(pDto);
            lEnities = dao.save(lEnities);
            List<D> lDtos = converter.getDtos(lEnities);
            return lDtos;
        } catch (Exception pException) {
            throw new SystemServiceException("Error occured in update service", pException);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<D> getAll() throws SystemServiceException {
        try {
            List<E> lFindAll = (List<E>) dao.findAll();
            return converter.getDtos(lFindAll);
        } catch (Exception pException) {
            throw new SystemServiceException("Error occured in getAll service", pException);
        }
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public D getById(Long pId) throws SystemServiceException {
        try {
            E lFind = dao.findOne(pId);
            return converter.getDto(lFind);
        } catch (Exception pException) {
            throw new SystemServiceException("Error occured in getById service", pException);
        }
    }

    public ICommonDao<E> getDao() {
        return dao;
    }

    public AbstractEntityTOConverter<E, D> getConverter() {
        return converter;
    }

    @Override
    public boolean deleteById(Long pId) {
        try {
            getDao().delete(pId);
            return true;
        } catch (Exception pException) {
            throw new SystemServiceException("Error occured in deleteById service", pException);
        }
    }

    @Override
    public boolean deleteAll() {
        try {
            getDao().deleteAll();
            return true;
        } catch (Exception pException) {
            throw new SystemServiceException("Error occured in deleteAll service", pException);
        }
    }

    public CommonServices getCommonServices() {
        return commonServices;
    }

    public List<D> getByExample(D pProfessionReviewExample) {

        E lEnity = getConverter().getEnity(pProfessionReviewExample);

        ExampleMatcher lExampleMatcher = ExampleMatcher.matchingAll().withIgnoreCase().withIgnoreNullValues()
                .withStringMatcher(StringMatcher.CONTAINING);
        Example<E> lExample = Example.of(lEnity, lExampleMatcher);

        List<E> lFindAll = getDao().findAll(lExample);

        List<D> lDtos = getConverter().getDtos(lFindAll);

        return lDtos;
    }

}
