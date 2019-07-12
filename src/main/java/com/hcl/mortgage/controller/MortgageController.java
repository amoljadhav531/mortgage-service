package com.hcl.mortgage.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.mortgage.entity.LoanOffers;
import com.hcl.mortgage.exception.PINCodeNotFoundException;
import com.hcl.mortgage.model.UserModel;
import com.hcl.mortgage.service.MortgageService;

/**
 * MortgageController class provide API for banking Mortgage offers and services
 * @author amol.jadhav
 */
@RestController
@RequestMapping("/offers")
public class MortgageController {

	@Autowired
	private MortgageService mortgageService;

	/**
	 * Method used for API mapping to URL /offers
	 * 
	 * @param userModel Object having details required to get Loan offers
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> loanOffers(@Valid @RequestBody UserModel userModel) {

		try {
			List<LoanOffers> loanOffers = mortgageService.loanOffers(userModel);
			if (ObjectUtils.isEmpty(loanOffers))
				return new ResponseEntity<>("No offer matching for your loan amount", HttpStatus.NO_CONTENT);

			return new ResponseEntity<>(loanOffers, HttpStatus.OK);

		} catch (PINCodeNotFoundException ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
		} catch (Exception ex) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}

	}
}
