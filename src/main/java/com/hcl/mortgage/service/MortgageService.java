package com.hcl.mortgage.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.hcl.mortgage.entity.LoanOffers;
import com.hcl.mortgage.entity.PropertyRates;
import com.hcl.mortgage.entity.UserDetails;
import com.hcl.mortgage.exception.PINCodeNotFoundException;
import com.hcl.mortgage.exception.UserEligibilityException;
import com.hcl.mortgage.model.UserModel;
import com.hcl.mortgage.repository.LoanOfferRepository;
import com.hcl.mortgage.repository.PropertyRatesRepository;
import com.hcl.mortgage.repository.UserRepository;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

/**
 * MortgageService class used for to mortgage loan offer services
 * 
 * @author amol.jadhav
 */
@Service
public class MortgageService {

	@Autowired
	private Environment env;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private LoanOfferRepository loanOfferRepository;

	@Autowired
	private PropertyRatesRepository propertyRatesRepository;

	/**
	 * Method is used to serve the purpose of finding matching available loan offer
	 * for user
	 * 
	 * @param userModel object contain details required for providing the loan offer
	 * @return List<LoanOffers>
	 * @throws PINCodeNotFoundException custom exception
	 * @throws UserEligibilityException
	 */
	public List<LoanOffers> loanOffers(UserModel userModel) throws PINCodeNotFoundException, UserEligibilityException {

		UserDetails userDetails = new UserDetails();
		BeanUtils.copyProperties(userModel, userDetails);
		userDetails = userRepository.save(userDetails);
		Optional<PropertyRates> propRates = propertyRatesRepository.findById(userDetails.getPinCode());

		if (propRates.isPresent()) {
			PropertyRates propertyRates = propRates.get();
			final double propertyAmount = propertyRates.getPropertySqureFeetPrice() * userDetails.getPropertyArea();
			final double eligibleLoanAmount = getEligibleLoanAmount(propertyAmount);

			if (checkUserEligibility(getAge(userDetails.getDob()), userDetails.getSalary(), propertyAmount)) {
				return loanOfferRepository.findByLoanAmountLessThanEqual(eligibleLoanAmount);
			}

		} else {
			throw new PINCodeNotFoundException("Incorrect PIN code");
		}
		return null;
	}

	/**
	 * Method is used as utility to provide eligible loan ammount of user
	 * 
	 * @param pinNumber    user pin code number
	 * @param propertyArea property area in sq. feet
	 * @return loan value
	 * @throws PINCodeNotFoundException custom exception
	 */
	private double getEligibleLoanAmount(double propertyAmount) {

		return propertyAmount * (env.getProperty("loan.percentage", Integer.class) / 100.0);

	}

	private int getAge(LocalDate dob) {
		return Period.between(dob, LocalDate.now()).getYears();
	}

	private boolean checkUserEligibility(int age, double salary, double propertyValue) throws UserEligibilityException {

		if (age < env.getProperty("user.eligibility.age", Integer.class))
			throw new UserEligibilityException("Age must be above 25 Years");
		else if (salary < env.getProperty("user.eligibility.salary", Double.class))
			throw new UserEligibilityException("Salary must be above 10K");
		else if (propertyValue < env.getProperty("user.eligibility.property.value", Double.class))
			throw new UserEligibilityException("property value must be above 5 Lacks");

		return true;
	}
}
