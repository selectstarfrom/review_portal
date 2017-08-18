package com.reviewportal.dao.dao;

import org.springframework.data.repository.NoRepositoryBean;

import com.reviewportal.model.entities.AbstractMember;


/**
 * @author imfroz
 *
 * @param <T>
 */
@NoRepositoryBean
public interface IMemberDao<T extends AbstractMember> extends ICommonDao<T> {

    T getByUserId(Long pId);

}
