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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.bank.model.Customer;
import com.telusko.bank.model.CustomerRepo;

@RestController
public class CustomerController {
	@Autowired
	CustomerRepo repo;

	@PostMapping("/customer")
	public void addCustomer(@RequestBody Customer customer) {
		repo.save(customer);
	}
	
	@GetMapping("/customers")	
	public List<Customer> viewCustomers(){
		List<Customer> customers = (List<Customer>)repo.findAll();
		return customers;
	}
	
	@GetMapping("/customer/{id}")
	public Optional<Customer> getCustomers(@PathVariable int id){		
		Optional<Customer> customer = repo.findById(id);	
		return customer;
	}
	
	@DeleteMapping("/customer/{id}")
	public void deleteCustomer(@PathVariable int id) {
		repo.deleteById(id);
	}
	
	@PutMapping("/customer/{id}")
	public void updateCustomer(@RequestBody Customer customer){
		repo.save(customer);
	}
	
}
