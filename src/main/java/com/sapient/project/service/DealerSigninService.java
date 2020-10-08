package com.sapient.project.service;

import com.sapient.project.exception.DealerSigninException;
import com.sapient.project.model.DealerSignin;

public interface DealerSigninService {
	public boolean validateDealer(DealerSignin dealer) throws DealerSigninException;
}
