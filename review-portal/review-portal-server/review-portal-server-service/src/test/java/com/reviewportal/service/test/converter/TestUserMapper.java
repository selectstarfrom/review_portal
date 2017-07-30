package com.reviewportal.service.test.converter;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.junit.Test;

import com.reviewportal.model.entities.User;
import com.reviewportal.model.entities.UserRole;
import com.reviewportal.model.enums.UserStatus;
import com.reviewportal.service.converter.UserConverter;
import com.reviewportal.service.dto.UserDTO;

/**
 * @author imfroz
 *
 */
public class TestUserMapper {

	static Logger LOGGER = Logger.getLogger(TestUserMapper.class.getName());

	/**
	 * Test for converting User Entity to User TO
	 */
	@Test
	public void testUserEntityToUserTO1() {

		String lEmail = "test_user@testmail.com";
		String lPassword = "12345";
		String lPhone = "223213";
		String lPhoto = "pic_1";
		Long lId = 101L;
		String lCreatedBy = "admin";
		String lModifiedBy = "admin";
		String lName = "user_1";

		Date lCreatedDate = getDateInstance();
		Date lModifiedDate = getDateInstance();

		Set<UserRole> lUserRoles = new HashSet<>();
		lUserRoles.add(new UserRole(lId, lCreatedDate, lCreatedBy, lModifiedDate, lModifiedBy, "ADMIN",
				"Admin of the system"));

		User lUser = new User(lId, lCreatedDate, lCreatedBy, lModifiedDate, lModifiedBy, lName, lEmail, lPassword,
				UserStatus.ACTIVE, lPhone, lPhoto, lUserRoles);

		LOGGER.debug("testUserEntityToUserTO: User: " + lUser);

		UserConverter lConverter = new UserConverter();

		UserDTO lUserDto = lConverter.getDto(lUser);

		LOGGER.debug("testUserEntityToUserTO: UserTO: " + lUserDto);

		assertEquals("User Entity to User DTO Convertion Failed", lUser.getId(), lUser.getId());

	}

	private Date getDateInstance() {
		return new Date();
	}

	@Test
	public void testUserEntityToUserTOList() {

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

		User lUser1 = new User(lId1, lCreatedDate1, lCreatedBy1, lModifiedDate1, lModifiedBy1, lName1, lEmail1,
				lPassword1, UserStatus.ACTIVE, lPhone1, lPhoto1, lUserRoles1);

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

		User lUser2 = new User(lId2, lCreatedDate2, lCreatedBy2, lModifiedDate2, lModifiedBy2, lName2, lEmail2,
				lPassword2, UserStatus.ACTIVE, lPhone2, lPhoto2, lUserRoles2);

		List<User> lUsers = Arrays.asList(lUser1, lUser2);
		LOGGER.debug("testUserEntityToUserTO List: User Entity 1: " + lUser1);
		LOGGER.debug("testUserEntityToUserTO List: User Entity 2: " + lUser2);

		UserConverter lConverter = new UserConverter();

		List<UserDTO> lUserDto = lConverter.getDtos(lUsers);

		LOGGER.debug("testUserEntityToUserTO List: User TO 1: " + lUserDto.get(0));
		LOGGER.debug("testUserEntityToUserTO List: User TO 2: " + lUserDto.get(1));

		assertEquals("User Entity to User DTO List Convertion Failed", lUser1.getId(), lUserDto.get(0).getId());
		assertEquals("User Entity to User DTO List Convertion Failed", lUser2.getId(), lUserDto.get(1).getId());

	}
}
