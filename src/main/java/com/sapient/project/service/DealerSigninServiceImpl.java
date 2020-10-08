package com.sapient.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.project.data.DealerSigninRepository;
import com.sapient.project.model.DealerSignin;
import com.sapient.project.model.DealerSignup;

@Service
@Transactional
public class DealerSigninServiceImpl implements DealerSigninService{

	@Autowired
	public DealerSigninRepository repository;
	
	@Override
	public boolean validateDealer(DealerSignin dealer) {
		DealerSignup dealerObject=repository.findByuserId(dealer.getUserId());
		if((dealerObject.getPassword()).equals(dealer.getPassword()))
		{
			return true;
		}
		return false;
	}

}
