package com.koreait.beans;
/*
 * CREATE TABLE table_member(
	num NUMBER PRIMARY KEY,
	id varchar2(500),
	name varchar2(500),
	password varchar2(500),
	gender varchar2(50),
	zipcode varchar2(50),
	address varchar2(500),
	addressdetail varchar2(500),
	addressetc varchar2(500)
);
 * */
public class TABLE_MEMBER_VO {
	private String id;
	private String num;
	private String name;
	private String password;
	private String gender;
	private String zipcode;
	private String address;
	private String addressdetail;
	private String addressetc;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddressdetail() {
		return addressdetail;
	}
	public void setAddressdetail(String addressdetail) {
		this.addressdetail = addressdetail;
	}
	public String getAddressetc() {
		return addressetc;
	}
	public void setAddressetc(String addressetc) {
		this.addressetc = addressetc;
	}
	public TABLE_MEMBER_VO() {
		// TODO Auto-generated constructor stub
	}
	public String getNum() {
		return num;
	}
	public void setNum(String num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
}
