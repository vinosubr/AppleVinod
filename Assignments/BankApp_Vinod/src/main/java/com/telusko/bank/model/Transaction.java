package com.telusko.bank.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "Transaction")
public class Transaction {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "transaction_Sequence")
	@SequenceGenerator(name = "transaction_Sequence",sequenceName = "TRANSACTION_SEQ")
	int transactionId;
	Date transactionDate;
	
	String description;	 
	float credit;	
	float debit;
	float totalbalance;
	
	
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name="acc_no")
	Customer customer;	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	public int getTransactionId() {
		return transactionId;
	}
	
	public Transaction(String description, float credit, float debit, float totalbalance) {
		super();
		this.description = description;
		this.credit = credit;
		this.debit = debit;
		this.totalbalance = totalbalance;
	}

	public Transaction() {
		super();
	}

	public Transaction(int transactionId, Date transactionDate, String description, float credit, float debit,
			float totalbalance) {
		super();
		this.transactionId = transactionId;
		this.transactionDate = transactionDate;
		this.description = description;
		this.credit = credit;
		this.debit = debit;
		this.totalbalance = totalbalance;
	}

	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public float getCredit() {
		return credit;
	}
	public void setCredit(float credit) {
		this.credit = credit;
	}
	public float getDebit() {
		return debit;
	}
	public void setDebit(float debit) {
		this.debit = debit;
	}
	public float getTotalbalance() {
		return totalbalance;
	}
	public void setTotalbalance(float totalbalance) {
		this.totalbalance = totalbalance;
	}
	@Override
	public String toString() {
		return "Transaction [transactionId=" + transactionId + ", transactionDate=" + transactionDate + ", description=" + description + ", credit=" + credit + ", debit=" + debit
				+ ", totalbalance=" + totalbalance + "]";
	}
	
	
}
