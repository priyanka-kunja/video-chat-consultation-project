package com.sapient.project.data;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.project.model.DealerSignup;



@Repository
public interface DealerSignupRepository  extends JpaRepository<DealerSignup,String> {
	public DealerSignup findByuserId(String userid);
	public DealerSignup findBydealerId(Long dealerid);
	public DealerSignup findBymailId(String mailid);
	public DealerSignup findByphoneNumber(Long phonenumber);
	
}
