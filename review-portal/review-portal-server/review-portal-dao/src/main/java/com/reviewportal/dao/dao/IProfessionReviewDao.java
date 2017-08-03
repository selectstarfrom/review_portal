package com.reviewportal.dao.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.reviewportal.model.entities.ProfessionReview;

@Repository
public interface IProfessionReviewDao extends ICommonDao<ProfessionReview> {

	//@Query("SELECT count(*) FROM ProfessionReview r WHERE LOWER(r.reviewBy.id) = LOWER(:pUsername)")
	//int getCount(String pUsername);

}
