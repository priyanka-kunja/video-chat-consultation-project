package com.sapient.project.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
@Entity
@Table(name = "Dealer_auth",
			uniqueConstraints = { 
					@UniqueConstraint(columnNames = "dealer_id"),
					@UniqueConstraint(columnNames = "dealer_mail"),
					@UniqueConstraint(columnNames = "dealer_phn_no")
					})
public class DealerSignup {
	@Id
	@Column(name = "dealer_userid")
    private String userId;
	
	@NotBlank
	@Column(name = "dealer_id")
	private Long dealerId;
	
	@NotBlank
	@Column(name = "dealer_password")
	private String password;
	
	@NotBlank
	@Column(name = "dealer_mail")
	private String mailId;
	
	@NotBlank
	@Column(name = "dealer_phn_no")
	private Long phoneNumber;
}
