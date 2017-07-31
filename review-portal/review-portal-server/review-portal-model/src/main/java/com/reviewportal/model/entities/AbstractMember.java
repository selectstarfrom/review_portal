package com.reviewportal.model.entities;

import java.util.Date;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

/**
 * @author imfroz
 *
 */
@MappedSuperclass
public abstract class AbstractMember extends AbstractEntity {

	private String name;

	private Date dateofBirth;

	private String mobile;

	@OneToOne
	private Address address;

	private String membershipType;

	@OneToOne
	private User user;

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

	public String getMembershipType() {
		return membershipType;
	}

	public void setMembershipType(String pMembershipType) {
		membershipType = pMembershipType;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User pUser) {
		user = pUser;
	}

}
