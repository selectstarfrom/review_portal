package com.reviewportal.model.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

import com.reviewportal.model.enums.Gender;
import com.reviewportal.model.enums.MembershipType;

/**
 * @author imfroz
 *
 */
@MappedSuperclass
public abstract class AbstractMember extends AbstractEntity {

    protected String name;

    protected Date dateofBirth;

    protected String mobile;

    @OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    protected Address address;

    @Enumerated(EnumType.STRING)
    protected MembershipType membershipType;

    @Enumerated(EnumType.STRING)
    protected Gender gender;

    @OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
    protected User user;

    public String getName() {
        return name;
    }

    public void setName(String pName) {
        name = pName;
    }

    public Date getDateofBirth() {
        return dateofBirth;
    }

    public void setDateofBirth(Date pDateofBirth) {
        dateofBirth = pDateofBirth;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String pMobile) {
        mobile = pMobile;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address pAddress) {
        address = pAddress;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType pMembershipType) {
        membershipType = pMembershipType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User pUser) {
        user = pUser;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender pGender) {
        gender = pGender;
    }

}
