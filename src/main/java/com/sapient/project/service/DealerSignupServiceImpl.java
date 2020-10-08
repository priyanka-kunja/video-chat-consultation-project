package com.sapient.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.project.data.DealerSignupRepository;
import com.sapient.project.model.DealerSignup;

@Service
@Transactional
public class DealerSignupServiceImpl implements DealerSignupService{


	@Autowired
	public DealerSignupRepository repository;
	
	

	@Override
	public DealerSignup save(DealerSignup dealer) {
		//try {
			DealerSignup dealerObject =  repository.save(dealer);			
		//}
		//catch(Exception e) {
			//log.error(e.getMessage(), e);
			//throw new Exception(e.getMessage(),e);
	//}
		
		//return null;
			return dealerObject;
	}



	@Override
	public boolean existsDealerid(Long dealerid) {
		if(repository.findBydealerId(dealerid)!=null) {
			return true;
		}
		return false;
	}



	@Override
	public boolean existsMailid(String mailid) {
		if(repository.findBymailId(mailid)!=null)
		{
			return true;
		}
		return false;
	}



	@Override
	public boolean existsPhoneNumber(Long phonenumber) {
		if(repository.findByphoneNumber(phonenumber)!=null)
		{
			return true;
		}
		return false;
	}



	@Override
	public boolean existsUserid(String userid) {
		if(repository.findByuserId(userid)!=null)
		{
			return true;
		}
		return false;
	}



	
		
}
