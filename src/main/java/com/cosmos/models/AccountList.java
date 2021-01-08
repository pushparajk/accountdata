package com.cosmos.models;

import java.util.HashMap;
import java.util.Map;

public class AccountList {
	
	    private Map<String, Account> accounts = new HashMap<String, Account>();

	    public Map<String, Account> getAccounts() {
	        return accounts;
	    }

	    public void setUser(Map<String, Account> account) {
	        this.accounts = account;
	    }

	    @Override
	    public String toString() {
	        return "account{" +
	                "account=" + accounts+
	                '}';
	    }
}

