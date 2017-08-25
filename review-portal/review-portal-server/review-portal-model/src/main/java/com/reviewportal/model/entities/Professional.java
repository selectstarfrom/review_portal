package com.reviewportal.model.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * @author imfroz
 *
 */
@Entity
@Table(name = "PROFESSIONAL")
public class Professional extends AbstractMember {

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    private Profession profession;

    @OneToMany(mappedBy = "reviewAbout", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProfessionReview> reviews;

    private Integer rating;

    // @Formula("(select count(r) from ProfessionReview r where r.reviewAbout.id
    // = id)")
    @Transient
    private Long reviewCount;

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

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer pRating) {
        rating = pRating;
    }

    public List<ProfessionReview> getReviews() {
        return reviews;
    }

    public void setReviews(List<ProfessionReview> pReviews) {
        reviews = pReviews;
    }

    public Long getReviewCount() {
        return reviewCount;
    }

    public void setReviewCount(Long pReviewCount) {
        reviewCount = pReviewCount;
    }

    @PostLoad
    private void onLoad() {
        this.setReviewCount((long) getReviews().size());
    }

}
