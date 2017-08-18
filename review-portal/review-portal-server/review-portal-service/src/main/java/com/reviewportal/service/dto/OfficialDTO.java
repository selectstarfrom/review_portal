package com.reviewportal.service.dto;

import com.reviewportal.model.enums.MembershipType;

/**
 * @author imfroz
 *
 */
public class OfficialDTO extends AbstractMemberDTO {

    private ProfessionDTO profession;

    public OfficialDTO() {
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

}
