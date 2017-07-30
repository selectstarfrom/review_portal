package com.reviewportal.service.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reviewportal.dao.dao.IUserDao;
import com.reviewportal.model.entities.User;
import com.reviewportal.service.converter.UserConverter;
import com.reviewportal.service.dto.UserDTO;
import com.reviewportal.service.services.IUserServices;

@Service
public class UserServicesImpl extends AbstractCommonServiceImpl<User, UserDTO> implements IUserServices {

	@Autowired
	public UserServicesImpl(IUserDao pDao, UserConverter pConverter) {
		super(pDao, pConverter);
	}

	public IUserDao getDao() {
		return (IUserDao) super.getDao();
	}

	public UserConverter getConverter() {
		return (UserConverter) super.getConverter();
	}

	@Override
	public boolean isExist(UserDTO pDto) {
		int lCount = getDao().getCount(pDto.getUsername());
		if (lCount > 0) {
			return true;
		}
		return false;
	}

}
