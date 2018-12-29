package com.telusko.bank.model;

public class TransferMoney {
	int sourceCustId;
	int destCustId;
	float amount;
	String description;
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getSourceCustId() {
		return sourceCustId;
	}
	public void setSourceCustId(int sourceCustId) {
		this.sourceCustId = sourceCustId;
	}
	public int getDestCustId() {
		return destCustId;
	}
	public void setDestCustId(int destCustId) {
		this.destCustId = destCustId;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	
}
