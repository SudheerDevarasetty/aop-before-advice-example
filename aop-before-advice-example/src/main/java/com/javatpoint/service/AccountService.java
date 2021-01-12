package com.javatpoint.service;

import com.javatpoint.model.Account;

//creating interface that throws exception if the customer id not found   
public interface AccountService {
	public Account getAccountByCustomerId(String customerId) throws Exception;
}