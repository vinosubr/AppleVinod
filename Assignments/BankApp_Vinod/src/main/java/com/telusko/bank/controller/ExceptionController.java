package com.telusko.bank.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController 
{
	@ExceptionHandler(ArithmeticException.class)
	public String handleArithmeticException(Model m, Exception e)
	{
		System.out.println("something went wrong...");
		m.addAttribute("exception", e);
		return "exception";
	}
	@ExceptionHandler(RuntimeException.class)
	public String handleRuntimeException(Model m, Exception e)
	{
		System.out.println("runtime exception ...");
		m.addAttribute("exception", e);
		return "exception";
	}
}
