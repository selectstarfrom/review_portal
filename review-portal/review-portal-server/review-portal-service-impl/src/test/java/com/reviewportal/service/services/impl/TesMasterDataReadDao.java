package com.reviewportal.service.services.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.reviewportal.dao.dao.impl.MasterDataReadDaoImpl;
import com.reviewportal.service.impl.config.ServiceApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceApplication.class)
@Transactional
@Rollback(false)
public class TesMasterDataReadDao {

	@Autowired
	private MasterDataReadDaoImpl repository;

	@Test
	public void testSave() throws Exception {
		List<String> lProfessions = repository.getAllProfessionTitles();
		for (String lString : lProfessions) {
			System.out.println(lString);
		}
	}

}