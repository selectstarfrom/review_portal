package com.reviewportal.dao.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

/**
 * @author imfroz
 *
 */
@Repository
public class MemberReadDaoImpl {

	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<String> getAllProfessions() {
		Query lCreateQuery = entityManager.createQuery("SELECT p.title FROM Profession as p");
		List<String> lResultList = lCreateQuery.getResultList();
		return lResultList;
	}
}