package com.telusko.bank.restcontroller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.bank.model.Customer;
import com.telusko.bank.model.CustomerRepo;
import com.telusko.bank.model.Transaction;
import com.telusko.bank.model.TransactionRepo;
import com.telusko.bank.model.TransferMoney;

@RestController
public class TransferMoneyController {
	@Autowired
	TransactionRepo transactionRepo;
	@Autowired
	CustomerRepo custRepo;
	
	//Debit (Take Money Out)
	//Credit (Add Money to Account)
	@PostMapping("/transfer")
	public void transferMoney(@RequestBody TransferMoney money) {
		String description = " TPT from "+money.getSourceCustId()+" to "+money.getDestCustId();
		//Get the Source Customer and deduct the Money
		Optional<Customer> srcCustomer=  custRepo.findById(money.getSourceCustId());		
		Customer srcCustomer_Entity = srcCustomer.get();
		float sourcebalance = srcCustomer_Entity.getBalance()-money.getAmount();
		srcCustomer_Entity.setBalance(sourcebalance);		
		//Add a Transaction showing the above
		Transaction sourcetrans = new Transaction(description,0,money.getAmount(),sourcebalance);
		srcCustomer_Entity.getTransactions().add(sourcetrans);
		//Get the destination Customer and add the Money
		Optional<Customer> destCustomer=  custRepo.findById(money.getDestCustId());
		Customer destCustomer_Entity=destCustomer.get();
		float destbalance = destCustomer_Entity.getBalance()+money.getAmount();
		destCustomer_Entity.setBalance(destbalance);
		//Add a Transaction showing the above		
		Transaction desttrans = new Transaction(description,money.getAmount(),0,destbalance);
		destCustomer_Entity.getTransactions().add(desttrans);
		custRepo.save(srcCustomer_Entity);
		custRepo.save(destCustomer_Entity);		
	}	
}
