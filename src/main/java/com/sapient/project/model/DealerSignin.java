package com.sapient.project.model;


import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class DealerSignin {
	
	@NotBlank
    private String userId;
	
	@NotBlank
	private String password;
}
