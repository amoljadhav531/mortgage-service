package com.hcl.mortgage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * LoanOffers class represent the loan_offers table in database
 * @author amol.jadhav
 */
@Entity
@Table(name = "loan_offers")
public class LoanOffers {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "offer_id")
	private int offerId;
	
	@Column(name = "loan_amount")
	private double loanAmount;
	
	private int tenure;
	
	@Column(name = "rate_of_interest")
	private double roi;
	
	@Column(name = "EMI")
	private double emi;

	public int getOfferId() {
		return offerId;
	}

	public void setOfferId(int offerId) {
		this.offerId = offerId;
	}

	public double getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(double loanAmount) {
		this.loanAmount = loanAmount;
	}

	public int getTenure() {
		return tenure;
	}

	public void setTenure(int tenure) {
		this.tenure = tenure;
	}

	public double getRoi() {
		return roi;
	}

	public void setRoi(double roi) {
		this.roi = roi;
	}

	public double getEmi() {
		return emi;
	}

	public void setEmi(double emi) {
		this.emi = emi;
	}
}
