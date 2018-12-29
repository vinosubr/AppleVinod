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

import com.telusko.bank.model.Admin;
import com.telusko.bank.model.AdminRepo;
import com.telusko.bank.model.Customer;

@RestController
public class AdminController {
	@Autowired
	AdminRepo repo;
	
	@PostMapping("/admin")
	public void addCustomer(@RequestBody Admin admin) {
		repo.save(admin);
	}
	
	@GetMapping("/admins")	
	public List<Admin> viewAdmins(){
		List<Admin> admins = (List<Admin>)repo.findAll();
		return admins;
	}
	
	@GetMapping("/admin/{id}")
	public Optional<Admin> getAdmin(@PathVariable int id){		
		Optional<Admin> admin = repo.findById(id);	
		return admin;
	}
	
	@DeleteMapping("/admin/{id}")
	public void deleteAdmin(@PathVariable int id) {
		repo.deleteById(id);
	}
	
	@PutMapping("/admin/{id}")
	public void updateAdmin(@RequestBody Admin admin){
		repo.save(admin);
	}
	
}
