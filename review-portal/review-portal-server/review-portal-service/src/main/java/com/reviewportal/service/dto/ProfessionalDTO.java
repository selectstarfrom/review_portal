package com.reviewportal.service.dto;

import com.reviewportal.model.enums.MembershipType;

/**
 * @author imfroz
 *
 */
public class ProfessionalDTO extends AbstractMemberDTO {

    private ProfessionDTO profession;

    public ProfessionalDTO() {
        super();
        setMembershipType(MembershipType.PROFESSIONAL);
        profession = new ProfessionDTO();
    }

    public ProfessionDTO getProfession() {
        return profession;
    }

    public void setProfession(ProfessionDTO pProfession) {
        profession = pProfession;
    }

    @Override
    public String toString() {
        return "ProfessionalDTO [profession=" + profession + "]";
    }

}
