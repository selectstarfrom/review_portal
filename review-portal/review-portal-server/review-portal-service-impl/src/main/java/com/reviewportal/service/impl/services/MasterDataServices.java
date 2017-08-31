package com.reviewportal.service.impl.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.reviewportal.dao.dao.impl.MasterDataReadDaoImpl;
import com.reviewportal.service.exceptions.SystemServiceException;

@Service
public class MasterDataServices {

	@Autowired
	private MasterDataReadDaoImpl dao;

	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<String> getAllProfessionTitles() throws SystemServiceException {
		try {
			List<String> lFindAll = dao.getAllProfessionTitles();
			return lFindAll;
		} catch (Exception pException) {
			throw new SystemServiceException("Error occured in getAllProfessions service", pException);
		}
	}
	
	@Transactional(propagation = Propagation.REQUIRED, readOnly = true)
	public List<String[]> getAllProfessions() throws SystemServiceException {
	    try {
	        List<String[]> lFindAll = dao.getAllProfessions();
	        return lFindAll;
	    } catch (Exception pException) {
	        throw new SystemServiceException("Error occured in getAllProfessions service", pException);
	    }
	}

}