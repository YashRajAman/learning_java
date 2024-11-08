package com.accont.bank.repository;

import org.springframework.data.repository.CrudRepository;

import com.accont.bank.useraccount.UserAccount;

public interface AccountRepository extends CrudRepository<UserAccount, Long>{
	
	UserAccount findByMobileNo(String mobileNo);
	
	UserAccount findByAccountNumber(String accountNumber);
	
	void deleteByAccountNumber(String accountNumber);

}
