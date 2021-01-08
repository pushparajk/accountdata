package com.cosmos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountExtra {
	//@JsonProperty("SchemeName")

	private String schemeName;
	/* Identification assigned by an institution to identify an account. 
	 * This identification is known by the account owner. Max256Text*/
	//@JsonProperty("Identification")

	private String identification;
	/* The account name is the name or names of the account owner(s) represented at an account 
	 * level, as displayed by the ASPSP's online channels. Note, the account name is not the 
	 * product name or the nickname of the account.Max350Text*/
	//@JsonProperty("Name")

	private String name;
	/*  This is secondary identification of the account, as assigned by the account servicing 
	 * institution. This can be used by building societies to additionally identify accounts 
	 * with a roll number (in addition to a sort code and account number combination).Max34Text*/
	//@JsonProperty("SecondaryIdentification")

	private String secondaryIdentification;
	
	public String getSchemeName() {
		return schemeName;
	}
	public void setSchemeName(String schemeName) {
		this.schemeName = schemeName;
	}
	public String getIdentification() {
		return identification;
	}
	public void setIdentification(String identification) {
		this.identification = identification;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSecondaryIdentification() {
		return secondaryIdentification;
	}
	public void setSecondaryIdentification(String secondaryIdentification) {
		this.secondaryIdentification = secondaryIdentification;
	}

}
