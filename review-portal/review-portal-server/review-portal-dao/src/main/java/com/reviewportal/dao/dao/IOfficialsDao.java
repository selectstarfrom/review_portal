package com.reviewportal.dao.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reviewportal.model.entities.Official;

/**
 * @author imfroz
 *
 */
@Repository
public interface IOfficialsDao extends IMemberDao<Official> {

    @Override
    @Query("SELECT u FROM Official u WHERE u.user.id = :pUserId")
    Official getByUserId(@Param("pUserId") Long pId);

}
