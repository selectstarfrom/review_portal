package com.reviewportal.dao.dao;

import org.springframework.data.repository.CrudRepository;

import com.reviewportal.model.entities.AbstractEntity;

public interface ICommonDao<E extends AbstractEntity> extends CrudRepository<E, Long> {

}
