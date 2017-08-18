package com.reviewportal.dao.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.reviewportal.model.entities.User;

/**
 * @author imfroz
 *
 */
@Repository
public interface IUserDao extends ICommonDao<User> {

	@Query("SELECT count(*) FROM User u WHERE LOWER(u.username) = LOWER(:pUsername)")
	int getCount(String pUsername);

	@Query("SELECT u FROM User u WHERE LOWER(u.username) = LOWER(:pUsername)")
    User getByUsername(@Param("pUsername") String pString);

}
