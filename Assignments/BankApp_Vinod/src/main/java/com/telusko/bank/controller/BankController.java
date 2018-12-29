package com.telusko.bank.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.telusko.bank.model.Admin;
import com.telusko.bank.model.Customer;
import com.telusko.bank.model.CustomerRepo;
import com.telusko.bank.model.Transaction;
import com.telusko.bank.model.TransactionRepo;
import com.telusko.bank.model.TransferMoney;

@Controller
public class BankController {
	@Autowired
	CustomerRepo custRepo;
	@Autowired
	TransactionRepo transrepo;
	
	@ModelAttribute("transfer5")
	public TransferMoney getTransfer()
	{
		TransferMoney customer = new TransferMoney();				
		return customer;
	}
	
	@RequestMapping("/showTransfer")
	public ModelAndView showTransfer(ModelAndView mv) {
		//Get CustomerList
		List<Customer> customers = custRepo.findAll();
		mv.addObject("customers", customers);
		mv.setViewName("transferMoney");
		return mv;
	}
	@RequestMapping("/transferMoney")
	public ModelAndView transferMoney(@ModelAttribute("transfer") TransferMoney money,ModelAndView mv,HttpSession session) {
		//TransferMoney
		//mv.addObject("customers", customers);
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
		List<Customer> customers = custRepo.findAll();
		mv.addObject("customers", customers);
		mv.addObject("message", "Transferred Successfully");
		mv.setViewName("transferMoney");
		return mv;
	}
	
}
