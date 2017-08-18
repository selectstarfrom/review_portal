package com.reviewportal.dao.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reviewportal.model.entities.ReviewWriter;

/**
 * @author imfroz
 *
 */
@Repository
public interface IReviewWriterDao extends IMemberDao<ReviewWriter> {

    @Override
    @Query("SELECT u FROM ReviewWriter u WHERE u.user.id = :pUserId")
    ReviewWriter getByUserId(@Param("pUserId") Long pId);
}
