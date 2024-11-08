package com.accont.bank.service;

import com.accont.bank.useraccount.UserAccount;

public interface AccountServices {
	
	UserAccount openAccount(UserAccount user);
	
	UserAccount getAccountDetails(String accOrMob) throws Exception;
	
	
	String depositBalance(String accountNumber, float amount);
	
	String withdrawBalance(String accountNumber, float amount);


}
