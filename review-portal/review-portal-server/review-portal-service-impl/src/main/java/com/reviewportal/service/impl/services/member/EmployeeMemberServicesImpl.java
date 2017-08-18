package com.reviewportal.service.impl.services.member;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reviewportal.dao.dao.IOfficialsDao;
import com.reviewportal.model.entities.Official;
import com.reviewportal.model.enums.UserType;
import com.reviewportal.service.dto.OfficialDTO;
import com.reviewportal.service.dto.ProfessionDTO;
import com.reviewportal.service.dto.UserRoleDTO;
import com.reviewportal.service.impl.converter.OfficialConverter;

/**
 * @author imfroz
 *
 */
@Service
public class EmployeeMemberServicesImpl extends AbstractMemberServicesImpl<Official, OfficialDTO> {

    @Autowired
    public EmployeeMemberServicesImpl(IOfficialsDao pDao, OfficialConverter pConverter) {
        super(pDao, pConverter);
    }

    public IOfficialsDao getDao() {
        return (IOfficialsDao) super.getDao();
    }

    public OfficialConverter getConverter() {
        return (OfficialConverter) super.getConverter();
    }

    @Override
    protected void doMemberSpecificLogics(OfficialDTO pDto) {

        ProfessionDTO lDto = getCommonServices().getProfessionByName(pDto.getProfession().getTitle());
        pDto.setProfession(lDto);
        pDto.getUser().setUserType(UserType.PROFESSIONAL);
    }

    protected Set<UserRoleDTO> getDefaultRolesBasedOnMemberType() {
        return getCommonServices().getDefaultUserRolesForOfficials();
    }

}
