package com.reviewportal.service.impl.services.member;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reviewportal.dao.dao.IProfessionalDao;
import com.reviewportal.model.entities.Professional;
import com.reviewportal.model.enums.UserType;
import com.reviewportal.service.dto.ProfessionalDTO;
import com.reviewportal.service.dto.ProfessionDTO;
import com.reviewportal.service.dto.UserRoleDTO;
import com.reviewportal.service.impl.converter.ProfessionalConverter;

/**
 * @author imfroz
 *
 */
@Service
public class EmployeeMemberServicesImpl extends AbstractMemberServicesImpl<Professional, ProfessionalDTO> {

    @Autowired
    public EmployeeMemberServicesImpl(IProfessionalDao pDao, ProfessionalConverter pConverter) {
        super(pDao, pConverter);
    }

    public IProfessionalDao getDao() {
        return (IProfessionalDao) super.getDao();
    }

    public ProfessionalConverter getConverter() {
        return (ProfessionalConverter) super.getConverter();
    }

    @Override
    protected void doMemberSpecificLogics(ProfessionalDTO pDto) {

        ProfessionDTO lDto = getCommonServices().getProfessionByName(pDto.getProfession().getTitle());
        pDto.setProfession(lDto);
        pDto.getUser().setUserType(UserType.PROFESSIONAL);
    }

    protected Set<UserRoleDTO> getDefaultRolesBasedOnMemberType() {
        return getCommonServices().getDefaultUserRolesForProfessionals();
    }

    public List<ProfessionalDTO> getByNameLike(String pInput) {
        List<Professional> lResult = getDao().getByNameLike(StringUtils.lowerCase(pInput));
        List<ProfessionalDTO> lDtos = getConverter().getDtos(lResult);
        return lDtos;
    }

}
