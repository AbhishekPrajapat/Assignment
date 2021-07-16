package com.company.assignment.controller.model;


public class Transaction {
	
	Integer id;
	
	Integer userId;
	
	String userName;
	
	String txnType;
	
	String amount;
	
	

	public Transaction(Integer id, Integer userId, String userName, String txnType, String amount) {
		super();
		this.id = id;
		this.userId = userId;
		this.userName = userName;
		this.txnType = txnType;
		this.amount = amount;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTxnType() {
		return txnType;
	}

	public void setTxnType(String txnType) {
		this.txnType = txnType;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", userId=" + userId + ", userName=" + userName + ", txnType=" + txnType
				+ ", amount=" + amount + "]";
	}
	
	

}
