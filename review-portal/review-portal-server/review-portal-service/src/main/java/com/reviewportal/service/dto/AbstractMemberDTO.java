package com.reviewportal.service.dto;

import java.util.Date;

import com.reviewportal.model.enums.Gender;
import com.reviewportal.model.enums.MembershipType;

/**
 * @author imfroz
 *
 */
public abstract class AbstractMemberDTO extends AbstractDTO {

    protected String name;

    protected Date dateofBirth;

    protected String mobile;

    protected AddressDTO address;

    protected MembershipType membershipType;

    protected Gender gender;

    protected UserDTO user;

    public AbstractMemberDTO() {
        super();
        user = new UserDTO();
        address = new AddressDTO();
    }

    public AbstractMemberDTO(Long pId, Date pCreatedDate, String pCreatedBy, Date pModifiedDate, String pModifiedBy) {
        super(pId, pCreatedDate, pCreatedBy, pModifiedDate, pModifiedBy);
        user = new UserDTO();
        address = new AddressDTO();
    }

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

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO pAddress) {
        address = pAddress;
    }

    public MembershipType getMembershipType() {
        return membershipType;
    }

    public void setMembershipType(MembershipType pMembershipType) {
        membershipType = pMembershipType;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender pGender) {
        gender = pGender;
    }

    @Override
    public String toString() {
        return "AbstractMemberDTO [name=" + name + ", dateofBirth=" + dateofBirth + ", mobile=" + mobile + ", address="
                + address + ", membershipType=" + membershipType + ", gender=" + gender + ", user=" + user + "]";
    }

}
