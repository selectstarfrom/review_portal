package com.reviewportal.dao.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.reviewportal.dao.config.DaoApplication;
import com.reviewportal.model.entities.UserRole;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DaoApplication.class)
@Transactional
@Rollback(false)
public class TestUserRoleDao {

	@Autowired
	private IUserRoleDao repository;

	private static List<String> USER_ROLES = Arrays.asList("ADMIN", "USER_MEMBER_PROFESSIONAL",
			"USER_MEMBER_REVIEW_WRITER");

	@Test
	public void testSave() throws Exception {
		List<UserRole> lUserRoles = new ArrayList<>();
		for (String lString : USER_ROLES) {
			UserRole lUserRole = new UserRole();
			lUserRole.setRole(lString.toUpperCase());
			lUserRole.setDescription(lString);
			lUserRole.setCreatedBy("SYSTEM");
			lUserRole.setModifiedBy("SYSTEM");
			lUserRoles.add(lUserRole);
		}

		this.repository.save(lUserRoles);
	}

}