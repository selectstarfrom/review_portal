package com.reviewportal.service.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.reviewportal.model.entities.ReviewWriter;

/**
 * @author imfroz
 *
 */
// @formatter:off
//@JsonIgnoreProperties(ignoreUnknown = true)
//@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY)
//@JsonSubTypes({
//    @JsonSubTypes.Type(value = OfficialDTO.class, name = "Official"),
//    @JsonSubTypes.Type(value = ReviewWriter.class, name = "ReviewWriter") }
//)
//@formatter:on
public abstract class AbstractMemberDTO extends AbstractDTO {

	protected String name;

	protected Date dateofBirth;

	protected String mobile;

	protected AddressDTO address;

	protected String membershipType;

	protected UserDTO user;

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
		return address= address==null? new AddressDTO(): address;
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
