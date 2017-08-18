package com.reviewportal.dao.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.reviewportal.model.entities.AbstractEntity;

/**
 * @author imfroz
 *
 * @param <E>
 */
public interface ICommonDao<E extends AbstractEntity> extends JpaRepository<E, Long> {

}
