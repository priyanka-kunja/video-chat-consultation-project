package com.sapient.project.data;

import javax.persistence.Column;
import javax.persistence.Id;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sapient.project.model.DealerSignup;

@Repository
public interface DealerSigninRepository extends JpaRepository<DealerSignup,String>{
	public DealerSignup findByuserId(String userid);
}
