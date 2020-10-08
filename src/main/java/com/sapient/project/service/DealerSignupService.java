package com.sapient.project.service;

import com.sapient.project.model.DealerSignup;



public interface DealerSignupService {
	 public DealerSignup save(DealerSignup dealer);
	 public boolean existsUserid(String userid);
	 public boolean existsDealerid(Long userid);
	 public boolean existsMailid(String userid);
	 public boolean existsPhoneNumber(Long userid);

}
