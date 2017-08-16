package com.reviewportal.service.dto;

import javax.persistence.ManyToOne;

/**
 * @author imfroz
 *
 */
public class OfficialDTO extends AbstractMemberDTO {

    private ProfessionDTO profession;

    public OfficialDTO() {
        super();
        profession = new ProfessionDTO();
    }

    public ProfessionDTO getProfession() {
        return profession;
    }

    public void setProfession(ProfessionDTO pProfession) {
        profession = pProfession;
    }

}
