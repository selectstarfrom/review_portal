package com.reviewportal.service.dto;

import java.util.Date;

/**
 * @author imfroz
 *
 */
public class AddressDTO extends AbstractDTO {

	private String city;

	private String state;

	private String zip;

	private String country;

	private String address;

	public AddressDTO() {
		super();
	}

	public AddressDTO(String pCity, String pState, String pZip, String pCountry, String pAddress) {
		super();
		city = pCity;
		state = pState;
		zip = pZip;
		country = pCountry;
		address = pAddress;
	}

	public AddressDTO(String pCity, String pState, String pZip, String pCountry, String pAddress, Long pId,
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

	public String getZip() {
		return zip;
	}

	public void setZip(String pZip) {
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
