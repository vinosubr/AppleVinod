package com.telusko.bank.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.bank.model.Customer;
import com.telusko.bank.model.CustomerRepo;
import com.telusko.bank.model.Transaction;
import com.telusko.bank.model.TransactionRepo;

@RestController
public class TransactionController {
	@Autowired
	TransactionRepo repo;
	@Autowired
	CustomerRepo custrepo;
	@PostMapping("/customer/{accNo}/transaction")
	public void addTransaction(@RequestBody Transaction transaction) {
		repo.save(transaction);
	}
	
	@GetMapping("/customer/{accNo}/transactions")	
	public List<Transaction> viewTransactions(@PathVariable("accNo") int accNo){
		Optional<Customer> customer = custrepo.findById(accNo);
		if(customer.isPresent())
			return customer.get().getTransactions();
		return null;
	}
	
	@GetMapping("/customer/{accNo}/transaction/{id}")
	public Optional<Transaction> getTransactions(@PathVariable int id){		
		Optional<Transaction> transaction = repo.findById(id);	
		return transaction;
	}
	
	@DeleteMapping("/customer/{accNo}/transaction/{id}")
	public void deleteTransaction(@PathVariable int id) {
		repo.deleteById(id);
	}
	
	@PutMapping("/customer/{accNo}/transaction/{id}")
	public void updateTransaction(@RequestBody Transaction transaction){
		repo.save(transaction);
	}
	
	
}
