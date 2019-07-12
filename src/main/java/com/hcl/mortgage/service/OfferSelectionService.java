package com.hcl.mortgage.service;

import org.springframework.stereotype.Service;

import com.hcl.mortgage.entity.LoanOffers;
import com.hcl.mortgage.model.OfferSelectionModel;
import com.hcl.mortgage.repository.LoanOfferRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import java.util.Optional;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

@Service
public class OfferSelectionService {


    @Autowired
    private JavaMailSender sender;
    
    @Autowired
    private LoanOfferRepository loanOfferRepository;
    
    private final static String ACCOUNT_SID = "ACf73ecdd409fbbd7f4662253cd08f9e0b";
    private final static String AUTH_ID = "d099b8077232a16999136f93f243e697";
    
    static {
        Twilio.init(ACCOUNT_SID, AUTH_ID);
     }
    
	public boolean offerSelection(OfferSelectionModel selectionModel) {
		
		Optional<LoanOffers> lOffer = loanOfferRepository.findById(selectionModel.getOfferId());
		if(lOffer.isPresent()) {
			LoanOffers loanOffers = lOffer.get();
			String msg = createMessge(loanOffers);
			 sendMail(selectionModel, msg);	
			 return sendSMS(msg);
		}
		return false;
	}
	
	
	private boolean sendMail(OfferSelectionModel selectionModel,String msg) {
		try {
			MimeMessage message = sender.createMimeMessage();
	        MimeMessageHelper helper = new MimeMessageHelper(message);
	         
	        helper.setTo(selectionModel.getEmail());
	        helper.setText(msg);
	        helper.setSubject("Mortgage : Selected Offer Details");
	         
	       // sender.send(message);
		}catch (Exception e) {
			System.out.println(e);
			return false;
		}
		
		return true;
	}
	
	private String createMessge(LoanOffers loanOffers) {
		StringBuilder builder = new StringBuilder();
		builder.append("Loan Id : "+loanOffers.getOfferId())
		.append("Loan Amount : "+loanOffers.getLoanAmount())
		.append("Rate of Interest : "+loanOffers.getRoi())
		.append("Tenure : "+loanOffers.getTenure())
		.append("EMI : "+loanOffers.getEmi());
		
		return builder.toString();
	}
	
	private boolean sendSMS(String sms) {
		try {
		Message.creator(new PhoneNumber("+917798228279"), new PhoneNumber("+/////"),
		         "Message from Spring Boot Application").create();
		}catch(Exception ex) {
			System.out.println(ex);
			return false;
		}
		
		return true;		
	}
}
