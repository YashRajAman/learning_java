package com.accont.bank.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accont.bank.repository.AccountRepository;
import com.accont.bank.useraccount.UserAccount;

import jakarta.transaction.Transactional;

@Service
public class AccountServiceImplementation implements AccountServices {
	
	AccountRepository accountRepo;
	
	
	@Autowired
	public AccountServiceImplementation(AccountRepository accountRepo) {
		
		this.accountRepo = accountRepo;
		
	}
	
	
	@Transactional
	@Override
	public UserAccount openAccount(UserAccount user) {
		
		user.setAccountNumber(UUID.randomUUID().toString());
		user.setTotalAmount(user.getOpeningBalance());
		
		accountRepo.save(user);
	
		return user;
	}

	@Override
	public UserAccount getAccountDetails(String accOrMob) throws Exception {
		
		UserAccount user = accountRepo.findByMobileNo(accOrMob);
		
		if(user==null) user = accountRepo.findByAccountNumber(accOrMob);

		return user;
		
	}


	@Transactional
	@Override
	public String depositBalance(String accountNumber, float amount) {
		
		UserAccount user = accountRepo.findByAccountNumber(accountNumber);
		
		if (user != null) {
			
			user.setTotalAmount(amount + user.getTotalAmount());
			accountRepo.save(user);
			
		}
		
		
		return user.getAccountNumber() +" \n New Balance: " + user.getTotalAmount();
	}


	@Transactional
	@Override
	public String withdrawBalance(String accountNumber, float amount) {
		
		UserAccount user = accountRepo.findByAccountNumber(accountNumber);

		
		if (user != null && user.getTotalAmount() > amount) {
			
			user.setTotalAmount( user.getTotalAmount() - amount );
			accountRepo.save(user);
			return user.getAccountNumber() +" \n" + user.getTotalAmount();
			
		}
		
		else {
			
			return "Not sufficient fund.";
		}
		
	}
	
	
	

}
