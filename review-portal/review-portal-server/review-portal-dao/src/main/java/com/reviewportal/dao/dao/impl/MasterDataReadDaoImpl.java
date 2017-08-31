package com.reviewportal.dao.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public class MasterDataReadDaoImpl {

	@PersistenceContext
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	public List<String> getAllProfessionTitles() {
		Query lCreateQuery = entityManager.createQuery("SELECT p.title FROM Profession as p");
		List<String> lResultList = lCreateQuery.getResultList();
		return lResultList;
	}
	
	@SuppressWarnings("unchecked")
	public List<String[]> getAllProfessions() {
	    Query lCreateQuery = entityManager.createQuery("SELECT p.title, p.description FROM Profession as p");
	    List<String[]> lResultList = lCreateQuery.getResultList();
	    return lResultList;
	}
}