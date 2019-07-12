package com.hcl.mortgage.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * UserDetails class represent the user_details table in database
 * @author amol.jadhav
 */
@Entity
@Table(name = "user_details")
public class UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String name;
	
	@Column(name = "date_of_birth")
	private LocalDate dob;
	
	private String gender;
	
	private double salary;
	
	private String PAN_no;
	
	@Column(name = "property_type")
	private String propertyType;
	
	@Column(name = "property_address")
	private String propertyAddress;
	
	@Column(name = "property_area")
	private int propertyArea;
	
	@Column(name = "pin_code")
	private int pinCode;

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

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getPAN_no() {
		return PAN_no;
	}

	public void setPAN_no(String pAN_no) {
		PAN_no = pAN_no;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public int getPropertyArea() {
		return propertyArea;
	}

	public void setPropertyArea(int propertyArea) {
		this.propertyArea = propertyArea;
	}
}
