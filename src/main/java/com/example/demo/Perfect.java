package com.example.demo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Perfect{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String dob;
	private String gender;
	private String qualification;
	private String height;
	private String address;
	private String phone;
	private String caste;
	@Column(length=1000000)
	private byte[] image;
	
	
	public Perfect() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Perfect(int id, String name, String dob,String gender, String qualification, String height, String address, String phone,String caste,
			byte[] image) {
		super();
		this.id = id;
		this.name = name;
		this.dob = dob;
		this.gender=gender;
		this.qualification = qualification;
		this.height = height;
		this.address = address;
		this.phone = phone;
		this.caste=caste;
		this.image = image;
	}
	public Perfect(String name, String dob,String gender, String qualification, String height, String address, String phone,String caste,
			byte[] image) {
		super();
		this.name = name;
		this.dob = dob;
		this.gender=gender;
		this.qualification = qualification;
		this.height= height;
		this.address = address;
		this.phone = phone;
		this.caste=caste;
		this.image = image;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDOb() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob= dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender= gender;
	}
	public String getQualification() {
		return qualification;
	}
	public void setQualification(String qualification) {
		this.qualification= qualification;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getCaste() {
		return caste;
	}
	public void setCaste(String caste) {
		this.caste = caste;
	}
	public byte[] getImage() {
		return image;
	}
	public void setImage(byte[] image) {
		this.image = image;
	}
	
	
	
	
	
}