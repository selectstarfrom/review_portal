package com.reviewportal.service.services.impl;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.reviewportal.dao.dao.IProfessionDao;
import com.reviewportal.model.entities.Profession;
import com.reviewportal.model.enums.UserStatus;
import com.reviewportal.model.enums.UserType;
import com.reviewportal.service.dto.AddressDTO;
import com.reviewportal.service.dto.ProfessionDTO;
import com.reviewportal.service.dto.ProfessionReviewDTO;
import com.reviewportal.service.dto.ProfessionalDTO;
import com.reviewportal.service.dto.ReviewWriterDTO;
import com.reviewportal.service.dto.UserDTO;
import com.reviewportal.service.dto.UserRoleDTO;
import com.reviewportal.service.impl.config.ServiceApplication;
import com.reviewportal.service.impl.converter.ProfessionConverter;
import com.reviewportal.service.impl.services.ProfessionReviewServicesImpl;
import com.reviewportal.service.impl.services.member.ProfessionalMemberServicesImpl;
import com.reviewportal.service.impl.services.member.ReviewWriterMemberServicesImpl;

/**
 * @author imfroz
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceApplication.class)
@Transactional
@Rollback(false)
public class TestProfessionalReviewService {

    static Logger LOGGER = Logger.getLogger(TestProfessionalReviewService.class.getName());

    static String lCreatedBy = "SYSTEM";
    static String lModifiedBy = "SYSTEM";

    @Autowired
    private IProfessionDao professionDao;

    @Autowired
    private ProfessionalMemberServicesImpl professionalMemberService;
    @Autowired
    private ReviewWriterMemberServicesImpl reviewWriterMemberServices;
    @Autowired
    private ProfessionReviewServicesImpl professionReviewService;

    // @Test
    public void testGetReview() throws Exception {
        System.out.println("----");
        ProfessionalDTO lById = professionalMemberService.getById(1L);
        System.out.println(lById);
    }

    @Test
    public void testCreateReviews() throws Exception {
        List<ProfessionReviewDTO> lDtos = new ArrayList<>();
        Random lRandom = new Random();

        ProfessionalDTO lById = professionalMemberService.getById(15L);
        ReviewWriterDTO lById2 = reviewWriterMemberServices.getById(1L);
        for (int lI = 0; lI < 50; lI++) {

            ProfessionReviewDTO lDto = new ProfessionReviewDTO();
            lDto.setReviewAbout(lById);
            lDto.setRating(5);
            lDto.setReview("sdfsfsadfsdf");
            lDto.setReviewBy(lById2);
            lDtos.add(lDto);
        }

        professionReviewService.save(lDtos);
    }

    private AddressDTO getAddressInstance(Long pLong) {
        AddressDTO lAddress = new AddressDTO();
        lAddress.setAddress("aaaa" + pLong);
        lAddress.setCity("ccc" + pLong);
        lAddress.setState("sss" + pLong);
        lAddress.setZip("zzz" + pLong);
        return lAddress;
    }

    private UserDTO getUserInstance(Long pLong, int pI) {
        String lUsername = "puser" + pI;
        String lEmail = "puser" + pLong + "@testmail.com";
        String lPassword = "12345";
        byte[] lPhoto = getImage(pLong);
        Long lUserId = null;// 101L;
        String lCreatedBy = "SYSTEM";
        String lModifiedBy = "SYSTEM";
        String lName = "user_" + pLong;

        Set<UserRoleDTO> lUserRoles = new HashSet<>();

        UserDTO lUser = new UserDTO(lUserId, null, lCreatedBy, null, lModifiedBy, lName, lUsername, lEmail, lPassword,
                UserStatus.ACTIVE, null, lPhoto, UserType.PROFESSIONAL, null);
        return lUser;
    }

    long nextLong(Random rng, long n) {
        long bits, val;
        do {
            bits = (rng.nextLong() << 1) >>> 1;
            val = bits % n;
        } while (bits - val + (n - 1) < 0L);
        return val;
    }

    public ProfessionDTO getProfession(long pLong) {

        Long id = pLong % 29;
        id = id == 0 ? id + 1 : id;
        System.out.println(pLong + "----" + id);
        Profession lOne = professionDao.getOne(id);
        return new ProfessionConverter().getDto(lOne, false);
    }

    public static byte[] getImage(long plong) {
        int lindex = (int) (plong % 99);
        URL url;
        try {
            url = new URL("https://randomuser.me/api/portraits/med/men/" + lindex + ".jpg");
            InputStream is = url.openStream();
            byte[] bytes = IOUtils.toByteArray(is);
            return bytes;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

}
