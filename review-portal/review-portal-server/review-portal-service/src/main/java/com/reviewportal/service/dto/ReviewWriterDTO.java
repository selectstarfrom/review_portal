package com.reviewportal.service.dto;

import java.util.Date;

/**
 * @author imfroz
 *
 */
public class ReviewWriterDTO extends AbstractMemberDTO {

	public ReviewWriterDTO() {
		super();
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

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String pMembershipType) {
		membershipType = pMembershipType;
	}

	public UserDTO getUser() {
		return user;
	}

	public void setUser(UserDTO user) {
		this.user = user;
	}

}
