package com.hcl.mortgage.model;

import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * UserModel class used as request body model
 * @author amol.jadhav
 */
public class UserModel {

	@NotBlank
	@NotNull
	private String name;
	
	@NotNull
	private LocalDate dob;
	
	@NotBlank
	@NotNull
	private String gender;
	
	@NotNull
	private double salary;
	
	@NotBlank
	@NotNull
	@Length(min = 10,max = 10)
	private String PAN_no;
	
	@NotBlank
	@NotNull
	private String propertyType;
	
	@NotBlank
	@NotNull
	private String propertyAddress;
	
	@NotNull
	private int pinCode;
	
	@NotNull
	private int propertyArea;

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
