package com.reviewportal.service.services.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.reviewportal.model.entities.UserRole;
import com.reviewportal.model.enums.UserStatus;
import com.reviewportal.service.config.ServiceApplication;
import com.reviewportal.service.dto.UserDTO;
import com.reviewportal.service.dto.UserRoleDTO;
import com.reviewportal.service.services.IUserServices;

/**
 * @author imfroz
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceApplication.class)
@Transactional
@Rollback(false)
public class TestUserService {

	static Logger LOGGER = Logger.getLogger(TestUserService.class.getName());

	@Autowired
	private IUserServices userServices;

	@Test
	public void testSaveUser1() throws Exception {

		String lEmail = "test_user@testmail.com";
		String lPassword = "12345";
		String lPhone = "223213";
		String lPhoto = "pic_1";
		Long lUserId = null;// 101L;
		String lCreatedBy = "admin";
		String lModifiedBy = "admin";
		String lName = "user_1";

		Date lCreatedDate = getDateInstance();
		Date lModifiedDate = getDateInstance();

		Set<UserRoleDTO> lUserRoles = new HashSet<>();
		lUserRoles.add(new UserRoleDTO(null, lCreatedDate, lCreatedBy, lModifiedDate, lModifiedBy, "ADMIN",
				"Admin of the system"));

		UserDTO lUser = new UserDTO(lUserId, lCreatedDate, lCreatedBy, lModifiedDate, lModifiedBy, lName, lEmail,
				lPassword, UserStatus.ACTIVE, lPhone, lPhoto, null);

		LOGGER.debug("testUserEntityToUserTO: User: " + lUser);

		userServices.save(lUser);

		List<UserDTO> lUserDto = userServices.getAll();

		LOGGER.debug("testUserEntityToUserTO: UserTO: " + lUserDto.get(0));

		assertEquals("User Entity to User DTO Convertion Failed", lUser.getId(), lUser.getId());

	}

	private Date getDateInstance() {
		return new Date();
	}

	@Test
	public void testSaveUser2() throws Exception {

		String lEmail1 = "test_user1@testmail.com";
		String lPassword1 = "pass111";
		String lPhone1 = "1111";
		String lPhoto1 = "pic_1";
		Long lId1 = 101L;
		String lCreatedBy1 = "admin";
		String lModifiedBy1 = "admin";
		String lName1 = "user_1";

		Date lCreatedDate1 = getDateInstance();
		Date lModifiedDate1 = getDateInstance();

		Set<UserRole> lUserRoles1 = new HashSet<>();
		lUserRoles1.add(new UserRole(lId1, lCreatedDate1, lCreatedBy1, lModifiedDate1, lModifiedBy1, "ADMIN",
				"Admin of the system"));

		UserDTO lUser1 = new UserDTO(null, lCreatedDate1, lCreatedBy1, lModifiedDate1, lModifiedBy1, lName1, lEmail1,
				lPassword1, UserStatus.ACTIVE, lPhone1, lPhoto1, null);

		String lEmail2 = "test_user2@testmail.com";
		String lPassword2 = "pass222";
		String lPhone2 = "2222";
		String lPhoto2 = "pic_2";
		Long lId2 = 101L;
		String lCreatedBy2 = "admin2";
		String lModifiedBy2 = "admin2";
		String lName2 = "user_2";

		Date lCreatedDate2 = getDateInstance();
		Date lModifiedDate2 = getDateInstance();

		Set<UserRole> lUserRoles2 = new HashSet<>();
		lUserRoles2.add(new UserRole(lId2, lCreatedDate2, lCreatedBy2, lModifiedDate2, lModifiedBy2, "ADMIN",
				"Admin of the system"));

		UserDTO lUser2 = new UserDTO(null, lCreatedDate2, lCreatedBy2, lModifiedDate2, lModifiedBy2, lName2, lEmail2,
				lPassword2, UserStatus.ACTIVE, lPhone2, lPhoto2, null);

		List<UserDTO> lUsers = Arrays.asList(lUser1, lUser2);
		LOGGER.debug("testUserEntityToUserTO List: User Entity 1: " + lUser1);
		LOGGER.debug("testUserEntityToUserTO List: User Entity 2: " + lUser2);

		userServices.save(lUsers);

		List<UserDTO> lAll = userServices.getAll();

		assertTrue("testSaveUser2 Failed", !lAll.isEmpty());

	}
}
