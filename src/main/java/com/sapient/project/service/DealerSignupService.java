package com.sapient.project.service;

import com.sapient.project.exception.DealerSignupException;
import com.sapient.project.model.DealerSignup;




public interface DealerSignupService {
	 public DealerSignup save(DealerSignup dealer) throws DealerSignupException;
	 public boolean existsUserid(String userid) throws DealerSignupException;
	 public boolean existsDealerid(Long userid) throws DealerSignupException;
	 public boolean existsMailid(String userid) throws DealerSignupException;
	 public boolean existsPhoneNumber(Long userid) throws DealerSignupException;




}
