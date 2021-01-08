package com.cosmos.services;

import java.util.List;

import com.cosmos.models.Account;
import com.cosmos.models.AccountDetail;

public interface AccountService {

	public List<Account> getAccounts();
	
	public AccountDetail getAccountDetails(String id);
}
