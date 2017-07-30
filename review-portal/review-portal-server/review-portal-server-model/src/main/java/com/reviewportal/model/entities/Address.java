package com.reviewportal.model.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author imfroz
 *
 */
@Entity
@Table(name = "ADDRESS")
public class Address extends AbstractEntity {

	private String city;

	private String state;

	private Date zip;

	private String country;

	private String address;

	public Address() {
		super();
	}

	public Address(String pCity, String pState, Date pZip, String pCountry, String pAddress) {
		super();
		city = pCity;
		state = pState;
		zip = pZip;
		country = pCountry;
		address = pAddress;
	}

	public Address(String pCity, String pState, Date pZip, String pCountry, String pAddress, Long pId,
			Date pCreatedDate, String pCreatedBy, Date pModifiedDate, String pModifiedBy) {
		super(pId, pCreatedDate, pCreatedBy, pModifiedDate, pModifiedBy);
		city = pCity;
		state = pState;
		zip = pZip;
		country = pCountry;
		address = pAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String pCity) {
		city = pCity;
	}

	public String getState() {
		return state;
	}

	public void setState(String pState) {
		state = pState;
	}

	public Date getZip() {
		return zip;
	}

	public void setZip(Date pZip) {
		zip = pZip;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String pCountry) {
		country = pCountry;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String pAddress) {
		address = pAddress;
	}

}
