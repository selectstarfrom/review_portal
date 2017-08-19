package com.reviewportal.model.entities;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author imfroz
 *
 */
@Entity
@Table(name = "PROFESSIONAL")
public class Professional extends AbstractMember {

    @ManyToOne(fetch=FetchType.EAGER, cascade = CascadeType.MERGE)
    private Profession profession;

    public Professional() {
        super();
    }

    public Professional(Long pId, String pName, String pProfessionTitle) {
        super();
        this.id = pId;
        this.name = pName;
        profession = new Profession();
        this.profession.setTitle(pProfessionTitle);
    }

    public Profession getProfession() {
        return profession;
    }

    public void setProfession(Profession pProfession) {
        profession = pProfession;
    }

}
