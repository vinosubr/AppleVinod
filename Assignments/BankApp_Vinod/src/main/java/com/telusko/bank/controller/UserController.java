package com.telusko.bank.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.bank.model.Admin;
import com.telusko.bank.model.AdminRepo;
import com.telusko.bank.model.Customer;
import com.telusko.bank.model.CustomerRepo;
import com.telusko.bank.model.Transaction;

@Controller
public class UserController {
	@Autowired
	CustomerRepo repo;
	@Autowired
	AdminRepo adminrepo;
	
	@ModelAttribute("customer5")
	public Customer getCustomer()
	{
		Customer customer = new Customer();
		customer.setBalance(1000);		
		return customer;
	}
	
	@ModelAttribute("admin5")
	public Admin getAdmin()
	{
		Admin admin = new Admin();		
		return admin;
	}
	
	@RequestMapping("/")
	public ModelAndView showCustomer(ModelAndView mv,HttpSession session){
		session.setAttribute("test", "Hello World");
		List<Customer> customers = (List<Customer>)repo.findAll();
		mv.addObject("customers", customers);
		mv.setViewName("addCustomer");
		return mv;		
	}
	
	@RequestMapping("/customer")
	public ModelAndView showCustomer1(ModelAndView mv,HttpSession session){
		session.setAttribute("test", "Hello World");
		List<Customer> customers = (List<Customer>)repo.findAll();
		mv.addObject("customers", customers);
		mv.setViewName("addCustomer");
		return mv;		
	}
	
	@RequestMapping("/admin")
	public ModelAndView showAdmin(ModelAndView mv,HttpSession session){
		List<Admin> admins = (List<Admin>)adminrepo.findAll();
		mv.addObject("admins", admins);
		mv.setViewName("addAdmin");
		return mv;
	}
	
	
	@PostMapping("/addCustomer")
	public ModelAndView addCustomer(@ModelAttribute("customer") Customer customer,ModelAndView mv,HttpSession session) {		
		//Add Alien to Database
		customer.setBalance(1000);
		Transaction initAccount = new Transaction("Initial Deposit",1000,0,1000);
		customer.getTransactions().add(initAccount);
		repo.save(customer);
		//Find All Aliens
		List<Customer> customers = (List<Customer>)repo.findAll();
		mv.addObject("customers", customers);
		mv.setViewName("addCustomer");
		return mv;
	}
	
	@PostMapping("/addAdmin")
	public ModelAndView addAdmin(@ModelAttribute("admin") Admin admin,ModelAndView mv,HttpSession session) {		
		//Add Alien to Database
		adminrepo.save(admin);
		//Find All Aliens
		List<Admin> admins = (List<Admin>)adminrepo.findAll();
		mv.addObject("admins", admins);
		mv.setViewName("addAdmin");
		return mv;
	}
}
