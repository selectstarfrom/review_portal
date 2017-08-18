package com.reviewportal.service.services;

import com.reviewportal.model.entities.User;
import com.reviewportal.service.dto.UserDTO;

/**
 * @author imfroz
 *
 */
public interface IUserServices extends ICommonService<User, UserDTO> {

	public boolean isExist(UserDTO pDto);

    UserDTO getByUsername(String pString);

    boolean checkPassword(String pRawPassword, UserDTO pUser);

}
