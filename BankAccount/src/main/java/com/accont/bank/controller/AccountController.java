package com.accont.bank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accont.bank.repository.AccountRepository;
import com.accont.bank.service.AccountServices;
import com.accont.bank.useraccount.UserAccount;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired
	AccountServices accountService;
	
	@Autowired
	AccountRepository accRepo;
	
	
	@GetMapping("/status")
	public String home() {
		return "Welcome to Bank!";
	}
	
	@GetMapping("/getallaccounts")
	public List<UserAccount> getall(){
		return (List<UserAccount>) accRepo.findAll();
		
	}
	
	@GetMapping("/getaccount/{accOrMob}")
	public UserAccount getUserAccount(@PathVariable("accOrMob") String accOrMob) {
		
		try {
			return accountService.getAccountDetails(accOrMob);
		}
		catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
			return null;
		}
		
	}
	
	
	
	@PostMapping("/openaccount")
	public ResponseEntity<String> openAccount(@Validated @RequestBody UserAccount user) {
		
			try {
				return new ResponseEntity<>(accountService.openAccount(user).toString(), HttpStatus.CREATED);
			} catch (Exception e) {
				
				//e.printStackTrace();
				return new ResponseEntity<>(e.getLocalizedMessage(), HttpStatus.EXPECTATION_FAILED);
			}

	}
	
	
	@PutMapping("/deposit/{accountNumber}/{amount}")
	public String deposit(@PathVariable("accountNumber") String accountNumber, @PathVariable("amount") float amount) {
		
		return accountService.depositBalance(accountNumber, amount);
		
	}
	
	@PutMapping("/withdraw/{accountNumber}/{amount}")
	public String withdraw(@PathVariable("accountNumber") String accountNumber, @PathVariable("amount") float amount) {
		
		return accountService.withdrawBalance(accountNumber, amount);
		
	}
	
	@DeleteMapping("/delete/{accountNumber}")
	public ResponseEntity<String> deleteAccount(@PathVariable("accountNumber") String accountNumber) throws Exception {
		
		UserAccount user = accountService.getAccountDetails(accountNumber);
		
	
		try {
			accRepo.delete(user);
			
			return new ResponseEntity<>("Account Deleted.", HttpStatus.OK);
			
		} catch (Exception e) {
			
			return new ResponseEntity<>("Entity with provided account number not found \n"+e.getLocalizedMessage(), HttpStatus.NOT_FOUND);
		}
		
	}
	
}
