package com.reviewportal.dao.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.reviewportal.dao.config.DaoApplication;
import com.reviewportal.model.entities.User;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DaoApplication.class)
@Transactional
@Rollback(false)
public class TestUserDao {

	@Autowired
	private IUserDao repository;

	@Test
	public void testSave() throws Exception {
		User lUser = new User();
		lUser.setDisplayPicture("test-photo");
		this.repository.save(lUser);
	}

}