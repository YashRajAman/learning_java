package com.accont.bank.useraccount;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "UserAccount")
public class UserAccount {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Nonnull
	@Size(min=3)
	private String name;
	
	private String accountNumber;
	
	@Nonnull
	private String address;
	
	@Nonnull
	private String mobileNo;
	
	@Nonnull
	private float openingBalance;
	private float totalAmount;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public float getOpeningBalance() {
		return openingBalance;
	}

	public void setOpeningBalance(float openingBalance) {
		this.openingBalance = openingBalance;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	@Override
	public String toString() {
		
		String returnValue = String.format("Id: %d \nName: %s \n"
				+ "Address: %s \nMobile No.: %s \nAccount No.: %s \n"
				+ "Opening Balance: %f \nTotal Balance: %f",
				this.id, this.name, this.address, this.mobileNo, 
				this.accountNumber, this.openingBalance, this.totalAmount);
		return returnValue;
	}

}
