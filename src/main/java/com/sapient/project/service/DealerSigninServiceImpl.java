package com.sapient.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.project.data.DealerSigninRepository;
import com.sapient.project.exception.DealerSigninException;
import com.sapient.project.exception.DealerSignupException;
import com.sapient.project.model.DealerSignin;
import com.sapient.project.model.DealerSignup;

@Service
@Transactional
public class DealerSigninServiceImpl implements DealerSigninService{

	@Autowired
	public DealerSigninRepository repository;
	
	@Override
	public boolean validateDealer(DealerSignin dealer) throws DealerSigninException {
		try {
			DealerSignup dealerObject=repository.findByuserId(dealer.getUserId());
			if((dealerObject.getPassword()).equals(dealer.getPassword()))
			{
				return true;
			}
			return false;
			
		}
		catch(DataAccessException e) {
			//log.error(e.getMessage(), e);
			throw new DealerSigninException(e.getMessage(),e);
		}
		
	}

}
