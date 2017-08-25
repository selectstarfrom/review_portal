package com.reviewportal.dao.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reviewportal.model.entities.ProfessionReview;

@Repository
public interface IProfessionReviewDao extends ICommonDao<ProfessionReview> {

    // @Query("SELECT count(*) FROM ProfessionReview r WHERE
    // LOWER(r.reviewBy.id) = LOWER(:pUsername)")
    // int getCount(String pUsername);

    @Modifying(clearAutomatically = true)
    @Query("update Professional p set p.rating = (SELECT AVG(x.rating)  FROM ProfessionReview x WHERE x.reviewAbout.id=:pId) WHERE p.id=:pId")
    void updateAvgRatingById(@Param("pId") Long pId);

}
