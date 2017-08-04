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
import com.reviewportal.model.entities.Profession;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DaoApplication.class)
@Transactional
@Rollback(false)
public class TestProfessionDao {

	@Autowired
	private IProfessionDao repository;

	private static List<String> PROFESSION_TITLES = Arrays.asList("accountant", "actor", "actress",
			"air traffic controller", "architect", "artist", "attorney", "banker", "bartender", "barber", "bookkeeper",
			"builder", "businessman", "businesswoman", "businessperson", "butcher", "carpenter", "cashier", "chef",
			"coach", "dental hygienist", "dentist", "designer", "developer", "dietician", "doctor", "economist",
			"editor", "electrician", "engineer");

	@Test
	public void testSave() throws Exception {
		List<Profession> lProfessions = new ArrayList<>();
		for (String lString : PROFESSION_TITLES) {
			Profession lProfession = new Profession();
			lProfession.setTitle(lString.toUpperCase());
			lProfession.setDescription(lString);
			lProfession.setCreatedBy("SYSTEM");
			lProfession.setModifiedBy("SYSTEM");
			lProfessions.add(lProfession);
		}

		this.repository.save(lProfessions);
	}

}