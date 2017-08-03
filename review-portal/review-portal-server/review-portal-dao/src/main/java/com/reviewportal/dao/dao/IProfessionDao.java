package com.reviewportal.dao.dao;

import org.springframework.stereotype.Repository;

import com.reviewportal.model.entities.Profession;

@Repository
public interface IProfessionDao extends ICommonDao<Profession> {

	// @Query("SELECT count(*) FROM ProfessionReview r WHERE
	// LOWER(r.reviewBy.id) = LOWER(:pUsername)")
	// int getCount(String pUsername);

}
