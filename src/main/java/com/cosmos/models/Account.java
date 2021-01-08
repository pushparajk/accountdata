package com.cosmos.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Account {

	/* A unique and immutable identifier used to identify the account resource. This identifier has no meaning to the account owner. Max40Text*/
	private String accountId;
	/*Specifies the status of account resource in code form.OBAccountStatus1Code
	 * Takes one of the value from {Enabled Disabled Deleted ProForma Pending}
	 * 	  */
private String status;
/* 	Identification of the currency in which the account is held. Usage: Currency should only 
 * be used in case one and the same account number covers several currencies and the 
 * initiating party needs to identify which currency needs to be 
 * used for settlement on the account. */
private String currency;
/* Specifies the type of account (personal or business). */
private String accountType;
/* Specifies the sub type of account (product family group) */
private String accountSubType;
/*  Specifies the description of the account type. */
private String description;
/* The nickname of the account, assigned by the account owner in order to provide 
 * an additional means of identification of the account. */
private String nickName;
/* Date on which the account and related basic services are effectively operational for the account owner. */
private String openingDate;
/*  Maturity date for the account.*/
private String maturityDate;
/*  The switch status for the account. OBExternalSwitchStatusCode*/
private String switchStatus;
/*  Name of the identification scheme, in a coded form as published in an external list. 
 * OBExternalAccountIdentification4Code*/
private String schemeName;
/* Identification assigned by an institution to identify an account. 
 * This identification is known by the account owner. Max256Text*/
private String identification;
/* The account name is the name or names of the account owner(s) represented at an account 
 * level, as displayed by the ASPSP's online channels. Note, the account name is not the 
 * product name or the nickname of the account.Max350Text*/
private String name;
/*  This is secondary identification of the account, as assigned by the account servicing 
 * institution. This can be used by building societies to additionally identify accounts 
 * with a roll number (in addition to a sort code and account number combination).Max34Text*/
private String secondaryIdentification;

private AccountExtra account;

public AccountExtra getAccount() {
	return account;
}
public void setAccount(AccountExtra account) {
	this.account = account;
}
public String getAccountId() {
	return accountId;
}
public String getAccountSubType() {
	return accountSubType;
}
public String getAccountType() {
	return accountType;
}
public String getCurrency() {
	return currency;
}
public String getDescription() {
	return description;
}
public String getIdentification() {
	return identification;
}
public String getMaturityDate() {
	return maturityDate;
}
public String getName() {
	return name;
}
public String getNickName() {
	return nickName;
}
public String getOpeningDate() {
	return openingDate;
}
public String getSchemeName() {
	return schemeName;
}
public String getSecondaryIdentification() {
	return secondaryIdentification;
}
public String getStatus() {
	return status;
}
public String getSwitchStatus() {
	return switchStatus;
}
public void setAccountId(String accountId) {
	this.accountId = accountId;
}
public void setAccountSubType(String accountSubType) {
	this.accountSubType = accountSubType;
}
public void setAccountType(String accountType) {
	this.accountType = accountType;
}
public void setCurrency(String currency) {
	this.currency = currency;
}
public void setDescription(String description) {
	this.description = description;
}
public void setIdentification(String identification) {
	this.identification = identification;
}
public void setMaturityDate(String maturityDate) {
	this.maturityDate = maturityDate;
}
public void setName(String name) {
	name = name;
}
public void setNickName(String nickName) {
	this.nickName = nickName;
}
public void setOpeningDate(String openingDate) {
	this.openingDate = openingDate;
}
public void setSchemeName(String schemeName) {
	this.schemeName = schemeName;
}
public void setSecondaryIdentification(String secondaryIdentification) {
	this.secondaryIdentification = secondaryIdentification;
}
public void setStatus(String status) {
	status = status;
}
public void setSwitchStatus(String switchStatus) {
	this.switchStatus = switchStatus;
}


}
