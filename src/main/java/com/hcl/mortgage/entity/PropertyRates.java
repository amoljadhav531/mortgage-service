package com.hcl.mortgage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * PropertyRates class represent the property_rates table in database
 * @author amol.jadhav
 */
@Entity
@Table(name = "property_rates")
public class PropertyRates {
	
	@Id
	@Column(name = "pin_code")
	private int pinCode;
	
	@Column(name = "property_squre_feet_price")
	private double propertySqureFeetPrice;

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public double getPropertySqureFeetPrice() {
		return propertySqureFeetPrice;
	}

	public void setPropertySqureFeetPrice(double propertySqureFeetPrice) {
		this.propertySqureFeetPrice = propertySqureFeetPrice;
	}
		
}
