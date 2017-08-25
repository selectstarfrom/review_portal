package com.reviewportal.service.test.converter;

import static org.junit.Assert.assertEquals;

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
import org.springframework.test.context.junit4.SpringRunner;

import com.reviewportal.model.entities.User;
import com.reviewportal.model.entities.UserRole;
import com.reviewportal.model.enums.UserStatus;
import com.reviewportal.model.enums.UserType;
import com.reviewportal.service.dto.UserDTO;
import com.reviewportal.service.dto.UserRoleDTO;
import com.reviewportal.service.impl.config.ServiceApplication;
import com.reviewportal.service.impl.converter.UserConverter;

/**
 * @author imfroz
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceApplication.class)
public class TestUserMapper {

    @Autowired
    private UserConverter converter;

    static Logger LOGGER = Logger.getLogger(TestUserMapper.class.getName());

    /**
     * Test for converting User Entity to User TO
     * 
     * @throws Exception
     */
    @Test
    public void testUserEntityToUserTO0() throws Exception {

        String lEmail = "test_user@testmail.com";
        String lUsername = "test_user";
        String lPassword = "12345";
        String lPhone = "223213";
        byte[] lPhoto = "pic_1".getBytes();
        Long lId = 101L;
        String lCreatedBy = "admin";
        String lModifiedBy = "admin";
        String lName = "user_1";

        Date lCreatedDate = getDateInstance();
        Date lModifiedDate = getDateInstance();

        Set<UserRoleDTO> lUserRoles = new HashSet<>();
        UserRoleDTO lUserRoleDTO = new UserRoleDTO(lId, lCreatedDate, lCreatedBy, lModifiedDate, lModifiedBy, "ADMIN",
                "Admin of the system");
        lUserRoles.add(lUserRoleDTO);

        UserDTO lUser = new UserDTO(lId, lCreatedDate, lCreatedBy, lModifiedDate, lModifiedBy, lName, lUsername, lEmail,
                lPassword, UserStatus.ACTIVE, lPhone, lPhoto, UserType.PROFESSIONAL, lUserRoles);

        LOGGER.debug("testUserEntityToUserTO: User: " + lUser);

        User lUserDto = converter.getEnity(lUser);

        LOGGER.debug("testUserEntityToUserTO: UserTO: " + lUserDto);

        assertEquals("User Entity to User DTO Convertion Failed", lUser.getId(), lUser.getId());

    }

    /**
     * Test for converting User Entity to User TO
     * 
     * @throws Exception
     */
    @Test
    public void testUserEntityToUserTO1() throws Exception {

        String lUsername = "test_user";
        String lEmail = "test_user@testmail.com";
        String lPassword = "12345";
        String lPhone = "223213";
        byte[] lPhoto = "pic_1".getBytes();
        Long lId = 101L;
        String lCreatedBy = "admin";
        String lModifiedBy = "admin";
        String lName = "user_1";

        Date lCreatedDate = getDateInstance();
        Date lModifiedDate = getDateInstance();

        Set<UserRole> lUserRoles = new HashSet<>();
        lUserRoles.add(new UserRole(lId, lCreatedDate, lCreatedBy, lModifiedDate, lModifiedBy, "ADMIN",
                "Admin of the system"));

        User lUser = new User(lId, lCreatedDate, lCreatedBy, lModifiedDate, lModifiedBy, lName, lUsername, lEmail,
                lPassword, UserStatus.ACTIVE, lPhone, lPhoto, UserType.PROFESSIONAL, lUserRoles);

        LOGGER.debug("testUserEntityToUserTO: User: " + lUser);

        UserConverter lConverter = new UserConverter();

        UserDTO lUserDto = lConverter.getDto(lUser, true);

        LOGGER.debug("testUserEntityToUserTO: UserTO: " + lUserDto);

        assertEquals("User Entity to User DTO Convertion Failed", lUser.getId(), lUser.getId());

    }

    private Date getDateInstance() {
        return new Date();
    }

    @Test
    public void testUserEntityToUserTOList() throws Exception {

        String lUsername1 = "test_user_1";
        String lEmail1 = "test_user1@testmail.com";
        String lPassword1 = "pass111";
        String lPhone1 = "1111";
        byte[] lPhoto1 = "pic_1".getBytes();
        Long lId1 = 101L;
        String lCreatedBy1 = "admin";
        String lModifiedBy1 = "admin";
        String lName1 = "user_1";

        Date lCreatedDate1 = getDateInstance();
        Date lModifiedDate1 = getDateInstance();

        Set<UserRole> lUserRoles1 = new HashSet<>();
        lUserRoles1.add(new UserRole(lId1, lCreatedDate1, lCreatedBy1, lModifiedDate1, lModifiedBy1, "ADMIN",
                "Admin of the system"));

        User lUser1 = new User(lId1, lCreatedDate1, lCreatedBy1, lModifiedDate1, lModifiedBy1, lName1, lUsername1,
                lEmail1, lPassword1, UserStatus.ACTIVE, lPhone1, lPhoto1, UserType.PROFESSIONAL, lUserRoles1);

        String lEmail2 = "test_user2@testmail.com";
        String lUsername2 = "test_user_1";
        String lPassword2 = "pass222";
        String lPhone2 = "2222";
        byte[] lPhoto2 = "pic_2".getBytes();
        Long lId2 = 101L;
        String lCreatedBy2 = "admin2";
        String lModifiedBy2 = "admin2";
        String lName2 = "user_2";

        Date lCreatedDate2 = getDateInstance();
        Date lModifiedDate2 = getDateInstance();

        Set<UserRole> lUserRoles2 = new HashSet<>();
        lUserRoles2.add(new UserRole(lId2, lCreatedDate2, lCreatedBy2, lModifiedDate2, lModifiedBy2, "ADMIN",
                "Admin of the system"));

        User lUser2 = new User(lId2, lCreatedDate2, lCreatedBy2, lModifiedDate2, lModifiedBy2, lName2, lUsername2,
                lEmail2, lPassword2, UserStatus.ACTIVE, lPhone2, lPhoto2, UserType.PROFESSIONAL, lUserRoles2);

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
