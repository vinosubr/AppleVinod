package com.telusko.bank.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "customer_Sequence")
	@SequenceGenerator(name = "cusomer_Sequence",allocationSize = 1, initialValue = 2345,sequenceName = "CUSTOMER_SEQ")
	int accNo; 
	

	String name;
	float balance;
	
	@OneToMany(targetEntity=Transaction.class, mappedBy="customer",fetch = FetchType.EAGER,cascade = CascadeType.ALL, orphanRemoval = true)
	List<Transaction> transactions = new ArrayList<>();
	
	public int getAccNo() {
		return accNo;
	}
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}
	
	
	@Override
	public String toString() {
		return "Customer [accNo=" + accNo + ", name=" + name + ", balance=" + balance + "]";
	}
	
}
