package com.winter.app.account;

import java.util.Date;

public class AccountDTO {
	private Long accountNum;
	private String userName;
	private Long productNum;
	private Integer accountPW;
	private Date accountDate;
	private Long accountBalance;
	
	public Long getAccountNum() {
		return accountNum;
	}
	public void setAccountNum(Long accountNum) {
		this.accountNum = accountNum;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public Long getProductNum() {
		return productNum;
	}
	public void setProductNum(Long productNum) {
		this.productNum = productNum;
	}
	public Integer getAccountPW() {
		return accountPW;
	}
	public void setAccountPW(Integer accountPW) {
		this.accountPW = accountPW;
	}
	public Date getAccountDate() {
		return accountDate;
	}
	public void setAccountDate(Date accountDate) {
		this.accountDate = accountDate;
	}
	public Long getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(Long accountBalance) {
		this.accountBalance = accountBalance;
	}
	
	
}
