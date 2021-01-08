package com.cosmos.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cosmos.controllers.AccountController;
import com.cosmos.integration.AccountHIF;
import com.cosmos.integration.AccountHIFImpl;
import com.cosmos.models.Account;
import com.cosmos.models.AccountDetail;


@Service
public class AccountServiceImpl implements AccountService {
	final Logger log = LogManager.getLogger(AccountController.class);
	@Autowired
	private AccountHIFImpl accountRepository;

	
	@Override
	public List<Account> getAccounts() {
		log.info("inside getAccounts()");
		return accountRepository.findAll();
	}


	@Override
	public AccountDetail getAccountDetails(String id) {
		// TODO Auto-generated method stub
		return accountRepository.getAccountDetails(id);
	}

}
