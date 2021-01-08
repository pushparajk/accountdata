package com.cosmos.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cosmos.AccountsApplication;
import com.cosmos.models.Account;
import com.cosmos.models.AccountDetail;
import com.cosmos.services.AccountService;

@RestController
@RequestMapping("/api/v1/accounts")
public class AccountController {
	final Logger log = LogManager.getLogger(AccountController.class);
	@Autowired
	private AccountService accountService;
	
	@CrossOrigin
	@GetMapping
    public List<Account> list(){
		log.info("inside List()");
        return accountService.getAccounts();
    }

	@CrossOrigin
	@GetMapping
    @RequestMapping("{id}")

    public AccountDetail getAccountDetail(@PathVariable String id,@RequestHeader(name = "user_name", required = false) String username){
		System.out.println("username = "+username);
        return accountService.getAccountDetails(id);
    }

}
