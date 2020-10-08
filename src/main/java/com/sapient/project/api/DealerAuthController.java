package com.sapient.project.api;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.sapient.project.exception.DealerSigninException;
import com.sapient.project.exception.DealerSignupException;
import com.sapient.project.model.DealerSignin;
import com.sapient.project.model.DealerSignup;
import com.sapient.project.response.ResponseMessage;
import com.sapient.project.service.DealerSigninServiceImpl;
import com.sapient.project.service.DealerSignupServiceImpl;


@RestController
@RequestMapping("/api")
@CrossOrigin
public class DealerAuthController {
	@Autowired
	private DealerSignupServiceImpl dealerSignupService;
	
	@Autowired
	private DealerSigninServiceImpl dealerSigninService;
	

	
	//http://localhost:8081/api/signup
	/*{​​​​
        "userId": "asd5997",
        "dealerId": 1004,
        "password": "2010-10-15",       
        "mailId": "asdxyz@.com",
        "phoneNumber": 94540762469
   }*/

	@PostMapping("/signup")
	public ResponseEntity<ResponseMessage> registerDealer(@Valid @RequestBody DealerSignup dealer) throws DealerSignupException
	{
		ResponseMessage message;
		if (dealerSignupService.existsDealerid(dealer.getDealerId())) {
			 message=new ResponseMessage("Error: Dealer already registered!");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
		if (dealerSignupService.existsUserid(dealer.getUserId())) {
			message=new ResponseMessage("Error: UserID is already taken!");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
		if (dealerSignupService.existsMailid(dealer.getMailId())) {
			 message=new ResponseMessage("Error: Invalid mailId!");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
		if (dealerSignupService.existsPhoneNumber(dealer.getPhoneNumber())) {
			message=new ResponseMessage("Error: Invalid Phone number!");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		}
		try {
		DealerSignup saved=dealerSignupService.save(dealer);
		message=new ResponseMessage("Registered Successfully");
		return new ResponseEntity<>(message, HttpStatus.CREATED);
		}
		catch(DealerSignupException e)
		{
			throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR,e.getMessage());
		}

	}
		
		
	//http://localhost:8081/api/signin
	@PostMapping("/signin")
	public ResponseEntity<ResponseMessage> authenticateUser(@Valid @RequestBody DealerSignin dealer) 
	{
		ResponseMessage message;
		try {
			if(!dealerSignupService.existsUserid(dealer.getUserId()))
				{
				message=new ResponseMessage("Invalid UserID or password!");
				return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
				}
		} catch (DealerSignupException e) {
			e.printStackTrace();
		}
		try {
			if (!dealerSigninService.validateDealer(dealer)) {
				message=new ResponseMessage("Invalid UserID or password!");
				return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
			}
		} catch (DealerSigninException e) {
			
			e.printStackTrace();
		}
			return new ResponseEntity<>(new ResponseMessage("Successful login"), HttpStatus.CREATED);
	
	}

	
}
