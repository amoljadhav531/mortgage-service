package com.hcl.mortgage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.mortgage.entity.LoanOffers;

/**
 * LoanOfferRepository interface represent the loan_offers table repository
 * @author amol.jadhav
 */
@Repository
public interface LoanOfferRepository extends JpaRepository<LoanOffers, Integer>{
	
	/**
	 * Method returns the list of offer available for user
	 * @param loanAmount user loan amount
	 * @return
	 */
	public List<LoanOffers> findByLoanAmountLessThanEqual(double loanAmount);

}
