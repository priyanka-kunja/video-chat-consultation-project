package com.sapient.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.project.data.DealerSignupRepository;
import com.sapient.project.model.DealerSignup;
import com.sapient.project.exception.DealerSignupException;

@Service
@Transactional
public class DealerSignupServiceImpl implements DealerSignupService{


	@Autowired
	public DealerSignupRepository repository;
	
	

	@Override
	public DealerSignup save(DealerSignup dealer) throws DealerSignupException{
		try {
			DealerSignup dealerObject =  repository.save(dealer);	
			return dealerObject;
		}
		catch(DataAccessException e) {
			//log.error(e.getMessage(), e);
			throw new DealerSignupException(e.getMessage(),e);
		}


			
	}



	@Override
	public boolean existsDealerid(Long dealerid) throws DealerSignupException {
		if(repository.findBydealerId(dealerid)!=null) {
			return true;
		}
		return false;
	}



	@Override
	public boolean existsMailid(String mailid) throws DealerSignupException{
		if(repository.findBymailId(mailid)!=null)
		{
			return true;
		}
		return false;
	}



	@Override
	public boolean existsPhoneNumber(Long phonenumber) throws DealerSignupException {
		if(repository.findByphoneNumber(phonenumber)!=null)
		{
			return true;
		}
		return false;
	}



	@Override
	public boolean existsUserid(String userid) throws DealerSignupException{
		if(repository.findByuserId(userid)!=null)
		{
			return true;
		}
		return false;
	}



	
		
}
