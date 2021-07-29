package com.example.event.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.event.model.LoginDetails;
import com.example.event.services.LoginDetailsService;

@RestController
public class LoginDetailsController {
	
	@Autowired
	LoginDetailsService service;
	
	@PostMapping("/login")
	public boolean validateCredentials(@RequestBody LoginDetails cred)
	{
		return service.validateCredentails(cred);
	}
	
	@PostMapping("/createcred")
	public boolean addNewCredentials(@RequestBody LoginDetails cred)
	{
		return service.createCredentails(cred);
	}
	

}
