package com.javatpoint.model;

public class Account {

	private String accountNumber;  
	private String accountType;
	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}
	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public Account(String accountNumber, String accountType) {
		super();
		this.accountNumber = accountNumber;
		this.accountType = accountType;
	}
	
}
