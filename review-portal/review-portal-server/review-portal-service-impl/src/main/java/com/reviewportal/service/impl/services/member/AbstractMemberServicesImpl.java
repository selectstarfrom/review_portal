package com.reviewportal.service.impl.services.member;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.reviewportal.dao.dao.IMemberDao;
import com.reviewportal.model.entities.AbstractMember;
import com.reviewportal.service.dto.AbstractMemberDTO;
import com.reviewportal.service.dto.UserDTO;
import com.reviewportal.service.dto.UserRoleDTO;
import com.reviewportal.service.exceptions.SystemServiceException;
import com.reviewportal.service.impl.converter.AbstractEntityTOConverter;
import com.reviewportal.service.impl.services.AbstractCommonServiceImpl;
import com.reviewportal.service.services.IMemberServices;

/**
 * @author imfroz
 *
 * @param <E>
 * @param <D>
 */
public abstract class AbstractMemberServicesImpl<E extends AbstractMember, D extends AbstractMemberDTO>
        extends AbstractCommonServiceImpl<E, D> implements IMemberServices<E, D> {

    @Autowired
    public AbstractMemberServicesImpl(IMemberDao<E> pDao, AbstractEntityTOConverter<E, D> pConverter) {
        super(pDao, pConverter);
    }

    public IMemberDao<E> getDao() {
        return (IMemberDao<E>) super.getDao();
    }

    public AbstractEntityTOConverter<E, D> getConverter() {
        return (AbstractEntityTOConverter<E, D>) super.getConverter();
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public void save(D pDto) throws SystemServiceException {

        pDto.setId(null);
        pDto.getAddress().setId(null);

        UserDTO lUser = pDto.getUser();
        lUser.setId(null);
        String lEncodedPassword = getCommonServices().getEncodedPassword(lUser.getPassword(), lUser.getUsername());
        Set<UserRoleDTO> lUserRoles;
        try {
            lUserRoles = getDefaultRolesBasedOnMemberType();
        } catch (SystemServiceException pServiceException) {
            throw pServiceException;
        }

        lUser.setPassword(lEncodedPassword);
        lUser.setUserRoles(lUserRoles);

        doMemberSpecificLogics(pDto);

        super.save(pDto);
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRED, readOnly = false)
    public D update(D pDto) throws SystemServiceException {

        UserDTO lUser = pDto.getUser();
        String lEncodedPassword = getCommonServices().getEncodedPassword(lUser.getPassword(), lUser.getUsername());
        lUser.setPassword(lEncodedPassword);

        doMemberSpecificLogics(pDto);

        D lUpdate = super.update(pDto);
        return lUpdate;
    }

    protected abstract Set<UserRoleDTO> getDefaultRolesBasedOnMemberType();

    protected void doMemberSpecificLogics(D pDto) {

    }

    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public D getByUserId(Long pId) {
        E lEntity = getDao().getByUserId(pId);
        return getConverter().getDto(lEntity);
    }

}
