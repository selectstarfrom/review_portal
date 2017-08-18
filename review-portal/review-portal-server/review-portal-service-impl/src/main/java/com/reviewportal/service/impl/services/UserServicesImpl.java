package com.reviewportal.service.impl.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.reviewportal.dao.dao.IUserDao;
import com.reviewportal.model.entities.User;
import com.reviewportal.service.dto.UserDTO;
import com.reviewportal.service.impl.converter.UserConverter;
import com.reviewportal.service.services.IUserServices;

/**
 * @author imfroz
 *
 */
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
    @Transactional(readOnly = true)
    public boolean isExist(UserDTO pDto) {
        int lCount = getDao().getCount(pDto.getUsername());
        if (lCount > 0) {
            return true;
        }
        return false;
    }

    @Override
    @Transactional(readOnly = true)
    public UserDTO getByUsername(String pString) {
        User lUser = getDao().getByUsername(pString);
        UserDTO lDto = getConverter().getDto(lUser);
        return lDto;
    }

}
