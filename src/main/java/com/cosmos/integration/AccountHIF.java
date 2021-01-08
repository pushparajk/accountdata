package com.cosmos.integration;

import java.util.List;

import com.cosmos.models.Account;
import com.cosmos.models.AccountDetail;

public interface AccountHIF {
	
	public List<Account> findAll();
	
	public AccountDetail getAccountDetails(String id);
	
}
