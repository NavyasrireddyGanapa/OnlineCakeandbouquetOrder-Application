package com.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class UserAddress {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty
	@Size(max = 300,message = "please include Address1")
	private String address1;
	@NotEmpty
	@Size(max = 300,message = "please include Address2")
	private String address2;
	@NotEmpty
	@Size(max = 30,message = "please include landmark")
	private String landmark;
	@NotEmpty
	@Size(max = 30,message = "please include district")
	private String district;
	@NotEmpty
	@Size(max = 30,message = "please include state")
	private String state;
	@NotEmpty
	@Size(max = 30,message = "please include pincode")
	private String pincode;
	@NotEmpty
	@Size(max = 30,message = "please include country")
	private String country;
	@NotEmpty
	@Size(min = 10,message = "please include phone")
	private String contactnumber;
	public UserAddress() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserAddress(int id, String address1, String address2, String landmark, String district, String state,
			String pincode, String country, String contactnumber) {
		super();
		this.id = id;
		address1 = address1;
		address2 = address2;
		this.landmark = landmark;
		this.district = district;
		this.state = state;
		this.pincode = pincode;
		this.country = country;
		this.contactnumber = contactnumber;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getLandmark() {
		return landmark;
	}
	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}
	

}
