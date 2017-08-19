package com.reviewportal.service.dto;

/**
 * @author imfroz
 *
 */
public class ProfessionalDTO extends AbstractMemberDTO {

    private ProfessionDTO profession;

    public ProfessionalDTO() {
        super();
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
